package huaWeiOd.array;
/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * 
*/
public class NC73_MoreThanHalfNum {

	public static int MoreThanHalfNum_Solution(int[] array) {
		int count = 0;
		int length = array.length;
		for (int i = 0; i < length; i++) {
			count = 0;
			for (int j = 0; j < length; j++) {
				if (array[i] == array[j])
					count++;
				if (count > length / 2) {
					return array[i];
				}
			}

		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,2,4,2,5,2,3};
		System.out.println(MoreThanHalfNum_Solution(array) );
	}

}
