package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.


Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/
public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list;
        long[] result = null;
        list = new ArrayList<>();

        int length = getDegree(N);
        long[][] paws  = pawInit(length);

        for (int i = 0; i <= length; i++) {
            newArmstrong(0,i,N,0,1,list,paws);
        }

        Collections.sort(list);

//        list.removeIf(aLong -> aLong >=N);

        result = list.size() >= 0? new long[list.size()] :new long[0];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void newArmstrong(int LastDigit, int Paw, long MaxNumber, long LastNum, int DigNum,List<Long> values,long[][] paws){
        for (int i = LastDigit; i < 10; i++) {
            long currNum = LastNum+paws[i][Paw];
            if (currNum >= MaxNumber){
                return;
            }
            if (Paw == DigNum && currNum == getPaws(currNum,paws) && values.indexOf(currNum) ==-1 && currNum>0 ){
                values.add((long)currNum);
            }
            if (DigNum < Paw){
                newArmstrong(i,Paw,MaxNumber,currNum,DigNum+1,values,paws);
            }

        }
    }

    public static long getPaws (long N,long[][] paws){
        int len = getDegree(N);
        long sum = 0;
        if (N%10 < 0)
            return 0;
        do {
            int i = (int)(N%10);
            sum += paws[i][len];

        } while ((N /= 10) > 0 );
        return sum;
    }

    public static int getDegree(long i){
        int degree = 0;

        do {
            degree += 1;
        } while ( (i /= 10) > 0);
        return degree;
    }

    public static long[][] pawInit(int length){
        long [][] tmp = new long[10][length+1];

        for (int i = 0; i <10; i++) {
            tmp[i][0]=1;
            tmp[i][1]=i;

        }
        for (int i = 0; i < 10; i++) {
            for (int j = 2; j <length+1; j++) {
                tmp[i][j]=tmp[i][j-1]*tmp[i][1];
            }
        }
        return tmp;
    }
    public static void main(String[] args) {


        long number = 912985154L;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        long[] a = getNumbers(number);
        long memoryAfterCalculate = Runtime.getRuntime().totalMemory();
        long delta = memoryAfterCalculate - freeMemory;
        long stopTime = System.currentTimeMillis();
        System.out.println("Time: " + (stopTime - startTime));
        System.out.println("Memory: " + delta);
        System.out.println(a.length);
        for (long i : a) {
            System.out.print(i + " ");
        }
        System.out.println();



        for (long i : getNumbers(50000L)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (long i : getNumbers(1_000_000L)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (long i : Solution.getNumbers(7)) {
            System.out.print(i + " ");
        }
        System.out.println();




    }
}
