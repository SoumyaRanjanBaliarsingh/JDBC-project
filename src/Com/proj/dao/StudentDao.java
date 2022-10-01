package Com.proj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Com.proj.dto.Student;
import Com.proj.helper.MyHelper;

public class StudentDao {
	
public String saveStudent(Student student)
{
	//String sql="insert into student values("+student.getID()+",'"+student.getName()+"',"+student.getAge()+",'"+student.getGender()+"','"+student.getEmail()+"')";
	//String sql="update student set name='vishal' where name='Ranjan'";
	String sql="delete from student where id=3";
	Connection connection = MyHelper.getConnectionObject();
	
	try {
		Statement statement=connection.createStatement();
		statement.execute(sql);
		connection.close();
		return "data added successfully";
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return" data adding failed";
}

}
