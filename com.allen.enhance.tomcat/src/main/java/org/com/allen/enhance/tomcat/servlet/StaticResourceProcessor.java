package org.com.allen.enhance.tomcat.servlet;

/**
 * @author allen.wu
 */
public class StaticResourceProcessor {

    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
