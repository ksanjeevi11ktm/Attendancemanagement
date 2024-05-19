package Attendancemanagement;

import java.io.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AttendancemanagementApplication {

	public static void main(String[] args)
			throws IOException
	{
		SpringApplication.run(AttendancemanagementApplication.class, args);
		attendance obj=new attendance();
		obj.mainmethod();
	}

}
