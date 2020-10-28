package data_structures;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;

/**
 * @author Ly.
 * @create 2020-10-18 10:49
 */
public class Test01_Sparsearray {
    public static void main(String[] args) {
        /*
        第一行(下标为0)记录一共几行几列以及个数
        往后记录每个值的位置
        --行(在二维数组中的行)--列(在二维数组中的列)--值(该坐标的值)
         */
        /*
        第一步,数组转稀疏数组
         */
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 1;
        for (int[] ints : chessArr1) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        //转化
        //第一步,获取行列数和值的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    sum ++;
                }
            }
        }
        //System.out.println(sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[1].length;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("output/chess.txt"));

            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < sparseArr[i].length; j++) {
                    fileWriter.write(sparseArr[i][j] + "\t");
                }
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //稀疏数组转二维数组
        System.out.println("=========稀疏数组转二维数组=========");
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //读文件未完成;
        BufferedReader bufferedReader = null;
        int[][] chessArr3 = new int[0][];
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("output/chess.txt")));
            String line;
            Boolean flag = true;
            while ((line = bufferedReader.readLine()) != null){
                if(flag){
                    String[] split = line.split("\t");
                    flag = false;
                    chessArr3 = new int[Integer.parseInt(split[0])][sparseArr[0][1]];
                }
            }
            while ((line = bufferedReader.readLine()) != null){
                if(!flag){
                    flag = true;
                }else {
                    String[] split = line.split("\t");
                    sparseArr[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = sparseArr[Integer.parseInt(split[0])][2];
                }
            }
            System.out.println("======chessArr3==========");
            for (int[] ints : chessArr3) {
                for (int i : ints) {
                    System.out.print(i + "\t");
                }
                System.out.println();
            }

            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < sparseArr[i].length; j++) {
                    fileWriter.write(sparseArr[i][j] + "\t");
                }
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        for (int[] ints : chessArr2) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }


    }
}
