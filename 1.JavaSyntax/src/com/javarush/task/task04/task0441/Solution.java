package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        final int n = 3, mod = n-1;
        int[] number =  new int[n];
        Scanner s = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            number[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if ((number[(mod+i)%n] <= number[i] && number[i] <= number[(i+1)%n])|
                    (number[(mod+i)%n] >= number[i] && number[i] >= number[(i+1)%n])   ) {
                System.out.println(number[i]);
                break;
            }
//            System.out.println((mod+i)%n + " "+i+" "+(i+1)%n);

        }

    }
}
