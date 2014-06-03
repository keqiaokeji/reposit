package com.keqiaokeji.tezizai.web.test;


import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 *
 */
public class JettyMainSvc {
    public static void main(String[] args) throws Exception {
        //配置访问路径如http://localhost:8082/TeZiZai-web/index.jsp的服务器
        Server jettyServer = new Server();
        SocketConnector conn = new SocketConnector();
        conn.setPort(8082);//启动的服务器端口号
        jettyServer.setConnectors(new Connector[]{conn});

        WebAppContext wah = new WebAppContext();
        wah.setContextPath("/TeZiZai-svc");//项目名称
        wah.setWar("src/main/webapp");//web目录
//        wah.setWar("TeZiZai-web/src/main/webapp");//如果没有配置JettyMain--> Edit Configurations...-->Working directory 则需使用该路径
        jettyServer.setHandler(wah);
        jettyServer.start();
    }


}
