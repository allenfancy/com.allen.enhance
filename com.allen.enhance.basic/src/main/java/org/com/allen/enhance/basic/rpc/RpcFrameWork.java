package org.com.allen.enhance.basic.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFrameWork {

    @SuppressWarnings("resource")
    public static void export(final Object service, int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                input = new ObjectInputStream(socket.getInputStream());
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] paramValue = (Object[]) input.readObject();
                Method method = service.getClass().getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, paramValue);
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            } catch (Exception e) {

            } finally {
                try {
                    output.close();
                    input.close();
                    socket.close();
                } catch (Exception e) {
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<?> interfaceClazz, final String host, final int port)
            throws IOException {
        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                new Class<?>[] {interfaceClazz}, new InvocationHandler() {
                    private Socket socket;
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        socket = new Socket(host, port);
                        ObjectOutputStream output =
                                new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        return in.readObject();
                    }
                });
    }
}
