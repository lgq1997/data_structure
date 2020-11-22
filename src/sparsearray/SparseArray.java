package sparsearray;
import java.io.*;
import java.util.Arrays;
/*
二维数组和稀疏数组的转化
 */
//把系数矩阵存进map.data文件中，再从文件中读取该矩阵
public class SparseArray {
    public static void main(String[] args) throws Exception{
        //创建原始稀疏数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出原始二维数组
        System.out.println("原始二维数组为：");
        for(int[] i:chessArr1){
            System.out.println(Arrays.toString(i));
        }

        //将二维数组转为稀疏数组
        //1.先遍历二维数组，得到非0元素的个数
        int sum = 0;
        for(int[] i:chessArr1){
            for(int j:i){
                if(j != 0){
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组复制
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;
        //遍历二维数组，将非0元素放入稀疏数组中
        int count = 0;//记录非0元素的个数
        for(int i = 0;i<chessArr1.length;i++){
            for (int j = 0;j<chessArr1[0].length;j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组为：");
        for(int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        //将稀疏数组恢复为二维数组
        //1.根据稀疏数组第一行的值创建初始二维数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2.读取稀疏数组后几行的数据，赋给原始二维数组
        for (int i = 1;i<sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组为：");
        for (int[] i:chessArr2){
            for (int j:i){
                System.out.printf("%d\t",j);
            }
            System.out.println();
        }
    }
}
