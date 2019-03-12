package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        int result;
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        switch (n) {
            case 0 :
                result = 0;
                break;
            case 1 :
                result =1;
                break;
            case 2:
                result = 1;
                break;
            default:
                result = fibonacci( n - 1) + fibonacci(n - 2);
                break;
        }

        return result * sign;
    }
}
