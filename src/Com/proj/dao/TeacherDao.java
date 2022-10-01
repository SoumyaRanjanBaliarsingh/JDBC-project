package Com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Com.proj.dto.Teacher;
import Com.proj.helper.MyHelper;

public class TeacherDao {
	public int saveTeacher(Teacher teacher) {
		String sql = "Insert into Teacher values(?,?,?,?)";
		Connection connection = MyHelper.getConnectionObject();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, teacher.getID());
			preparedStatement.setString(2, teacher.getName());
			preparedStatement.setString(3, teacher.getSub());
			preparedStatement.setString(4, teacher.getGender());

			int i = preparedStatement.executeUpdate();
			connection.close();
			return i;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public String getTeacherByID(int id) {
		String sql = " select * from teacher where ID=" + id;
		Connection connection = MyHelper.getConnectionObject();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return "id : " + resultSet.getInt(1) + " name : " + resultSet.getString(2) + " sub : "
						+ resultSet.getString(3) + " gender :" + resultSet.getString(4);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return "invalid ID";

	}

	public int deleteTeacherById(int id) {
		String sql = "Delete from teacher where id= " + id;
		Connection connection = MyHelper.getConnectionObject();
		try {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return 0;
	}

	public int updateTeacher(int id, String column, String value) {
		String sql = "update teacher set " + column + " ='" + value + " 'where id= " + id;
		Connection connection = MyHelper.getConnectionObject();
		try {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}

	public int clearAllTeacherData() {
		String sql = "Truncate table teacher";
		Connection connection = MyHelper.getConnectionObject();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			connection.close();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void getAllTeacherData() {
		String sql = "select * from teacher";
		Connection connection = MyHelper.getConnectionObject();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("id : " + resultSet.getInt(1));
				System.out.println("Name : " + resultSet.getString(2));
				System.out.println("Subject : " + resultSet.getString(3));
				System.out.println("Gender: " + resultSet.getString(4));
				System.out.println("-------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int saveAllTeacher(ArrayList<Teacher> teachers) {
		String sql = "Insert into Teacher values(?,?,?,?)";
		Connection connection = MyHelper.getConnectionObject();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for (Teacher teacher : teachers) {
				preparedStatement.setInt(1, teacher.getID());
				preparedStatement.setString(2, teacher.getName());
				preparedStatement.setString(3, teacher.getSub());
				preparedStatement.setString(4, teacher.getGender());

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
