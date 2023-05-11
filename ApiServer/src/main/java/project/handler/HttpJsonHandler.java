package project.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import project.utils.JsonConverter;

public abstract class HttpJsonHandler<T> implements HttpHandler {

    private static final String[] ALLOWED_METHODS = {"GET"};

    // header
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String JSON_CONTENT_TYPE = "application/json";

    JsonConverter converter = new JsonConverter();

    // resp status
    private static final int STATUS_OK = 200;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if (!isValidRequest(method)) return;

        // header config
        String response = createResponse();
        Headers header = exchange.getResponseHeaders();
        header.add(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE);
        exchange.sendResponseHeaders(STATUS_OK, response.length());

        // send resp
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private boolean isValidRequest(String method) {
        for (String allowedMethod : ALLOWED_METHODS) {
            if (method.equals(allowedMethod)) return true;
        }
        return false;
    }

    private String createResponse() throws JsonProcessingException {
        T message = createMessage();
        return convertToJson(message);
    };

    private String convertToJson(T message) throws JsonProcessingException {
        return converter.readAsString(message);
    }

    abstract T createMessage();
}