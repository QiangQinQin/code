package huaWeiOd.array;
/*
 * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
  (例如,0 1 2 4 5 6 7可能变为4 5 6   7 0 1 2).
       在数组中搜索给出的目标值，如果能在数组中找到，返回它的   索引  ，否则返回-1。
       假设数组中不存在重复项。
   
    自己分析：
    //假设先是从小到大的顺序
    //逐个暴力比较  （费时间）
    //先排序，再找
    //边排序，边找          二分法   ：其中一半肯定有序，通过比较首尾值判断有序；有序的话，就看在此范围里吗；无序的话就把他一分为2，再找   4 5 6    7 0 1 2
    //数字少时暴力    数字多时二分
    //找到旋转点
  网络解析：
             不用排序，根据边界值，快速决定查找方向，即可二分快速找到
    
    }
 */

public class NC48_Search {
	public int search (int[] A, int target) {
	        if (A == null || A.length == 0)
	            return -1;
	        
	        int low = 0, 
	        	high = A.length - 1;
	         
	        //二分（直到下标low>high）
	        while (low <= high) {
	        	
	            int mid = low + ((high - low) >> 1);
	            
	            if (A[mid] == target)
	                return mid;//即索引
	             
	            //左区间 有序  并且 值在其范围内
	            if (A[low] <= A[mid] && (A[low] <= target && target < A[mid]))// low ... mid-1
	            	high = mid - 1;
	            //右区间有序  并且  值不在其范围内（比判断  目标是否在无序的左区间里简单）
	            else if (A[mid] <= A[high] && !(A[mid] < target && target <= A[high]))//mid+1...high
	            	high = mid - 1;
	            //以上，都时在左区间找
	            
	            else
	                low = mid + 1;
	        }
	        return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
