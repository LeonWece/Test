
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[20];
		numbers[0]=0;
		numbers[1]=1;
		for(int i =2 ; i<numbers.length;i++){
			numbers[i]=numbers[i-2]+numbers[i-1];
		}
		
		for (int i : numbers) {
			System.out.println(i);
		}
	}

}
