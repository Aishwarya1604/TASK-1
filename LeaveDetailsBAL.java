package com.java.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LeaveDetailsBAL {

	static StringBuilder sb = new StringBuilder();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date today = new Date();

	public boolean validateLeave(LeaveDetails ld)
	{
		boolean isApplied = true;
		if(today.after(ld.getLeaveStartDate()))
		{
			isApplied = false;
			sb.append("Start leave cannot be yesterday's date\n");
		}
		if(today.after(ld.getLeaveEndDate()))
		{
			isApplied = false;
			sb.append("End leave cannot be yesterday's date\n");
		}
		if(ld.getLeaveStartDate().after(ld.getLeaveEndDate()))
		{
			isApplied = false;
			sb.append("Incorrect dates applied for leave and start together\n");
		}
		return isApplied;
	}
	
	public String addLeaveBAL(LeaveDetails ld) throws LeaveException
	{
		if (validateLeave(ld)==true)
		{
			return new LeaveDetailsDAO().addLeaveDetailsDAO(ld);
		} else{
			throw new LeaveException(sb.toString());
		}
	}
	
	public List<LeaveDetails> showLeaveDetailsBAL() {
		return new LeaveDetailsDAO().showLeaveDetailsDAO();
	}
	
	public LeaveDetails searchLeaveDetailsBAL(int empid) {
		return new LeaveDetailsDAO().searchLeaveDetailsDAO(empid);
	}
	
	public String deleteLeaveDetailsBAL(int leaveid) {
		return new LeaveDetailsDAO().deleteLeaveDetailsDAO(leaveid);
	}
	
	public String updateLeaveDetailsBAL(LeaveDetails ld) throws LeaveException {
		if (validateLeave(ld) == true) {
			return new LeaveDetailsDAO().updateLeaveDetailsDAO(ld);
		} else {
			throw new LeaveException(sb.toString());
		}
	}
	
}
