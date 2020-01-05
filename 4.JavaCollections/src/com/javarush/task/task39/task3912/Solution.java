package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int [][] test = {
                {0,0,0,0,0,0,0,0},
                {0,1,1,1,1,0,1,1},
                {0,1,1,1,1,0,1,1},
                {0,1,1,1,1,0,0,0},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,0,0,0,1,1,1,1},
        };
        System.out.println(maxSquare(test));
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));

        }

    }

    public static int maxSquare(int[][] matrix) {
        int sqrt = 0;
        for (int i = matrix.length-2; i >= 0; i--) {
            for (int j = matrix[i].length-2; j >= 0 ; j--) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Stream.of(matrix[i][j + 1], matrix[i + 1][j], matrix[i + 1][j + 1]).min(Integer::compareTo).get() +1;
                    if(matrix[i][j] > sqrt)
                        sqrt=matrix[i][j];
                }
            }
        }
        return sqrt * sqrt;
    }
}
