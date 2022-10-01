package Com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Com.proj.dto.Student;
import Com.proj.helper.MyHelper;

public class StudentDao1 {
	public String saveStudent(Student student) {
		String sql = "insert into student values(?,?,?,?,?)";
		Connection connection = MyHelper.getConnectionObject();

		try {
			// instead of using concatenation we used preparedStatement.
			// statement is the child interface of preparedStatement.
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getID());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setString(4, student.getGender());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.execute();
			connection.close();
			return "data added successfully";
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return " data adding failed";

	}

	// public String deleteStudentByID(int ID )
	public void deleteStudentByID(int ID) {
		String sql = " delete from student where ID=?";
		Connection connection = MyHelper.getConnectionObject();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			connection.close();
			// return" data deleted";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return "data is not deleted";

	}

	public int saveAllStudents(ArrayList<Student> students) {
		String sql = " Insert into student values(?,?,?,?,?)";
		Connection connection = MyHelper.getConnectionObject();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for (Student student : students) {
				preparedStatement.setInt(1, student.getID());
				preparedStatement.setString(2, student.getName());
				preparedStatement.setInt(3, student.getAge());
				preparedStatement.setString(4, student.getGender());
				preparedStatement.setString(5, student.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.close();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}
}
