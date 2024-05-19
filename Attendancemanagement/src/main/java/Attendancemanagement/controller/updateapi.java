package Attendancemanagement.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Attendancemanagement.classes.subject;
import Attendancemanagement.updaterecord.updaterecord;



@RestController
@RequestMapping("/updaterecords")
@CrossOrigin(origins = "http://localhost:3001")

public class updateapi {
	
	updaterecord updateobj = new updaterecord();
	@PutMapping("/attendance")
	public void updatesubject(subject object,subject newobject)
	{	
		subject obj= new subject();
		subject newobj=new subject();
		obj.setSubjectname("tam");
		newobj.setSubjectname("tamil");
		//updateobj.updatesubject(obj,newobj);	
	}
	
	@PutMapping("/subject/{subjectname}/{updatedsubjectname}")
	public void updatesubjects( @PathVariable String subjectname, @PathVariable String updatedsubjectname )
	{	
		
		System.out.println("Updating");
		updateobj.updatesubject(subjectname,updatedsubjectname);
		System.out.println("updated");
	}


}
