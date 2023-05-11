package project;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import project.handler.CheckHandler;
import project.handler.SumHandler;

public class HttpJsonServer {

    // server config
    private static final String HOST = "0.0.0.0";
    private static final int PORT = 5678;
    private HttpServer server = null;

    // handler config
    private String CHECK_HANDLER_URL = "/";
    private String SUM_HANDLER_URL = "/sum";

    public HttpJsonServer() throws IOException {
        createServer(HOST, PORT);
    }

    public HttpJsonServer(String host, int port) throws IOException {
        createServer(host, port);
    }

    public void createServer(String host, int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(host, port), 0);
        server.createContext(CHECK_HANDLER_URL, new CheckHandler());
        server.createContext(SUM_HANDLER_URL, new SumHandler());
        this.server = server;
    }

    public void startServer() {
        this.server.start();
    }
}