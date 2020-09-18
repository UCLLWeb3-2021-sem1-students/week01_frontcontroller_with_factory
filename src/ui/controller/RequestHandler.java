package ui.controller;

import domain.service.CountryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    protected CountryService service;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public void setModel (CountryService countryService) {
        this.service = countryService;
    }

    public CountryService getService() {
        return service;
    }


}
