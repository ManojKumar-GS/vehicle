package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Vehicle;

public class VehicleCRUD {
	final static String path="com.mysql.cj.jdbc.Driver";
	final static String address="jdbc:mysql://localhost:3306/jdbc_vehicle?user=root&password=Manoj@195";
	static Connection c;
	public int insertVehicle(Vehicle v) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("insert into vehicle value(?,?,?,?,?,?)");
			ps.setInt(1, v.getVid());
			ps.setString(2, v.getVname());
			ps.setString(3, v.getVcolor());
			ps.setInt(4, v.getCc());
			ps.setInt(5, v.getMilage());
			ps.setInt(6, v.getNoseat());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int deleteVehicle(int id) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("delete from vehicle where v_id=?");
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	public int updateVehicle(int id,Vehicle v) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("update vehicle set v_name=?,v_color=?,v_cc=?,v_milage=?,no_of_seat=? where v_id=?");
			ps.setString(1, v.getVname());
			ps.setString(2, v.getVcolor());
			ps.setInt(3, v.getCc());
			ps.setInt(4, v.getMilage());
			ps.setInt(5, v.getNoseat());
			ps.setInt(6, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Vehicle getVehicleById(int id) {
		Vehicle v=null;
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("select * from vehicle where v_id=?");
			ps.setInt(1, id);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				v=new Vehicle();
				v.setVid(res.getInt(1));
				v.setVname(res.getString(2));
				v.setVcolor(res.getString(3));
				v.setCc(res.getInt(4));
				v.setMilage(res.getInt(5));
				v.setNoseat(res.getInt(6));
				return v;
			}else
				return v;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return v;
		
	}
	public ArrayList<Vehicle> getAllVehicle(){
		ArrayList<Vehicle> av=new ArrayList<>();
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("select * from vehicle");
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				Vehicle v=new Vehicle();
				v.setVid(res.getInt(1));
				v.setVname(res.getString(2));
				v.setVcolor(res.getString(3));
				v.setCc(res.getInt(4));
				v.setMilage(res.getInt(5));
				v.setNoseat(res.getInt(6));
				av.add(v);
			}
			return av;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return av;
	}
	public boolean batchExecution(ArrayList<Vehicle> veh) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("insert into vehicle values(?,?,?,?,?,?)");
			for (Vehicle v : veh) {
				ps.setInt(1, v.getVid());
				ps.setString(2, v.getVname());
				ps.setString(3, v.getVcolor());
				ps.setInt(4, v.getCc());
				ps.setInt(5, v.getMilage());
				ps.setInt(6, v.getNoseat());
				ps.addBatch();
			}
			ps.executeBatch();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
