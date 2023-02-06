package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.VehicleCRUD;
@WebServlet(value="/delete")
public class DeleteVehicle extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehicleCRUD vc=new VehicleCRUD();
		if(vc.deleteVehicle(Integer.parseInt(req.getParameter("id")))>0) {
			RequestDispatcher rd=req.getRequestDispatcher("viewall");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "unable to delete");
			rd.forward(req, resp);
		}
	}
}
