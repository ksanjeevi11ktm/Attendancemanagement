package Attendancemanagement.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Attendancemanagement.classes.attrecord;
import Attendancemanagement.classes.student;
import Attendancemanagement.classes.subject;
import Attendancemanagement.deleterecord.*;

@RestController
@RequestMapping("/deleterecords")

@CrossOrigin(origins = "http://localhost:3001")

public class deleteapi {
deleterecord delobj=new deleterecord();
	
	@DeleteMapping ("/subject")
	public void deletesubject(@RequestBody subject subjects)
	{
		delobj.deletesubject(subjects);
	}
	
	@DeleteMapping ("/student")
	public void deletestudent(@RequestBody student students)
	{
		System.out.println(students.getStudentname()+";stud;;;");
		delobj.deletestudent(students);
	}
	
	@DeleteMapping ("/attendance")
	public void deleteattendancerecord(@RequestBody attrecord records)
	{
		
		delobj.deleteattendancerecord(records);
	}
}
