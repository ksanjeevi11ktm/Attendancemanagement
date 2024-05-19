package Attendancemanagement.deleterecord;

import java.sql.*;

import Attendancemanagement.classes.attrecord;
import Attendancemanagement.classes.student;
import Attendancemanagement.classes.subject;


public class deleterecord {
	public void deleteattendancerecord(attrecord object)
	{
		try
		{
			int subid=0;
			int sid=0;	

			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String sidsql="select id as studentid from studenttbl where name=\""+object.getStudentname()+"\"";
			String subidsql="select id as subjectid from subjecttbl where name=\""+object.getSubjectname()+"\"";
			System.out.println(sidsql);
			ResultSet sidresultset=statement.executeQuery(sidsql);
			while(sidresultset.next())
			{
				sid=sidresultset.getInt("studentid");
				System.out.println(" "+sid+" ");
			}
			System.out.println(subidsql);
			ResultSet subidresultset=statement.executeQuery(subidsql);

			while(subidresultset.next())
			{
				subid=subidresultset.getInt("subjectid");
				System.out.println(" "+subid+" ");
			}
			String sql="delete from recordtbl where sid="+sid+" and subid="+subid+" and attendancedate=\""+object.getDate()+"\"";
			System.out.println(sql);
			statement.executeUpdate(sql);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}

	public void deletestudent(student object)
	{
		try
		{
			int sid=0;

			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String sidsql="select id as studentid from studenttbl where name=\""+object.getStudentname()+"\"";
			System.out.println(sidsql);
			ResultSet sidresultset=statement.executeQuery(sidsql);
			while(sidresultset.next())
			{
				sid=sidresultset.getInt("studentid");
				System.out.println(" "+sid+" ");
			}
			String sql="delete from studenttbl where id=\""+sid+"\"";
			System.out.println(sql);
			statement.executeUpdate(sql);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}

	public void deletesubject(subject object)
	{
		try
		{
			int subid=0;

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
			String sql="delete from subjecttbl where id=\""+subid+"\"";
			System.out.println(sql);
			statement.executeUpdate(sql);

		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}


}
