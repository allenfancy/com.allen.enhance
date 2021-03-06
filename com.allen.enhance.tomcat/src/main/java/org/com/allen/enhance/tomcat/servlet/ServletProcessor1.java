package org.com.allen.enhance.tomcat.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor1 {
    public void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);
            String repository =
                    new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(servletName==null || "".equals(servletName)) {
            throw new RuntimeException();
        }
        Class<?> myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (myClass == null) {
            throw new RuntimeException();
        }
        Servlet servlet = null;
        try {
            servlet = (Servlet) myClass.newInstance();
            if (servlet == null) {
                throw new RuntimeException();
            }
            servlet.service((ServletRequest) request, (ServletResponse) response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
