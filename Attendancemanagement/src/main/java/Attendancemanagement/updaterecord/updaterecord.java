package Attendancemanagement.updaterecord;

import java.io.*;
import java.sql.*;
import java.util.*;

import Attendancemanagement.classes.attrecord;

public class updaterecord {

	public void updatesubject(String subjectname,String updatedsubjectname)
	{
		try
		{
			int subid=0;
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String subidsql="select id as subjectid from subjecttbl where name=\""+subjectname+"\"";
			System.out.println(subidsql);
			ResultSet subidresultset=statement.executeQuery(subidsql);
			while(subidresultset.next())
			{
				subid=subidresultset.getInt("subjectid");
				System.out.println(" "+subid+" ");
			}
			String sql=" update subjecttbl set name =\""+updatedsubjectname+"\"where id=\""+subid+"\"";
			System.out.println(sql);
			System.out.println(">>>>>>>>>>>");
			statement.executeUpdate(sql);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}

	public void updateattendance(attrecord object)
	{
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		try
		{
			String date=null;
			String subjectname=null;
			String studentname=null;
			int subid=0;
			int studentid=0;
			String presence=null;
			ArrayList<attrecord> recordlist=new ArrayList<attrecord>();

			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String subidsql="select id as subjectid from subjecttbl where name=\""+object.getSubjectname()+"\"";
			System.out.println(subidsql);
			ResultSet subidresultset=statement.executeQuery(subidsql);
			while(subidresultset.next())
			{
				subid=subidresultset.getInt("subjectid");
				System.out.println(" "+subid+" ");
			}
			String sidsql="select name as studentname,id as studentid from studenttbl order by id";
			ResultSet sidresultset=statement.executeQuery(sidsql);
			System.out.println(sidsql);
			while(sidresultset.next())
			{
				attrecord objects=new attrecord();
				studentname=sidresultset.getString("studentname");
				studentid=sidresultset.getInt("studentid");
				System.out.println("Enter the presence for the "+studentname + "for date "+object.getDate());
				presence=input.readLine();
				objects.setPresence(presence);
				objects.setStudentname(studentname);
				objects.setSubjectname(subjectname);
				objects.setDate(date);
				recordlist.add(objects);
			}

			for (int i=0;i<recordlist.size();i++)
			{
				attrecord obj=recordlist.get(i);
				String sql="insert into recordtbl (attendancedate,sid,subid,presence) values "+"(\""+obj.getDate()+"\","+obj.getStudentname()+","+obj.getSubjectname()+",\""+obj.getPresence()+"\")";
				System.out.println(sql);
				statement.executeUpdate(sql);
			}

		}
		catch (Exception exception)
		{
			//exception.printStackTrace();
			System.out.println(exception);
		}
	}
}
