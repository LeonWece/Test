package setdemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set 去重
 * 
 * @author Lwj
 * @since 2016年9月1日
 */
public class SetDemo {

	// 去重、乱序
	public static void testHashSet() {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(13);
		hashSet.add(21);
		hashSet.add(2);
		hashSet.add(4);
		hashSet.add(2);

		for (Integer integer : hashSet) {
			System.out.print(integer + "\t");
		}

	}

	// 去重、排序
	public static void testTreeSet() {
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(13);
		treeSet.add(21);
		treeSet.add(2);
		treeSet.add(4);
		treeSet.add(2);

		// for (Integer integer : treeSet) {
		// System.out.print(integer + "\t");
		// }

	}

	public static void main(String[] args) {
		// testHashSet();
		// testTreeSet();

		Set<Person> personSet = new TreeSet<Person>();
		personSet.add(new Person(1001, "张三", 18));
		personSet.add(new Person(11123, "张三", 18));
		personSet.add(new Person(1, "张三", 19));
		personSet.add(new Person(1, "张三", 18));
		for (Person person : personSet) {
			System.out.println(person + "\t");
		}

	}

}

/**
 * <pre>
 * Person类 
 * 重写 compareTo()、equals()、toString()
 * </pre>
 * 
 * @author Lwj
 * @since 2016年9月2日
 */
class Person implements Comparable<Person> {
	private int id;
	private String name;
	private int age;

	public Person() {

	}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (this.id > o.id) {
			return 1;
		} else if (this.id < o.id) {
			return -1;
		} else {
			if (this.age > o.age) {
				return 1;
			} else if (this.age < o.age) {
				return -1;
			} else {
				return this.name.compareTo(o.name);
			}

		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Person) {
			Person otherPerson = (Person) obj;
			if (this.id == otherPerson.id && this.name.equals(otherPerson.name) && this.age == otherPerson.age) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
