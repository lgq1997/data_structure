package recursion;

import java.util.Arrays;

public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫,1表示墙
        //左右置为1
        int[][] map = new int[8][7];
        for (int i = 0;i<map.length;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //上下置为1
        for (int i = 0;i<map[0].length;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[6][3] = 1;

        //输出地图
        for (int[] e:map){
            System.out.println(Arrays.toString(e));
        }

        //找路
        System.out.println("**************");
        setWay(map,1,1);
        //输出新地图
        for (int[] e:map){
            System.out.println(Arrays.toString(e));
        }

    }

    //map[i][j] = 0:该点没有走过； 1：墙；  2：可以走；  3：走过但走不通
    //方向：下，右，上，左
    public static Boolean setWay(int[][] map,int i,int j){
        /*
        map 地图
        i j 从哪个位置开始找
         */
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){//如果该点还没有走过，按照方向走
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map,i + 1,j)){//向下走
                    return true;
                }else if (setWay(map,i,j+1)){//否则向右走
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {//说明该点走不通
                    map[i][j] = 3;
                    return false;
                }

            }else {//map[i][j]不等于0，该点走过，可能是1,2,3
                return false;
            }
        }

    }


}
