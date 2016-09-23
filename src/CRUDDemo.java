import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <pre>
 * Java JDBC操作：
 * 1）加载驱动：Class.forName("全限定名")，把某个类载入到JVM中
 * 2）连接数据库：Connection
 * 3）操作数据库：Statement/PreparedStatement
 * 4）关闭数据库资源: xx.close()
 * </pre>
 * 
 * @author Lwj
 * @since 2016年9月5日
 */
public class CRUDDemo {

	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;

	/**
	 * 连接数据库
	 */
	static {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动失败，" + e.getMessage());
		}

		// 连接数据库
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (SQLException e) {
			System.err.println("连接数据库失败，" + e.getMessage());
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public static void closeConnection() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
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

	/**
	 * 1)查询年龄20岁（含20岁）以上的人员的编号和姓名，按编号排序
	 */
	public static void test1() {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT tid, name FROM talent WHERE age>=20");
			while (resultSet.next()) {
				System.out.println("编号：" + resultSet.getInt("tid") + ",姓名：" + resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.err.println("操作数据库失败，" + e.getMessage());
		} finally {
			// 4）关闭数据库资源（关闭时遵守先打开的后关闭的顺序）
			closeConnection();
		}
	}

	/**
	 * 2)查询申请了职位编号为“2”的人员的姓名
	 */
	public static void test2() {
		try {
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT name FROM talent WHERE tid IN(SELECT tid FROM application WHERE pid=2)");
			while (resultSet.next()) {
				System.out.println("姓名：" + resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.err.println("操作数据库失败，" + e.getMessage());
		} finally {
			// 4）关闭数据库资源（关闭时遵守先打开的后关闭的顺序）
			closeConnection();
		}
	}

	/**
	 * 3)查询名称包含“汽车”字样的企业发布的全部职位的编号和职位名称
	 * 
	 */
	public static void test3() {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT p.pid,p.title FROM company c,position p WHERE c.`name` LIKE '%汽车%' AND c.cid=p.cid");
			while (resultSet.next()) {
				System.out.println("职位编号：" + resultSet.getInt("pid") + ",职位名称：" + resultSet.getString("title"));
			}
		} catch (SQLException e) {
			System.err.println("操作数据库失败，" + e.getMessage());
		} finally {
			// 4）关闭数据库资源（关闭时遵守先打开的后关闭的顺序）
			closeConnection();
		}
	}

	/**
	 * 4)统计各职位的申请人数，列出职位名称、申请人数, 按申请人数从高到低排序
	 * 
	 */
	public static void test4() {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT p.title,COUNT(p.pid) AS count FROM position p,application a WHERE p.pid=a.pid GROUP BY p.pid ORDER BY count DESC");
			while (resultSet.next()) {
				System.out.println("职位名称：" + resultSet.getString("title") + ",申请人数：" + resultSet.getInt("count"));
			}
		} catch (SQLException e) {
			System.err.println("操作数据库失败，" + e.getMessage());
		} finally {
			// 4）关闭数据库资源（关闭时遵守先打开的后关闭的顺序）
			closeConnection();
		}
	}

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		test4();
	}

}
