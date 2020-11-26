package sort;

import java.util.Arrays;
/*
插入排序法
 */
public class InsertSort {
    public static void main(String[] args) {
//        int arr[] = {56,82,12,4,36,-15,56,82,100,3};
        int arr[] = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insertSort2(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int insertValue = arr[i]; //待插入的数
            int j;
            for (j = i-1;j >= 0;j--){
                if (arr[j] < insertValue){
                    break;
                }else{
                    arr[j + 1] = arr[j];//元素后移
                }
//                arr[j + 1] = insertValue;
            }
            arr[j + 1] = insertValue;
        }

//        for (int i = 1;i<arr.length;i++){
//            int insertValue = arr[i]; //待插入的数
//            for (int j = i-1;j >= 0;j--){
//                if (arr[j] < insertValue){
//                    arr[j + 1] = insertValue;
//                    break;
//                }else{
//                    arr[j + 1] = arr[j];//元素后移
//                    if (j == 0){
//                        arr[j] = insertValue;
//                    }
//                }
//
//            }
//
//        }
    }

    //法二
    public static void insertSort2(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int insertValue = arr[i]; //待插入的数
            int insertIndex = i - 1;//从待插入数的前一个数起向前寻找该插入的位置
            while(insertIndex >= 0 && insertValue <arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出while循环后，说明要插入的位置已经找到了，为insertIndex+1
            if(insertIndex + 1 != i){
                arr[insertIndex + 1] = insertValue;
            }
        }
    }
}
