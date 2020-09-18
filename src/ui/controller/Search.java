package ui.controller;

import domain.model.Country;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Country country = service.getCountryWithName(name);
        if (country != null) {
            request.setAttribute("country", country);
            return "countrySearchResult.jsp";
        }
        return "countrySearch.jsp";
    }
}
