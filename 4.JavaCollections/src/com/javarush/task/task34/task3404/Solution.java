package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();


//        Matcher m = Pattern.compile("-?\\d+\\.?\\d*\\*-?\\d+\\.?\\d*").matcher("355+45*4");
//        m.find();
//        System.out.println(m.replaceFirst("a"));
//        System.out.println(m.replaceFirst("aa"));
//        System.out.println(m.replaceFirst("aaa"));
//        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recurse("tan(2025 ^ 0.5)", 0); //expected output 1 2
//
//        solution.recurse("-(-22+22*2) ", 0); //expected output -22 4
//        solution.recurse("0+0.304", 0); //expected output 0.3 1
//        solution.recurse("-2^(-2)", 0); //expected output -0.25 3
//        solution.recurse("tan(44+sin(89-cos(180)^2))", 0); //expected output 1 6
        solution.recurse("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", 0); //expected output 8302231.36 14



    }

    public void recurse(final String expression, int countOperation) {
        //implement

        NumberFormat format = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        Matcher m = Pattern.compile("(sin|cos|tan|\\^|\\/|\\*|(\\d|\\))\\-|\\+){1}?").matcher(expression);
        if (!m.find()){
            System.out.printf("%s %d\n",format.format(Double.parseDouble(expression)) ,countOperation);
            return;
        }

        if (countOperation == 0) {
            m = Pattern.compile("(sin|cos|tan|\\^|\\/|\\*|\\-|\\+){1}?").matcher(expression);
            while(m.find()){
                countOperation++;
            }
        } else {
        }

        char[] signs = {'^', '/', '*', '-', '+'};
        StringBuilder tmpExp = new StringBuilder();
        tmpExp.append(expression.replaceAll("\\s",""));
        Stack<Integer> stack = new Stack<>();
        int lastIndex = -1;
        int start = -1;
        while (tmpExp.indexOf("(")>=0) {
            Matcher mExp = Pattern.compile("(\\(|\\))").matcher(tmpExp);
            if (mExp.find(lastIndex+1)) {

                lastIndex = mExp.start(1);
            }
            if (mExp.group(1).equals("(")){
                stack.push(lastIndex);
            }else if (mExp.group(1).equals(")")){
                if (stack.empty())
                    break;
                start = stack.pop();
                break;
            }
        }
        if(lastIndex <= 0) lastIndex = tmpExp.length();
        String subExp = tmpExp.substring(start + 1, lastIndex);
        for (char c : signs) {
            String pattern = String.format("-?\\d+\\.?\\d*\\%s-?\\d+\\.?\\d*", c);
            Pattern p = Pattern.compile(pattern);
            m = p.matcher(subExp);
            while (m.find()){
                String exp = m.group();
                double a = Double.parseDouble(exp.substring(0,exp.lastIndexOf(c)));
                double b = Double.parseDouble(exp.substring(exp.lastIndexOf(c)+1));
                double result=0;
                switch (c) {
                    case '^':
                        result = Math.pow(a,b);
                        break;
                    case '/':
                        result = a / b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '+':
                        result = a + b;
                        break;
                }
                result = new BigDecimal(result).setScale(4, RoundingMode.HALF_UP).doubleValue();

                subExp = m.replaceFirst(String.valueOf(result));
            }
        }
        tmpExp = tmpExp.replace(start+1,lastIndex,subExp);
        m = Pattern.compile("(sin|cos|tan)\\((-?\\d+\\.?\\d*\\))").matcher(tmpExp);
        while (m.find()){
            subExp = m.group();
            double result = Double.parseDouble(subExp.substring(4,subExp.length()-1));

            result = Math.toRadians(result);
            switch (subExp.substring(0, 3)) {
                case "sin":
                    result = Math.sin(result);
                    break;
                case "cos":
                    result = Math.cos(result);
                    break;
                case "tan":
                    result = Math.tan(result);
                    break;
            }
            result = new BigDecimal(result).setScale(4, RoundingMode.HALF_UP).doubleValue();

//                    tmpExp.replace(0,tmpExp.length(),m.replaceFirst(String.format("%.2G",result)));
            tmpExp.replace(0,tmpExp.length(),m.replaceFirst(format.format(result)));
        }
        m = Pattern.compile("([-+])\\(((\\1)\\d+\\.?\\d*\\))").matcher(tmpExp);
        while (m.find()){
            tmpExp.replace(0,tmpExp.length(), m.replaceFirst(m.group().substring(3,m.group().length()-1)));
        }
        m = Pattern.compile("(?<!\\d)\\(([-+]?\\d+\\.?\\d*\\))").matcher(tmpExp);
        while (m.find()){
            tmpExp.replace(0,tmpExp.length(), m.replaceFirst(m.group().substring(1,m.group().length()-1)));
        }
        m = Pattern.compile("\\(([-+]?\\d+\\.?\\d*)\\)").matcher(tmpExp);
        while (m.find()){
            tmpExp.replace(0,tmpExp.length(), m.replaceFirst(m.group().substring(1,m.group().length()-1)));
        }
        lastIndex = lastIndex == tmpExp.length() ? 0:start;

        recurse(tmpExp.toString(),countOperation);
    }

    public Solution() {
        //don't delete
    }
}
