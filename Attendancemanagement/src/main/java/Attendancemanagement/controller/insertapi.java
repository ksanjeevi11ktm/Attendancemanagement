package Attendancemanagement.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Attendancemanagement.classes.attrecord;
import Attendancemanagement.classes.student;
import Attendancemanagement.classes.subject;
import Attendancemanagement.classes.teacher;
import Attendancemanagement.insertrecord.insertrecord;


@RestController
@RequestMapping("/insertrecords")

@CrossOrigin(origins = "http://localhost:3001")

public class insertapi {
	
insertrecord insertobj = new insertrecord();
	
	@PostMapping("/students")
	public void insertstudtable(@RequestBody ArrayList<student> studentlist)
	{	
		insertobj.insertstudtable("studenttbl",studentlist);	
	}
	@PostMapping("/subjects")
	public void insertsubtable(@RequestBody ArrayList<subject> subjectlist)
	{	
		insertobj.insertsubtable("subjecttbl",subjectlist);	
	}
	@PostMapping("/teacher")
	public void insertteachtable(@RequestBody ArrayList<teacher> teacherlist)
	{	
		for ( teacher a: teacherlist)
		{
			System.out.println(a);
		}
		insertobj.insertteachtable("teachertbl",teacherlist);	
		
	}
	@PostMapping("/attendance")
	public void insertattendancetable(@RequestBody ArrayList<attrecord> recordlist)
	{	
		insertobj.insertrecordtable("recordtbl",recordlist);	
	}
	
	

}
