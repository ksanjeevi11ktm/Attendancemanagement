package Attendancemanagement.classes;

public class attrecord {
	String date;
	String studentname;
	String subjectname;
	String presence;
	double totaldays;
	double presentdays;
	double absentdays;
	double attpercentage;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getPresence() {
		return presence;
	}
	public void setPresence(String presence) {
		this.presence = presence;
	}
	public double getTotaldays() {
		return totaldays;
	}
	public void setTotaldays(double totaldays) {
		this.totaldays = totaldays;
	}
	public double getAbsentdays() {
		return absentdays;
	}
	public void setAbsentdays(double absentdays) {
		this.absentdays = absentdays;
	}
	public double getAttpercentage() {
		return attpercentage;
	}
	public void setAttpercentage(double attpercentage) {
		this.attpercentage = attpercentage;
	}
	public double getPresentdays() {
		return presentdays;
	}
	public void setPresentdays(double presentdays) {
		this.presentdays = presentdays;
	}


}
