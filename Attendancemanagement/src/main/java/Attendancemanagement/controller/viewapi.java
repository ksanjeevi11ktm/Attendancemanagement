package Attendancemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Attendancemanagement.classes.attrecord;
import Attendancemanagement.viewrecord.viewrecord;


@RestController
@RequestMapping("/attendancerecords")

@CrossOrigin(origins = "http://localhost:3001")

public class viewapi {

viewrecord viewobj = new viewrecord();
	
	@GetMapping("/studentspresence")
	public List<attrecord> displayrecordsperstudent()
	{
		return viewobj.displayrecordsbystudent();
	}
	
	@GetMapping("/studentsrecord/{studentname}")
	public ArrayList<attrecord> displayperstudent(@PathVariable String studentname)
	{
		System.out.println("Display by name in get");
		return viewobj.displayperstudent(studentname);
	}
	
	
	@GetMapping("/subjectsrecord/{subjectname}")
	public List<attrecord> displaypersubject(@PathVariable String subjectname)
	{
		return viewobj.displaypersubject(subjectname);
	}

	@GetMapping(value="/subjectspresence")
	public List<attrecord> displayrecordsbysubject()
	{
		return viewobj.displayrecordsbysubject();
	}
	
	@GetMapping("/subjectsdate")
	public List<attrecord> displayrecordsbetween(String fromdate,String todate)
	{
		return viewobj.displayrecordsbetween("2022-11-11","2024-12-12");
	}
	
	@GetMapping("/studentper")
	public  ArrayList<attrecord> attpercentage(String studentname)
	{
		return viewobj.attpercentage(studentname);			
	}
}
