package com.java.test;

import java.util.ArrayList;
import java.util.List;

public class LeaveDetailsDAO {
	
	static List<LeaveDetails> lstLeaveDetails;
	
	static {
		lstLeaveDetails = new ArrayList<LeaveDetails>();
	}
	
	
	public String addLeaveDetailsDAO(LeaveDetails ld)
	{
		lstLeaveDetails.add(ld);
		return "Leave added successfully";
	}
	
	public List<LeaveDetails> showLeaveDetailsDAO() {
		return lstLeaveDetails;
	}
	
	public LeaveDetails searchLeaveDetailsDAO(int empid) {
		LeaveDetails result = null;
		for (LeaveDetails ld : lstLeaveDetails) {
			if (ld.getEmpId()==empid) {
				result=ld;
				break;
			}
		}
		return result;
	}
	
	public String deleteLeaveDetailsDAO(int empid) {
		LeaveDetails ld = searchLeaveDetailsDAO(empid);
		if (ld != null) {
			lstLeaveDetails.remove(ld);
			return "Leave Record Deleted Successfully";
		} 
		return "Leave Record Not Found";
	}
	
	public String updateLeaveDetailsDAO(LeaveDetails ldnew) {
		LeaveDetails ldold = searchLeaveDetailsDAO(ldnew.getEmpId());
		if (ldold != null) {
			ldold.setEmpId(ldnew.getEmpId());
			ldold.setLeaveAppliedOn(ldnew.getLeaveAppliedOn());
			ldold.setLeaveStartDate(ldnew.getLeaveStartDate());
			ldold.setLeaveEndDate(ldnew.getLeaveEndDate());
			ldold.setLeaveReason(ldnew.getLeaveReason());
			ldold.setLeaveId(ldnew.getLeaveId());
			ldold.setNoOfDays(ldnew.getNoOfDays());
			
			return "Record Updated Successfully";
		}
		return "Leave Record Not Found";
		
	}

}
