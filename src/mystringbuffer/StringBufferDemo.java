package mystringbuffer;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("asda");
		stringBuffer.insert(0, "ccc");
		// stringBuffer.delete(2, 4);
		stringBuffer.indexOf("a");
		stringBuffer.reverse();
		System.out.println(stringBuffer);
	}

}
