package student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库操作
 * 
 * @author Lwj
 * @since 2016年9月6日
 */
public class DBUtil {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/students";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			System.err.println("数据库驱动加载失败！" + e.getMessage());

		} catch (SQLException e) {
			System.err.println("获取数据库连接失败！" + e.getMessage());

		}
		return connection;
	}

	/**
	 * 增删改操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object... params) {
		int row = 0;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);
				}
			}
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("操作数据库失败，" + e.getMessage());

		} finally {
			DBUtil.close(preparedStatement, connection);
		}
		return row;
	}

	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static int login(String username, String password) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int index = 0;
		try {
			preparedStatement = connection
					.prepareStatement("SELECT count(*) FROM student WHERE name=? AND password=? LIMIT 1");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("count(*)") == 1) {
					index = 1;
				}

			}
		} catch (SQLException e) {

		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		System.out.println(index);
		return index;
	}

	/**
	 * 关闭数据库资源
	 */
	public static void close(PreparedStatement preparedStatement, Connection connection) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(preparedStatement, connection);
	}

}
