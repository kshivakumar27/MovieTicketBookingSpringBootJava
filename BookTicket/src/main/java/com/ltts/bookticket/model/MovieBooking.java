package com.ltts.bookticket.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class MovieBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mname;
	private String Show_m;
	private String type_m;
	private Date dob;
	private int ntickets;
	public MovieBooking(String mname, String show_m, String type_m, Date dob, int ntickets) {
		super();
		this.mname = mname;
		Show_m = show_m;
		this.type_m = type_m;
		this.dob = dob;
		this.ntickets = ntickets;
	}
	public MovieBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getShow_m() {
		return Show_m;
	}
	public void setShow_m(String show_m) {
		Show_m = show_m;
	}
	public String getType_m() {
		return type_m;
	}
	public void setType_m(String type_m) {
		this.type_m = type_m;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getNtickets() {
		return ntickets;
	}
	public void setNtickets(int ntickets) {
		this.ntickets = ntickets;
	}
	@Override
	public String toString() {
		return "MovieBooking [id=" + id + ", mname=" + mname + ", Show_m=" + Show_m + ", type_m=" + type_m + ", dob="
				+ dob + ", ntickets=" + ntickets + "]";
	}

	
}
