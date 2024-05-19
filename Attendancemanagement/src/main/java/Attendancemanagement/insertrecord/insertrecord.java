package Attendancemanagement.insertrecord;

import java.sql.*;
import java.util.*;

import Attendancemanagement.classes.subject;
import Attendancemanagement.classes.attrecord;
import Attendancemanagement.classes.student;
import Attendancemanagement.classes.teacher;

public class insertrecord {
	
	public void insertsubtable(String tablename,ArrayList<subject> subjectslist)
	{
		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			for (int i=0;i<subjectslist.size();i++)
			{
				subject subobject=subjectslist.get(i);
				String sql="insert into "+ tablename+" (name) values "+ "(\""+subobject.getSubjectname()+"\")";
				statement.executeUpdate(sql);
			}			
		}
		catch (Exception exception)
		{
			System.out.println(exception);
		}
	}

	public void insertstudtable(String tablename,ArrayList<student> studentlist)
	{
		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			for (int i=0;i<studentlist.size();i++)
			{
				student studentobject=studentlist.get(i);
				String sql="insert into "+ tablename + "(name) Values "+ "(\""+studentobject.getStudentname()+"\")";
				System.out.println(sql);
				statement.executeUpdate(sql);
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception);
		}

	}

	public void insertteachtable(String tablename,ArrayList<teacher> teacherslist )
	{
		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			{
				for (int i=0;i<teacherslist.size();i++)
				{
					teacher tobject=teacherslist.get(i);
					String sql="select id  from subjecttbl where name ="+ "\""+tobject.getSubjectname()+"\"";
					System.out.println("::insertteachtable::"+sql);
					ResultSet subid = statement.executeQuery( sql);
					int subjectid=0;
					while(subid.next())
					{
						subjectid=subid.getInt("id");
					}
					String insertsql="insert into "+ tablename+" (name,subid ) values "+ "(\""+tobject.getSubjectname() +"\",\"" + subjectid + "\")";
					System.out.println(insertsql);
					statement.executeUpdate(insertsql);
				}
			} 
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}

	public void insertrecordtable(String tablename,ArrayList<attrecord> recordlist )
	{
		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			for (int i=0;i<recordlist.size();i++)
			{
				attrecord recordobject=recordlist.get(i);
				String subidsql="select id  from subjecttbl where name ="+ "\""+recordobject.getSubjectname()+"\"";
				String sidsql="Select id from studenttbl where name ="+"\""+recordobject.getStudentname()+"\"";

				System.out.println(":subid record:::"+subidsql);
				System.out.println("SID: record:::"+sidsql);
				ResultSet subidresultset = statement.executeQuery(subidsql);

				System.out.println("Resultset< record subid<<<<<<<<<<"+subidresultset);
				int subjectid=0;

				while(subidresultset.next())
				{
					subjectid=subidresultset.getInt("id");
					System.out.println("While Resultset.record same subnext()...."+subjectid);
				}
				ResultSet sidresultset = statement.executeQuery( sidsql);

				int studentid=0;
				while(sidresultset.next())
				{
					studentid=sidresultset.getInt("id");
					System.out.println("While Resultset..record studid..."+studentid);
				}
				String ins_recordsql="insert into "+ tablename+" (presence,sid,subid,attendancedate) values "+ "(\""+recordobject.getPresence() +"\",\""+studentid+"\",\""+subjectid +"\",\""+recordobject.getDate()+ "\")";
				System.out.println(ins_recordsql);
				statement.executeUpdate(ins_recordsql);
			} 
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}

}
