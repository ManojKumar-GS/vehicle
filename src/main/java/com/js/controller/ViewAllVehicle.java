package com.js.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.VehicleCRUD;
import com.js.dto.Vehicle;
@WebServlet(value="/viewall")
public class ViewAllVehicle extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehicleCRUD vc= new VehicleCRUD();
		ArrayList<Vehicle> veh= vc.getAllVehicle();
		if(veh!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
			req.setAttribute("data", veh);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "NO VEHICLE AVAILABLE");
			rd.forward(req, resp);
		}
	}
}
