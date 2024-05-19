package Attendancemanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Attendancemanagement.classes.attrecord;
import Attendancemanagement.classes.student;
import Attendancemanagement.classes.subject;
import Attendancemanagement.classes.teacher;
import Attendancemanagement.deleterecord.deleterecord;
import Attendancemanagement.insertrecord.insertrecord;
import Attendancemanagement.updaterecord.updaterecord;
import Attendancemanagement.viewrecord.viewrecord;



public class attendance {
	
	public void mainmethod() 
			throws IOException
	{

		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		String option;
		String formatdate="yyyy-MM-dd";
		DateTimeFormatter dtformat= DateTimeFormatter.ofPattern(formatdate);

		insertrecord insertobj=new insertrecord();
		deleterecord deleteobj=new deleterecord();
		updaterecord updateobj = new updaterecord();
		viewrecord viewobj = new viewrecord();

		// getting user input for subject and insert in to subject table
		System.out.println("Do You want to add Subject Name ");
		option=input.readLine();
		while(option.equals("yes")||option.equals("y"))
		{
			ArrayList<subject> subjectlist = new ArrayList<subject>();
			System.out.println("Enter Subject Name");
			String subjects=input.readLine();
			String subjectsarr[]=subjects.split(",");
			for (String a: subjectsarr)
			{
				subject obj1=new subject();
				obj1.setSubjectname(a);
				subjectlist.add(obj1);
			}
			insertobj.insertsubtable("subjecttbl",subjectlist);

			System.out.println("Do You want to continue ");
			option=input.readLine();
		}

		//getting teacher and subjects to insert in to teacher table with sub id
		System.out.println("Do You want to add teacher and subject (yes/y)");
		option=input.readLine();
		while(option.equals("yes")||option.equals("y"))
		{
			ArrayList<teacher> teacherlist = new ArrayList<teacher>();
			System.out.println("Enter one Teacher Name and Subject");
			String teachers=input.readLine();
			String teachersarr[]=teachers.split(",",2);
			teacher obj1=new teacher();
			System.out.println(teachersarr.length);
			obj1.setTeachername(teachersarr[0]);
			obj1.setSubjectname(teachersarr[1]);
			teacherlist.add(obj1);
			insertobj.insertteachtable("teachertbl",teacherlist);

			System.out.println("Do You want to continue to add teacher (yes/y)");
			option=input.readLine();
		}
		// getting student name and insert into student and dates,presence,subid,student id in to record table

		System.out.println("Do You want to Enter Record Details");
		option=input.readLine();

		while(option.equals("yes")||option.equals("y"))
		{
			ArrayList<student> studentlist = new ArrayList<student>();
			ArrayList<attrecord> recordlist = new ArrayList<attrecord>();
			student obj1=new student();
			attrecord obj2= new attrecord();
			System.out.println("Enter Student Name");
			String name=input.readLine();
			obj1.setStudentname(name);
			obj2.setStudentname(name);
			System.out.println("Enter Subject");
			String subject=input.readLine();
			obj2.setSubjectname(subject);
			System.out.println("Enter Date");
			String date=(input.readLine());
			try
			{
				LocalDate dt=LocalDate.parse(date,dtformat);
				obj2.setDate(date);
			}
			catch (Exception e)
			{
				System.out.println("Invalid date format: "+ date +" and correct format is "+ formatdate); 
			}
			System.out.println("Enter Student Presence (Y/N)");
			String presence=input.readLine();
			obj2.setPresence(presence);
			studentlist.add(obj1);
			recordlist.add(obj2);

			insertobj.insertstudtable("studenttbl",studentlist);
			insertobj.insertrecordtable("recordtbl",recordlist);

			System.out.println("Do You want to continue ");
			option=input.readLine();
		}

		System.out.println("Do You want to display Record Details");
		option=input.readLine();

		while(option.equals("yes")||option.equals("y"))
		{
			System.out.println(
					"A: Display datas for student\n"+
							"B: Display Records of Subject\n"+
							"C: Display Attendance Record by Each Student\n"+
							"D: Display Attendance Record by Each Student\n"+
							"E: Display Attendance record by dates"
					);
			option=input.readLine();

			switch(option)
			{
			case "a":
			{
				System.out.println("Enter the Student Name to View Records : ");
				String studentname=input.readLine();
				viewobj.displayperstudent(studentname);
				break;
			}
			case "b":
			{
				System.out.println("Enter the Subject Name to View Records : ");
				String subjectname=input.readLine();
				viewobj.displaypersubject(subjectname);
				break;
			}
			case "c":
			{
				System.out.println("Each Students : ");
				viewobj.displayrecordsbystudent();
				break;
			}
			case "d":
			{
				System.out.println("Each Subjects : ");
				viewobj.displayrecordsbysubject();
				break;
			}
			case "e":
			{
				System.out.println("Enter the From and to Date want to view records  : ");
				String name=input.readLine();
				String datesarr[]=name.split(",",2);
				viewobj.displayrecordsbetween(datesarr[0],datesarr[1]);
				break;
			}

			}
			System.out.println("Do You want to display Record Details");
			option=input.readLine();
		}

		System.out.println("Do You want to delete/update Record Details");
		option=input.readLine();

		while(option.equals("yes")||option.equals("y"))
		{
			
			System.out.println(
					"A: Delete Attendance Records"+
							"B: Delete a Student\n"+
							"C: Delete a Subject\n"+
							"D: Update the subject name\n"+
							"E: Display Attendance record percentage of student\n"+
							"F: Insert Attendance record by one by one for one subject and date" 
					);
			option=input.readLine();

			switch(option)
			{
			case "a":
			{
				attrecord atobj1=new attrecord();
				System.out.println("Enter Date : ");
				String date= input.readLine();
				System.out.println("Enter Student Name : ");
				String studentname= input.readLine();
				System.out.println("Enter Subject Name : ");
				String subjectname= input.readLine();
				atobj1.setStudentname(studentname);
				atobj1.setDate(date);
				atobj1.setSubjectname(subjectname);
			
				deleteobj.deleteattendancerecord(atobj1);
				break;
			}
			case "b":
			{
				student stobj1=new student();
				System.out.println("Enter Student Name want to delete : ");
				String studentname= input.readLine();
				stobj1.setStudentname(studentname);
				deleteobj.deletestudent(stobj1);
				break;
			}
			case "c":
			{
				subject subnameobj=new subject();
				System.out.println("Enter Subjectt Name want to delete : ");
				String subjectname= input.readLine();
				subnameobj.setSubjectname(subjectname);
				deleteobj.deletesubject(subnameobj);

				break;
			}
			case "d":
			{
			
				//update subject name
				System.out.println("Enter Subject Name want to update and updated name (,) : ");
				String subjectname= input.readLine();
				String subjectnamesarr[]=subjectname.split(",",2);
				updateobj.updatesubject(subjectnamesarr[0],subjectnamesarr[1]);
				break;
			}
			case "e":
			{
				//GET ATTENDANCE PERCENTAGE
				System.out.println("Enter Student Name to view attendance percentage : ");
				String studentname= input.readLine();
				viewobj.attpercentage(studentname);
				break;
			}
			case "f":
			{

				attrecord atupd_obj=new attrecord();
				System.out.println("Enter Date : ");
				String date= input.readLine();
				System.out.println("Enter Subject Name : ");
				String subjectname= input.readLine();
				atupd_obj.setDate(date);
				atupd_obj.setSubjectname(subjectname);
				updateobj.updateattendance(atupd_obj);
				break;
			}

			}
			System.out.println("Do You want to display Record Details");
			option=input.readLine();
		}
	}



}
