/**
 * 
 * @author Lwj ð������ ��ѡ������
 */
public class Test2 {

	public static void main(String[] args) {

		int[] numbers = { 12, 10, 8, 20, 43 };
		int temp;
		int nIndex = 0;

		/**
		 * ѡ������
		 */
		for (int i = 0; i < numbers.length - 1; i++) {

			nIndex = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[nIndex]) {
					// ����λ��
					nIndex = j;
				}
			}
			// ����ֵ
			if (nIndex != i) {
				temp = numbers[i];
				numbers[i] = numbers[nIndex];
				numbers[nIndex] = temp;
			}

		}
		System.out.println("ѡ������:");
		for (int i : numbers) {
			System.out.print(i+" ");
		}
		
		/**
		 * ð������
		 */
		for (int i = 0; i < numbers.length - 1; i++) {		
			for (int j= i+1; j < numbers.length; j++) {
				if (numbers[j] < numbers[i]) {
					temp = numbers[i];
					numbers[i] = numbers[i];
					numbers[i] = temp;
				}
			}	
		}
		System.out.println();
		System.out.println("ð������:");
		for (int i : numbers) {
			System.out.print(i+" ");
		}
	}
}
