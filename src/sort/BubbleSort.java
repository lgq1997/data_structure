package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {56,82,12,4,36,-15,56,82,100};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        bubbleSort2(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序法
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0;i < n-1;i++){
            for (int j = 0;j < n-1-i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //冒泡排序法优化版
    public static void bubbleSort2(int[] arr){
        boolean flag = false;
        int n = arr.length;
        for (int i = 0;i < n-1;i++){
            for (int j = 0;j < n-1-i; j++){
                if (arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
           if (!false){//说明在一趟排序中一次都没有交换过，说明数组已经按照从小到大排序了
               break;
           }else {//否则还将flag置为false，以便进行下次交换
               flag = false;
           }
        }

    }




}
