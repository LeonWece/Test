/**
 * 
 * @author Lwj
 *����һ��һά���飬�ҳ���������ֵ����Сֵ��ƽ��ֵ
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
		System.out.println("��Сֵ��"+min);
		System.out.println("���ֵ��"+max);
		System.out.println("ƽ��ֵ��"+(double)ave/numbers.length);
	}
}