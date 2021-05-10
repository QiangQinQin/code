package array;
/*
 * 题目：
 * 给出两个 有序 的整数数组 A和B ，请将数组 B合并到数组 A中，变成一个有序的数组
 *注意：
 *可以假设 A数组有足够的空间存放 B数组的元素，A 和 B中初始的元素数目分别为 m和 n
 *
 *解析 ：
 *数组本身有序
 *不让new数组
 *把A后面剩余的空间当额外空间，从后面往前放就可以避免大量移动
 *A长m，B长n，两个合并完之后必定长m+n，所在A的A[m+n-1]开始往前放
 *应该为由小到大顺序
*/
public class NC22_Merge {
	
	    public static void merge(int A[], int m, int B[], int n) {
	    	int i=m-1,j=n-1;
	        int cursor=m+n-1;
	        while(i>=0 && j>=0)//两个数组没比完
	        {
	            if(A[i]>B[j]) //保存大的
	            	A[cursor--]=A[i--];
	            else 
	            	A[cursor--]=B[j--];
	        }
	        
	        while(i>=0)//A数组有剩余
	        {
	             A[cursor--]=A[i--];
	        }
	        while(j>=0)//B数组有剩余
	        {
	            A[cursor--]=B[j--];
	        }
	      //  System.out.println(A);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= new int[20];
		A[0]=1;
		A[1]=3;
		A[2]=5;
		A[3]=7;
		A[4]=10;
		
		int[] B= {3,4,5,8,9,12};
		merge(A,5,B,6);
	

	}

}
