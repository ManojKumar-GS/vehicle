package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.VehicleCRUD;
import com.js.dto.Vehicle;
@WebServlet(value="/update1")
public class Update1 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehicleCRUD vc=new VehicleCRUD();
		Vehicle v=vc.getVehicleById(Integer.parseInt(req.getParameter("id")));
		if(v!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("viewform.jsp");
			req.setAttribute("veh", v);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "unbale to update");
			rd.forward(req, resp);
		}
	}
}
