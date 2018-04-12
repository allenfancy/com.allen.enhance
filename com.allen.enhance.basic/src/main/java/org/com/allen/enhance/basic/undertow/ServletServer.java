package org.com.allen.enhance.basic.undertow;

import javax.servlet.ServletException;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;
import io.undertow.servlet.api.ServletInfo;

public class ServletServer {

    public static void main(String[] args) {
        
        // 1. Servlet信息
        ServletInfo servletInfo1 = Servlets.servlet("MyServlet", MyServlet.class);
        servletInfo1.addInitParam("message", "this is my first Servlet!");
        servletInfo1.addMapping("/myServlet");

        // 2. 部署信息
        DeploymentInfo deploymentInfo1 = Servlets.deployment();
        // 2.1 类加载
        deploymentInfo1.setClassLoader(ServletServer.class.getClassLoader());
        // 2.2 contextPath
        deploymentInfo1.setContextPath("/myapp");
        // 2.3 Deployment的名称
        deploymentInfo1.setDeploymentName("myServlet.war");
        // 2.4 添加Servlets信息
        deploymentInfo1.addServlets(servletInfo1);

        // 3. Servlet容器
        ServletContainer container = Servlets.defaultContainer();
        DeploymentManager manager = container.addDeployment(deploymentInfo1);
        // 实施部署
        manager.deploy();
        /**
         * 分发器：将用户请求分发给对应的HttpHandler
         */
        PathHandler pathHandler = Handlers.path();
        /**
         * servlet path处理器，DeploymentManager启动后返回的Servlet处理器。
         */
        HttpHandler myApp = null;
        try {
            // 启动容器，生成请求处理器
            myApp = manager.start();
        } catch (ServletException e) {
            throw new RuntimeException("容器启动失败！");
        }
        // 绑定映射关系
        pathHandler.addPrefixPath("/myapp", myApp);

        Undertow server = Undertow.builder().
        // 绑定端口号和主机
                addHttpListener(8081, "localhost")
                // 设置分发处理器
                .setHandler(pathHandler).build();
        // 启动server
        server.start();
    }
}
