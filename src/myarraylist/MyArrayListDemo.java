package myarraylist;

import java.util.Arrays;

class MyArrayList {

	/**
	 * 数据存储
	 */
	private Object[] elementData;

	/**
	 * 实际在数组里存储的长度
	 */
	private int size;

	/**
	 * Default initial capacity.
	 */
	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public MyArrayList(int initialCapacity) {
		elementData = new Object[initialCapacity];
	}

	/**
	 * 新增
	 * 
	 * @param o
	 */
	public MyArrayList add(Object o) {
		int minCapacity = size + 1;
		if (elementData == null) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		if (minCapacity - elementData.length > 0) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			if (newCapacity - minCapacity < 0)
				newCapacity = minCapacity;
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
		elementData[size++] = o;
		return this;
	}

	/**
	 * 移除
	 * 
	 * @param o
	 */
	public MyArrayList remove(Object o) {
		if (o == null) {
			return this;
		}
		for (int index = 0; index < size; index++) {
			if (o.equals(elementData[index])) {
				int numMoved = size - index - 1;
				if (numMoved > 0)
					System.arraycopy(elementData, index + 1, elementData, index, numMoved);
				elementData[--size] = null;
				index--;
			}
		}
		return this;
	}

	/**
	 * 修改
	 * 
	 * @param index
	 * @param o
	 */
	public MyArrayList set(int index, Object o) {
		rangeCheck(index);
		elementData[index] = o;
		return this;
	}

	/**
	 * 取值
	 * 
	 * @param index
	 */
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	/**
	 * 下标较验
	 * 
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index > size || index < 0) {
			throw new IllegalArgumentException("访问下标非法：" + index);
		}
	}

	@Override
	public String toString() {
		String str = "[";
		for (Object object : elementData) {
			if (object != null) {
				str += object + ",";
			}
		}
		str = str.substring(0, str.length() - 1);
		return str + "]";
	}

}

/**
 * 模拟ArrayList
 * 
 * @author Administrator
 * @since 2016年8月31日
 */
public class MyArrayListDemo {

	public static void main(String[] args) {
		MyArrayList myArrayList = new MyArrayList();
		myArrayList.add("aaaaaaaa");
		myArrayList.add("bbbbbbbbbbbbbbbbbbbbbbb");
		myArrayList.add("cccccccccccccccc");
		myArrayList.add("dddddd");
		myArrayList.add("dddddd");
		myArrayList.add("e");
		System.out.println(myArrayList.get(2));
		// myArrayList.remove("dddddd");
		myArrayList.set(5, "ee");
		System.out.println(myArrayList);

	}

}
