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

@WebServlet(value = "/insert")
public class InsertVehicle extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vehicle v=new Vehicle();
		v.setVid(Integer.parseInt(req.getParameter("id")));
		v.setVname(req.getParameter("name"));
		v.setVcolor(req.getParameter("color"));
		v.setCc(Integer.parseInt(req.getParameter("cc")));
		v.setMilage(Integer.parseInt(req.getParameter("milage")));
		v.setNoseat(Integer.parseInt(req.getParameter("nos")));
		
		VehicleCRUD vc=new VehicleCRUD();
		if(vc.insertVehicle(v)>0) {
			RequestDispatcher rq=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "VEHICLE REGISTERED SUCCESSFULLY");
			rq.forward(req, resp);
		}else {
			RequestDispatcher rq=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "VEHICLE REGISTERATION FAILED");
			rq.forward(req, resp);
		}
	}
}
