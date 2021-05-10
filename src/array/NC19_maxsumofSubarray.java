package array;
/*
 * 给定一个数组arr，返回   子数组（连续）  的最大累加和
例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
题目保证没有全为负数的数据
[要求]
时间复杂度为O(n)
空间复杂度为O(1)
1<N<10^5
array[i]<=100
 */
public class NC19_maxsumofSubarray {
	public static int maxsumofSubarray (int[] arr) {
        // write code here
		int max = 0,//前面部分累加的最大的子数组和 
				temp = 0;//子数组和
		 
	     for ( int i = 0; i < arr.length; i++ ) {
	         temp += arr[i];

	         if ( temp > max) max = temp;//比之前    子数组最大和    大，就重置max，否则仍保持前面的max值
	         if ( temp < 0 ) temp = 0;//加完此数后 前面累加和为负，肯定越加越小，因为不加前面的至少不变小。就从下一位重新开始累加
	     }
	     return max;

    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1, -2, 3, 5, -2, 6, -1};
		System.out.println(maxsumofSubarray (array) );

	}

}
