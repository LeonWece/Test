package polymorphsim;

/**
 * 水果类
 * 
 * @author Lwj
 * @since 2016年8月26日
 */
class Fruit {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public Fruit() {
		super();
	}

	public void sale() {
		System.out.println("Fruit sale...");
	}
}

class Apple extends Fruit {

	public Apple(String name) {
		super(name);
	}

	public void sale() {
		System.out.println("Apple sale...");
	}

	public void test() {
		System.out.println("Apple test...");
	}
}

class Banana extends Fruit {

	public Banana(String name) {
		super(name);
	}

	public void sale() {
		System.out.println("Banana sale...");
	}
}

public class PolymorphismDemo {

	public static void main(String[] args) {
		Fruit fruit = new Apple("大苹果");
		Fruit fruit2 = new Banana("大香蕉");
		fruit.sale();
		fruit2.sale();

		if (fruit instanceof Apple) {
			Apple apple = (Apple) fruit;
			apple.test();
		}

	}

}
