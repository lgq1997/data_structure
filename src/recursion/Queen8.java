package recursion;

import java.util.Queue;
/*
八皇后问题
8*8的棋盘，8个皇后，任意两个皇后不能出现在棋盘的同一行、同一列、同一斜线上
 */
public class Queen8 {
    int max = 8;//皇后数
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        //测试
        Queen8 q = new Queen8();
        q.check(0);
        System.out.println("一共有" + count + "种解法");

    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if (n == max){//一共0-7个皇后，n=8说明8个皇后都放好了
            print();//打印位置
            return;//返回
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0;i< max;i++){//遍历8列
            //先放置当前的皇后，放在第一列
            array[n] = i;
            //判断是否冲突
            if (judge(n)){//当前的位置不冲突
                check(n + 1);//放置下一个皇后
            }
            //如果冲突，就放在下一个位置
        }

    }

    //防止第n个皇后时，去检测是否和前边已经摆放过的冲突
    private boolean judge(int n){
        for (int i = 0;i < n;i++){
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //方法：打印皇后的位置
    private void print(){
        count++;
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }



}
