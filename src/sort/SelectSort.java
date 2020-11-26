package sort;

import java.util.Arrays;

/*
选择排序法
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {56,82,12,4,36,-15,56,82,100,3};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr){
        for (int i = 0;i<arr.length - 1;i++){
            int temp = i;
            for (int j = i + 1;j<arr.length;j++){
                if (arr[j] < arr[temp]){
                    temp = j;
                }
            }
            if(temp != i){
                int value = arr[temp];
                arr[temp] = arr[i];
                arr[i] = value;
            }
        }
    }


}
