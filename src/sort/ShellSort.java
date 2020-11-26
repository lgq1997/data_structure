package sort;

import java.util.Arrays;

/*
希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
//        int arr[] = {56,82,12,4,36,-15};
        int arr[] = {8,9,1,7,2,3,5,4,6,0};
//        int arr[] = {1,2,3,5,4,0};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        sehllSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //移位法，用插入排序法
    public static void sehllSort(int[] arr){
        for (int gap = arr.length/2;gap > 0;gap /= 2){
            for (int i = gap;i<arr.length;i++){//0~gap分别对应gap个组的第0个元素，这部分是默认在组中的，不需要进行插入，然后遍历数组内其余的所有数，即gap~arr.length
                int temp = arr[i];//待插入的数据
                int j;
                for (j = i - gap;j >= 0;j = j-gap){//插入排序法
                    if (arr[j] < temp){
                        break;
                    }else{
                        arr[j + gap] = arr[j];
                    }
                }
                arr[j + gap] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //交换法,效率低
    public static void sehllSort2(int[] arr){
        for (int gap = arr.length/2;gap > 0;gap /= 2){
            for (int i = gap;i<arr.length;i++){
                for (int j = i-gap;j>=0;j-=gap){
                    if (arr[j] > arr[j + gap]){
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


}
