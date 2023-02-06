package com.js.dto;

public class Vehicle {
	private int vid;
	private String vname;
	private String vcolor;
	private int cc;
	private int milage;
	private int noseat;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVcolor() {
		return vcolor;
	}
	public void setVcolor(String vcolor) {
		this.vcolor = vcolor;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getMilage() {
		return milage;
	}
	public void setMilage(int milage) {
		this.milage = milage;
	}
	public int getNoseat() {
		return noseat;
	}
	public void setNoseat(int noseat) {
		this.noseat = noseat;
	}
	public String toString() {
		return "Vehicle [vid=" + vid + ", vname=" + vname + ", vcolor=" + vcolor + ", cc=" + cc + ", milage=" + milage
				+ ", noseat=" + noseat + "]";
	}
	
}
