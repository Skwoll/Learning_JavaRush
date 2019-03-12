package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        if (n==1) return;
        double div = 2;
        while(div <= n){
            if ( n % div ==0){
                System.out.print((int)div+" ");
                recurse(n / (int)div);
                break;
            }
            if(div<=2) div++;
            else div+=2;
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(84);
    }
}
