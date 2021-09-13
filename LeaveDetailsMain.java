package com.java.test;
import java.text.SimpleDateFormat;  
import java.text.ParseException;   
import java.util.Date;   
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.text.ParseException;   
import java.util.Date;   
import java.text.SimpleDateFormat;  
import java.text.ParseException;   
import java.util.Date;   
public class LeaveDetailsMain {

static Scanner sc = new Scanner(System.in);
static Random rand = new Random();

public static int CalcDaysLeave(Date d1, Date d2)
{
	long time_difference = d2.getTime() - d1.getTime();
	int days_difference = (int) ((time_difference / (1000*60*60*24)) % 365); 
	return days_difference; 
}


public static void addLeave() throws LeaveException, ParseException
{
	int leaveid = rand.nextInt(500);
	
	LeaveDetails ld = new LeaveDetails();
	System.out.println("Enter Employee ID ");
	ld.setEmpId(sc.nextInt());
	
	System.out.println("Enter Leave Start Date in dd/MM/yyyy ");
	String lsd = sc.next();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date d1 = sdf.parse(lsd);
	ld.setLeaveStartDate(d1);
	
	System.out.println("Enter Leave Final Date in dd/MM/yyyy");
	String lfd = sc.next();
	Date d2 = sdf.parse(lfd);
	ld.setLeaveEndDate(d2);
	
	System.out.println("Enter Leave reason");
	ld.setLeaveReason(sc.next());
	
	//No.Of,Days on Leave
	int result = CalcDaysLeave(d1,d2);
	ld.setNoOfDays(result);
	
	
	
	System.out.println("Leave ID Generated");
	ld.setLeaveId(leaveid);
	System.out.println("Leave ID : "+ld.getLeaveId());
	
	//System.out.println("Leave applied on");
	Date d3 = new Date();
	ld.setLeaveAppliedOn(d3);
	LeaveDetailsBAL LDBAL= new LeaveDetailsBAL();
	System.out.println(LDBAL.addLeaveBAL(ld));
	
	
}

public static void showLeave() {
	List<LeaveDetails> listLD= new LeaveDetailsBAL().showLeaveDetailsBAL();
	for (LeaveDetails l : listLD) {
		System.out.println(l);
	}
}

public static void searchLeave() {
	System.out.println("Enter Emp ID   ");
	int empid =sc.nextInt();
	LeaveDetails ld  = new LeaveDetailsBAL().searchLeaveDetailsBAL(empid);
	if (ld!=null) {
		System.out.println(ld);
	} else {
		System.out.println("Leave Details not found" );
	}
}


public static void deleteLeave() {
	System.out.println("Enter Emp ID no   ");
	int empid =sc.nextInt();
	System.out.println(new LeaveDetailsBAL().deleteLeaveDetailsBAL(empid));
}

public static void updateLeave() throws LeaveException, ParseException {
	
	int leaveid = rand.nextInt(500);
	
	LeaveDetails ld = new LeaveDetails();
	System.out.println("Enter Employee ID ");
	ld.setEmpId(sc.nextInt());
	
	System.out.println("Enter Leave Start Date in dd/MM/yyyy ");
	String lsd = sc.next();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date d1 = sdf.parse(lsd);
	ld.setLeaveStartDate(d1);
	
	System.out.println("Enter Leave Final Date in dd/MM/yyyy");
	String lfd = sc.next();
	Date d2 = sdf.parse(lfd);
	ld.setLeaveEndDate(d2);
	
	System.out.println("Enter Leave reason");
	ld.setLeaveReason(sc.next());
	
	//No.Of,Days on Leave
	int result = CalcDaysLeave(d1,d2);
	ld.setNoOfDays(result);
	
	
	
	System.out.println("New Leave ID Generated");
	ld.setLeaveId(leaveid);
	System.out.println(leaveid);
	
	//System.out.println("Leave applied on");
	Date d3 = new Date();
	ld.setLeaveAppliedOn(d3);
	LeaveDetailsBAL LDBAL= new LeaveDetailsBAL();
	System.out.println(LDBAL.updateLeaveDetailsBAL(ld));
	
	
}


public static void main(String[] args) throws ParseException {
	int ch;
	do {
		System.out.println("O P T I O N S");
		System.out.println("--------------");
		System.out.println("1. Add Leave");
		System.out.println("2. Show Leave");
		System.out.println("3. Search Leave");
		System.out.println("4. Delete Leave");
		System.out.println("5. Update Leave");

		ch = sc.nextInt();
		switch(ch) {
		case 1 :
			try {
				addLeave();
			} catch (LeaveException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2 : 
			showLeave();
			break;
		case 3 :
			searchLeave();
			break;
		case 4:
			deleteLeave();
			break;
		case 5:
			try {
				updateLeave();
			} catch (LeaveException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		}
		
	} while(ch!=6);


}
}
