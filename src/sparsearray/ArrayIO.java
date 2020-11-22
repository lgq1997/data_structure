package sparsearray;
/*
将稀疏数组保存在map.data文件中，再读取
 */
import java.io.*;
import java.util.Arrays;

public class ArrayIO {
    public static void main(String[] args) throws Exception{

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        FileWriter fos = new FileWriter(new File("map.data"));
        BufferedWriter bw = new BufferedWriter(fos);
//        for(int[] i:chessArr1){
//            String s = Arrays.toString(i);
//            bw.write(s);
//            bw.newLine();
//        }
        for (int[] i:chessArr1){
            for(int j:i){
                bw.write((char)(j+48));
            }
            bw.newLine();
        }
        bw.close();
        fos.close();

        FileReader fis = new FileReader(new File("map.data"));
        BufferedReader br = new BufferedReader(fis);
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
        fis.close();
    }
}
