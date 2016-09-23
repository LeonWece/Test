package abstraction;

/**
 * 抽象类
 * 
 * @author Lwj
 * @since 2016年8月26日
 */
abstract class Shape {
	public abstract void getArea();

	public abstract void getGirth();
}

class Rectangle extends Shape {
	@Override
	public void getArea() {
		System.out.println("矩形面积...");
	}

	@Override
	public void getGirth() {
		System.out.println("矩形周长...");
	}
}

class Triangle extends Shape {

	@Override
	public void getArea() {
		System.out.println("三角形面积...");
	}

	@Override
	public void getGirth() {
		System.out.println("三角形周长...");
	}

}

public class Test {

	public static void main(String[] args) {
		new Rectangle().getArea();
		new Rectangle().getGirth();
		new Triangle().getArea();
		new Triangle().getGirth();
	}

}
