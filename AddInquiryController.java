package com.ims.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.model.DAOServiceImpl;

@WebServlet("/addInquiry")
public class AddInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddInquiryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/add_inquiry.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	    String mobile = request.getParameter("mobile");
		String course = request.getParameter("course");
		
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDB();
		service.addInquiry(name, email,mobile, course);
		request.setAttribute("msg", "Record is saved!!");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/add_inquiry.jsp");
		rd.forward(request, response);
	}

}
