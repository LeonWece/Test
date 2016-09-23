/**
 * 
 * @author Lwj
 *定义一个一维数组，找出里面的最大值、最小值和平均值
 */

public class Test1 {
	public static void main(String[] args){
		int[] numbers = {12,10,8,20};
		int min = numbers[0];
		int max = numbers[0];
		int ave = 0;
		for (int i = 0;i < numbers.length ;i++ ) {
			if(min > numbers[i]){
				min = numbers[i];
			}
			if(max < numbers[i]){
				max = numbers[i];
			}
			ave = ave + numbers[i];
		}
		System.out.println("最小值："+min);
		System.out.println("最大值："+max);
		System.out.println("平均值："+(double)ave/numbers.length);
	}
}