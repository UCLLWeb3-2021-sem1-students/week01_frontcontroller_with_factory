package ui.controller;

import domain.model.Country;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Add extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Country country = new Country();

        List<String> result = new ArrayList<String>();
        getName(country, request, result);
        getCapital(country, request, result);
        getNumberOfInhabitants(country, request, result);
        getNumberOfVotes(country, request, result);

        String destination;
        if (result.size() > 0) {
            request.setAttribute("result", result);
            destination = "countryAdd.jsp";
        }
        else {
            service.addCountry(country);
            destination = "Controller?command=Overview";
        }

        return destination;
    }

    private void getName(Country country, HttpServletRequest request, List<String> result) {
        String name = request.getParameter("name");
        request.setAttribute("namePreviousValue", name);
        try {
            country.setName(name);
            request.setAttribute("nameClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("nameClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    private void getCapital(Country country, HttpServletRequest request, List<String> result) {
        String capital = request.getParameter("capital");
        request.setAttribute("capitalPreviousValue", capital);
        try {
            country.setCapital(capital);
            request.setAttribute("capitalClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("capitalClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    private void getNumberOfVotes(Country country, HttpServletRequest request, List<String> result) {
        String votes = request.getParameter("votes");
        request.setAttribute("votesPreviousValue", votes);
        try {
            int numberOfVotes = Integer.parseInt(votes);
            country.setVotes(numberOfVotes);
            request.setAttribute("votesClass", "has-success");
        }
        catch (NumberFormatException exc) {
            request.setAttribute("votesClass", "has-error");
            result.add("Please enter a valid number of votes!");
        }
        catch (Exception exc) {
            request.setAttribute("votesClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    private void getNumberOfInhabitants(Country country, HttpServletRequest request, List<String> result) {
        String inhabitants = request.getParameter("inhabitants");
        request.setAttribute("inhabitantsPreviousValue", inhabitants);
        try {
            int numberOfInhabitants = Integer.parseInt(inhabitants);
            country.setNumberInhabitants(numberOfInhabitants);
            request.setAttribute("inhabitantsClass", "has-success");
        }
        catch (NumberFormatException exc) {
            request.setAttribute("inhabitantsClass", "has-error");
            result.add("Please enter a valid number of inhabitants!");
        }
        catch (Exception exc) {
            request.setAttribute("inhabitantsClass", "has-error");
            result.add(exc.getMessage());
        }
    }
}
