package Attendancemanagement.viewrecord;

import java.sql.*;
import java.util.*;

import Attendancemanagement.classes.attrecord;
import Attendancemanagement.filewrite.filewrite;



public class viewrecord {


	filewrite fileobj= new filewrite();

	public ArrayList<attrecord> displayperstudent(String studentname)
	{	
		ArrayList<attrecord> recordlist =new ArrayList<attrecord>();

		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			
				String sql="select attendancedate as Date,students.name as Student_name,presence,subjects.name  as subjectName from recordtbl as record inner join studenttbl as students inner join subjecttbl as subjects on students.id=record.sid and record.subid=subjects.id and students.name=(\""+ studentname+"\") order by Date";
				//String sql="select attendancedate as Date, students.name as Studentname,presence from recordtbl as record inner join studenttbl as student on students.id=record.sid and record.subid=subject.id and students.name=(\""+ name+"\")";
				System.out.println(sql);
				ResultSet resultset=statement.executeQuery(sql);


				System.out.println(" "+ "Date"+" "+ "Subject Name" +" "+"Student Name"+" "+"Presence");
				while(resultset.next()) 
				{ 
					attrecord object=new attrecord(); 
					String date=resultset.getString("Date"); 
					String sname=resultset.getString("Student_name"); 
					String presence=resultset.getString("presence"); 
					String subname=resultset.getString("subjectName"); 
					object.setStudentname(sname);
					object.setDate(date); object.setPresence(presence);
					object.setSubjectname(subname); 
					recordlist.add(object); 
				} 
				for (int j=0;j<recordlist.size();j++) 
				{ 
					attrecord displayobject=recordlist.get(j);
					System.out.println(" "+displayobject.getDate()+" "+displayobject.getStudentname()+" "+displayobject.getPresence()+" "+displayobject.getSubjectname()); 
				} 
			

			fileobj.filewrites("recordsperstudent",recordlist); 
		} 
		catch (Exception exception) 
		{ 
			exception.printStackTrace(); 
		} 
		return recordlist;
	}


	public ArrayList<attrecord> displaypersubject(String subjectname)
	{
		ArrayList<attrecord> recordlist =new ArrayList<attrecord>();

		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
				String sql="select attendancedate as Date,students.name as Student_name,presence,subjects.name  as subjectName from recordtbl as record inner join studenttbl as students inner join subjecttbl as subjects on students.id=record.sid and record.subid=subjects.id and subjects.name=(\""+ subjectname+"\") order by Date";
				//String sql="select attendancedate as Date, students.name as Studentname,presence from recordtbl as record inner join studenttbl as student on students.id=record.sid and record.subid=subject.id and students.name=(\""+ name+"\")";
				System.out.println(sql);
				ResultSet resultset=statement.executeQuery(sql);
				String date=null;
				String sname=null;
				String presence=null;
				String subname=null;

				System.out.println(" "+ "Date"+" "+ "Subject Name" +" "+"Student Name"+" "+"Presence");
				while(resultset.next())
				{
					attrecord object=new attrecord();
					date=resultset.getString("Date");
					sname=resultset.getString("Student_Name");
					presence=resultset.getString("presence");
					subname=resultset.getString("subjectName");
					object.setStudentname(sname);
					object.setDate(date);
					object.setPresence(presence);
					object.setSubjectname(subname);
					recordlist.add(object);
				}
				for (int j=0;j<recordlist.size();j++)
				{
					attrecord displayobject=recordlist.get(j);
					System.out.println(" "+ displayobject.getDate()+" "+displayobject.getSubjectname()+" "+displayobject.getStudentname()+" "+displayobject.getPresence());
				}
			

			fileobj.filewrites("recordspersubject",recordlist);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		return recordlist;
	}

	public List<attrecord> displayrecordsbystudent()
	{
		ArrayList<attrecord> recordlist =new ArrayList<attrecord>();
		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String sql="select students.name as StudentName,count(record.presence) as AbsentDays from recordtbl as record inner join studenttbl as students on students.id=record.sid and (record.presence=\"y\" or record.presence=\"y\") group by students.name order by AbsentDays desc";

			System.out.println(sql);
			ResultSet resultset=statement.executeQuery(sql);

			String sname=null;
			String presence=null;

			while(resultset.next())
			{
				attrecord object=new attrecord();
				sname=resultset.getString("StudentName");
				presence=resultset.getString("AbsentDays");
				object.setStudentname(sname);
				object.setPresence(presence);
				recordlist.add(object);
			}
			for (int i=0;i<recordlist.size();i++)
			{
				attrecord displayobject=recordlist.get(i);
				System.out.println(displayobject.getStudentname()+displayobject.getPresence());	
			}
			fileobj.filewrites("recordsbystudent",recordlist);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		return recordlist;

	}

	public List<attrecord> displayrecordsbysubject()
	{
		ArrayList<attrecord>  recordlist=new ArrayList<attrecord>();
		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String sql="select subjects.name as SubjectName,count(record.presence) as AbsentDays from recordtbl as record inner join subjecttbl as subjects on subjects.id=record.subid and (record.presence=\"y\" or record.presence=\"y\") group by subjects.name order by AbsentDays desc";

			System.out.println(sql);
			ResultSet resultset=statement.executeQuery(sql);

			while(resultset.next())
			{
				attrecord object=new attrecord();
				String subname=resultset.getString("SubjectName");
				String presence=resultset.getString("AbsentDays");
				object.setSubjectname(subname);
				object.setPresence(presence);
				recordlist.add(object);
			}
			for (int i=0;i<recordlist.size();i++)
			{
				attrecord displayobject=recordlist.get(i);
				System.out.println(displayobject.getSubjectname()+displayobject.getPresence());	
			}
			fileobj.filewrites("recordsbysubject", recordlist);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		return recordlist;
	}

	public List<attrecord> displayrecordsbetween(String fromdate,String todate)
	{
		ArrayList<attrecord> recordlist =new ArrayList<attrecord>();

		try
		{
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();
			String sql="select record.attendancedate as Date,record.presence as Status,students.name as Studentname,subjects.name as Subjectname from recordtbl as record inner join studenttbl as students on students.id=record.sid inner join subjecttbl as subjects on record.subid=subjects.id where attendancedate between \""+fromdate+"\"" +"and \""+todate+"\"";

			System.out.println(sql);
			ResultSet resultset=statement.executeQuery(sql);
			//System.out.println(" "+ "Date"+" "+ "Subject Name" +" "+"Student Name"+" "+"Presence");

			while(resultset.next())
			{
				attrecord object=new attrecord();
				String date=resultset.getString("Date");
				String sname=resultset.getString("Studentname");
				String presence=resultset.getString("Status");
				String subname=resultset.getString("subjectname");
				object.setStudentname(sname);
				object.setDate(date);
				object.setPresence(presence);
				object.setSubjectname(subname);
				recordlist.add(object);
			}
			for (int i=0;i<recordlist.size();i++)
			{
				attrecord displayobject=recordlist.get(i);
				System.out.println(" "+ displayobject.getDate()+" "+displayobject.getStudentname()+" "+displayobject.getPresence()+" "+displayobject.getSubjectname());
			}
			fileobj.filewrites("recordsbetweendate",recordlist);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		return recordlist;
	}

	public ArrayList<attrecord> attpercentage(String studentname)
	{
		ArrayList<attrecord> recordlist =new ArrayList<attrecord>();

		try
		{
			
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root", "root");
			Statement statement;
			statement=connection.createStatement();

			/* Sql query to create procedure
			 	delimiter :
				create procedure recordtable(IN studentname varchar(255))
				begin
				declare newid int;
				declare totaldays double;
				declare absentdays double;
				declare per double;
				select id into newid from studenttbl where name=studentname;
				select count(presence) into totaldays from recordtbl where sid =newid;
				select count(presence) into absentdays from recordtbl where sid =newid and presence="y";
				#set per =cast(per as decimal(2));
				set per=((absentdays*1.0) div totaldays)*100;
				select studentname,newid,totaldays,per,absentdays;
				end :
			 */
	

				String sql="call recordtable(\""+studentname+"\");";
				System.out.println(sql);
				ResultSet resultset=statement.executeQuery(sql);
				while(resultset.next())
				{
					attrecord  attobject=new attrecord();
					double totaldays=0;
					double presentdays=0;
					double percentage=0;
					totaldays=resultset.getDouble("totaldays");
					presentdays=resultset.getDouble("presentdays");
					percentage=resultset.getDouble("per");
					attobject.setTotaldays(totaldays);
					attobject.setAbsentdays(presentdays);
					attobject.setAttpercentage(percentage);
					recordlist.add(attobject);
				}
				for (int j=0;j<recordlist.size();j++)
				{
					attrecord displayobject=recordlist.get(j);
					System.out.println(" "+ studentname+" "+displayobject.getAttpercentage());
				}
			
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		return recordlist;
	}



}
