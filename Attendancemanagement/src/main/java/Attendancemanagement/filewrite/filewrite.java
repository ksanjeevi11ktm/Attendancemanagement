package Attendancemanagement.filewrite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Attendancemanagement.classes.attrecord;


public class filewrite {

	public void filewrites(String data,ArrayList<attrecord> objects)
			throws IOException
	{
		FileWriter files= new FileWriter("file.txt",true);
		for (int i=0;i<objects.size();i++)
		{
			attrecord obj=objects.get(i);
			if (data.equals("recordsperstudent"))
			{	
				if (i==0)
				{
					files.append("Attendance Record for student :"+obj.getStudentname()+"\n");
				}
				files.append(obj.getDate()+"\t"+obj.getSubjectname()+"\t"+obj.getPresence()+"\n");
			}
			if (data.equals("recordspersubject"))
			{	
				if (i==0)
				{
					files.append("Attendance Record for Subject :"+obj.getSubjectname()+"\n");
				}
				files.append(obj.getDate()+"\t"+obj.getStudentname()+"\t"+obj.getPresence()+"\n");
			}
			if (data.equals("recordsbystudent"))
			{	
				if (i==0)
				{
					files.append("Absents by Each Students : \n");
				}
				files.append(obj.getStudentname()+"\t"+obj.getPresence()+"\n");
			}
			if (data.equals("recordsbysubject"))
			{	
				if (i==0)
				{
					files.append("Absents by Each Subjects : \n");
				}
				files.append(obj.getSubjectname()+"\t"+obj.getPresence()+"\n");
			}
			if (data.equals("recordsbetweendate"))
			{	
				if (i==0)
				{
					files.append("Attendance Record by dates between :"+objects.get(objects.size()-1).getDate()+" to "+obj.getDate()+"\n");
				}
				files.append(obj.getDate()+"\t"+obj.getStudentname()+"\t"+obj.getSubjectname()+"\t"+obj.getPresence()+"\n");
			}
		}

		files.close();

	}

}
