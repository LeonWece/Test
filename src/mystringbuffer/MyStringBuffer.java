package mystringbuffer;

import java.util.Arrays;

/**
 * 模拟StringBuffer
 * 
 * @author Administrator
 * @since 2016年8月30日
 */
public class MyStringBuffer {

	/**
	 * The value is used for character storage.
	 */
	private char[] value;
	/**
	 * The count is the number of characters used.
	 */
	private int count;

	/**
	 * 构造方法（默认为16个容量）
	 * 
	 * @param args
	 */
	public MyStringBuffer() {
		this(16);
	}

	/**
	 * 构造方法（传入自定义容量）
	 * 
	 * @param capacity
	 */
	public MyStringBuffer(int capacity) {
		value = new char[capacity];
	}

	public MyStringBuffer(String str) {
		this(str.length() + 16);
		append(str);
	}

	/**
	 * append() 字符串末尾追加
	 * 
	 * @return
	 */
	public String append(String str) {
		// 1、如果传入的字符串为null，就直接追加一个null的字符串
		if (str == "") {
			"null".getChars(0, 4, value, count);
			count += 4;
			return String.valueOf(value);
		}
		// 2、确保内部容量是否足够（if (count + str.length > value.length)）
		int len = str.length();
		int newLen = len + count;
		// 3、如果容量超出就需要扩容：
		ensureCapacityInternal(newLen);
		// 5、把原来数组里面的值copy到新数组里面来
		// 6、另外还要注意每次append后，count都要变化
		str.getChars(0, len, value, count);
		count += len;
		return String.valueOf(value);

	}

	/**
	 * 复制字符数组
	 * 
	 * @param srcBegin
	 *            - 字符串中要复制的第一个字符的索引。
	 * @param srcEnd
	 *            - 字符串中要复制的最后一个字符之后的索引。
	 * @param dst
	 *            - 目标数组。
	 * @param dstBegin
	 *            - 目标数组中的起始偏移量。
	 * 
	 * 
	 */
	public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
		if (srcBegin < 0) {
			throw new StringIndexOutOfBoundsException(srcBegin);
		}
		if (srcEnd > value.length) {
			throw new StringIndexOutOfBoundsException(srcEnd);
		}
		if (srcBegin > srcEnd) {
			throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);
		}
		// src - 源数组。
		// srcPos - 源数组中的起始位置。
		// dest - 目标数组。
		// destPos - 目标数据中的起始位置。
		// length - 要复制的数组元素的数量。
		System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
	}

	/**
	 * insert()
	 * 
	 * @param args
	 */
	public String insert(int offset, String str) {
		if ((offset < 0) || (offset > count))
			throw new StringIndexOutOfBoundsException(offset);
		if (str == null)
			str = "null";
		int len = str.length();
		ensureCapacityInternal(count + len);
		System.arraycopy(value, offset, value, offset + len, count - offset);
		str.getChars(0, len, value, offset);
		count += len;
		return String.valueOf(value);
	}

	/**
	 * delete()
	 * 
	 * @param args
	 */
	public String delete(int start, int end) {
		if (start < 0)
			throw new StringIndexOutOfBoundsException(start);
		if (end > count)
			end = count;
		if (start > end)
			throw new StringIndexOutOfBoundsException();
		int len = end - start;
		if (len > 0) {
			System.arraycopy(value, start + len, value, start, count - len);
			count -= len;
		}
		return String.valueOf(value);
	}

	/**
	 * indexOf() 调用String的indexOf()
	 * 
	 * @param args
	 */

	/**
	 * reserver() 逆序
	 * 
	 * @param args
	 */

	/**
	 * 判断字符长度是否大于默认长度
	 * 
	 * @param minimumCapacity
	 */
	private void ensureCapacityInternal(int minimumCapacity) {
		// overflow-conscious code
		if (minimumCapacity - value.length > 0)
			expandCapacity(minimumCapacity);
	}

	/**
	 * 扩容
	 * 
	 * @param minimumCapacity
	 */
	void expandCapacity(int minimumCapacity) {
		int newCapacity = value.length * 2 + 2;

		// 2）再拿newCapacity与count + str.length进行比较，如果count + str.length >
		// newCapacity，那容量就扩展到count + str.length
		// 如果扩大后字符长度小于实际的字符长度，就使用实际长度
		if (newCapacity - minimumCapacity < 0)
			newCapacity = minimumCapacity;

		// 如果超出int的范围，使用无限大的值
		if (newCapacity < 0) {
			if (minimumCapacity < 0) // overflow
				throw new OutOfMemoryError();
			newCapacity = Integer.MAX_VALUE;
		}
		// 4、扩容成功后，再根据新的容量创建一个新数组
		value = Arrays.copyOf(value, newCapacity);
	}

	public static void main(String[] args) {
		MyStringBuffer myStringBuffer = new MyStringBuffer();

		// myStringBuffer.append("bbbbbbbaaaaaaaaaaaaaaa");
		myStringBuffer.append("abcdefgh");
		// System.out.println(myStringBuffer.append("adasdasd"));
		System.out.println(myStringBuffer.append(""));
		// myStringBuffer.insert(3, "xxxxxxx");
		System.out.println(myStringBuffer.delete(2, 4));

	}

}
