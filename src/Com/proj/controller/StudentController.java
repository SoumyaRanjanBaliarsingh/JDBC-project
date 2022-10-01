package Com.proj.controller;

import java.util.ArrayList;

//import Com.proj.dao.StudentDao;
import Com.proj.dao.StudentDao1;
import Com.proj.dto.Student;

public class StudentController {
	public static void main (String[] args)
	{
		Student student= new Student();
		student.setID(7);
		student.setName("baaz");
		student.setAge(31);
	    student.setGender("male");
		student.setEmail("baaz@gmail.com");

		Student student1= new Student();
		student1.setID(8);
		student1.setName("Raaz");
		student1.setAge(27);
	    student1.setGender("male");
		student1.setEmail("raaz@gmail.com");
		
		Student student11= new Student();
		student11.setID(9);
		student11.setName("saaz");
		student11.setAge(23);
	    student11.setGender("male");
		student11.setEmail("saaz@gmail.com");
		
		
		
		ArrayList<Student> students= new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		students.add(student11);
		StudentDao1 dao= new StudentDao1();
		int saveAllStudents=dao.saveAllStudents(students);
		//dao.saveStudent(student);
	     //dao.deleteStudentByID(4);
	     
	}

}
