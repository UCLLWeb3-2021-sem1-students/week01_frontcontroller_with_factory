package ui.controller;

import domain.model.Country;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Overview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Country mostPopular = service.getMostPopularCountry();
        request.setAttribute("popular", mostPopular);
        List<Country> countries  = service.getCountries();
        request.setAttribute("countries", countries);
        return "countryOverview.jsp";
    }
}
