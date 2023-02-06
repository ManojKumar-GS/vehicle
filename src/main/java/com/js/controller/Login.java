package com.js.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/login")
public class Login extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		if(email.equals("manojkumar@gmail.com")&&pass.equals("12345")) {
			HttpSession hs=req.getSession();
			hs.setAttribute("login", "hai");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			req.setAttribute("msg", "input username or password is wrong");
			rd.include(req, resp);
		}
	}
}
