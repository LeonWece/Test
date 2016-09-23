package student_management_system;

import java.util.Scanner;

/**
 * 学生管理系统
 * 
 * @author Lwj
 * @since 2016年9月6日
 */
public class StudentManagementSystem {
	private static Scanner scanner = new Scanner(System.in);
	private static String USER_NAME = null;

	/**
	 * 程序入口
	 */
	public static void start() {

		while (true) {
			int n = Integer.parseInt(scanner.nextLine());
			if (n == 1) {
				login();
				return;
			} else if (n == 2) {
				System.exit(0);
			} else {
				System.out.println("输入有误！请重新输入...");
			}
		}
	}

	/**
	 * 主页
	 * 
	 * 
	 */
	public static void home() {
		System.out.println("******************************************************");
		System.out.println("\t\t欢迎您，" + USER_NAME);
		System.out.println("      1、查询   2、增加   3、修改   4、删除    5、统计   6、退出");
		System.out.println("******************************************************");

		while (true) {
			int n = Integer.parseInt(scanner.nextLine());
			switch (n) {
			case 1:
				// 查询操作

				break;
			case 2:
				// 增加

				break;
			case 3:
				// 修改

				break;
			case 4:
				// 删除

				break;
			case 5:
				// 统计

				break;
			case 6:
				// 退出
				System.exit(0);
				break;
			default:
				System.out.println("输入有误！请重新输入...");
				break;
			}

		}

	}

	/**
	 * 登录
	 */
	public static void login() {
		System.out.println("请输入姓名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		int index = DBUtil.login(username, password);
		if (index == 1) {
			USER_NAME = username;
			home();
		} else {
			System.out.println("用户名或密码输入错误，请重新输入！");
			login();
		}
	}

	public static void main(String[] args) {
		System.out.println("******************************************************");
		System.out.println("                            欢迎使用盗版学生管理系统！");
		System.out.println("                  1、登录      2、退出");
		System.out.println("******************************************************");

		start();
	}

}
