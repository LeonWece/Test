package singleton;

/**
 * 单例模式（恶汉式）
 * 
 * @author Lwj
 * @since 2016年8月26日
 */
public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

}
