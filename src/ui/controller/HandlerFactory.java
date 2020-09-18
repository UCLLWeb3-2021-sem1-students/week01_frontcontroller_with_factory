package ui.controller;

import domain.service.CountryService;

public class HandlerFactory {

    public RequestHandler getHandler(String handlerName, CountryService model) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui.controller."+ handlerName);
            // Java 8/9
            Object handlerObject = handlerClass.newInstance();
            // Java 10
            // Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!!!!");
        }

        return handler;
    }

}
