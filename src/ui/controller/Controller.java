package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.model.Country;
import domain.service.CountryService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryService service = new CountryService();
	private HandlerFactory handlerFactory = new HandlerFactory();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String destination = "index.html";
		if (command != null) {
			try {
				RequestHandler handler = handlerFactory.getHandler(command, service);
				destination = handler.handleRequest(request, response);
			} catch (Exception exc) {
				request.setAttribute("error", exc.getMessage());
				destination = "error.jsp";
			}
		}
		request.getRequestDispatcher(destination).forward(request, response);
	}
}
