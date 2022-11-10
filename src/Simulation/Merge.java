package Simulation;

import java.util.Arrays;

public class Merge {
    //==================mergesort=================
    private static void mergeSort(int[] arr){
        int[] temp = new int[arr.length]; //存放临时结果

        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int[] arr, int[] temp, int l, int r){
        if (l == r) return;

        int mid = l + (r-l)/2;//如  0 +（3-0）/2=1
        mergeSort(arr, temp, l, mid); //递归调自己，层层拆分    左闭 右闭
        mergeSort(arr, temp, mid + 1, r);

        merge(arr, temp, l ,mid, r);// 合并
    }
    private static void merge(int[] arr, int[] temp, int l, int mid, int r){
        for (int i = 0 ; i < arr.length; i ++){
            temp[i] = arr[i];
        }
        int p1 = l;
        int p2 = mid + 1;
        int k = l;// 用于 遍历 这两个小段的每个元素  以进行 有序合并

        // 直到p1 或 p2  到边界了
        while(p1 <= mid && p2 <= r){ //将两个段 中  当前比较位置的  较小元素  先放到array
            if (temp[p1] < temp[p2]){
                arr[k] = temp[p1];
                p1++;
            }else{
                arr[k] = temp[p2];
                p2++;
            }
            k++;
        }

        while(p1 <= mid){
            arr[k] = temp[p1];
            p1++;
            k++;
        }
        while(p2 <= r){
            arr[k] = temp[p2];
            p2++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,3,2,6,5,8,9,4,7};
//        mergeSort(nums);
        System.out.println(Math.ceil(1.5));

    }
}
