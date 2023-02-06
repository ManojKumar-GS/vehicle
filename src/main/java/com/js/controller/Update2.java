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

@WebServlet(value = "/update2")
public class Update2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vehicle v=new Vehicle();
		v.setVid(Integer.parseInt(req.getParameter("id")));
		v.setVname(req.getParameter("name"));
		v.setVcolor(req.getParameter("color"));
		v.setCc(Integer.parseInt(req.getParameter("cc")));
		v.setMilage(Integer.parseInt(req.getParameter("milage")));
		v.setNoseat(Integer.parseInt(req.getParameter("nos")));
		
		VehicleCRUD vc=new VehicleCRUD();
		if(vc.updateVehicle(Integer.parseInt(req.getParameter("id")), v)>0) {
			RequestDispatcher rd=req.getRequestDispatcher("viewall");
			req.setAttribute("veh", v);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "failed to update");
			rd.forward(req, resp);
		}
	}
}
