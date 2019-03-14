package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        solution.recurse("tan(2025 ^ 0.5)", 0); //expected output 1 2

//        solution.recurse("sin( 2 *( -5 +1.5*4)+28) + cos(4+(8-10*2)+10)", 0); //expected output 0.5 6

    }

    public void recurse(final String expression, int countOperation) {
        //implement
//        if (countOperation != 0){
//            NumberFormat format = new DecimalFormat("#.##");
//            System.out.printf("%s %d",format.format(expression) ,countOperation);
//            return;
//        }

        Matcher m = Pattern.compile("(sin|cos|tan|\\^|\\/|\\*|\\-|\\+){1}?").matcher(expression);
        while(m.find()){
            countOperation++;
        }

        char[] signs = {'^', '/', '*', '-', '+'};
        StringBuilder tmpExp = new StringBuilder();
        tmpExp.append(expression.replaceAll("\\s",""));
        Stack<Integer> stack = new Stack<>();
        int lastindex = -1;
        while (tmpExp.indexOf("(")>=0) {
            Matcher mExp = Pattern.compile("(\\(|\\))").matcher(tmpExp);
            if (mExp.find(lastindex+1)) {

                lastindex = mExp.start(1);
            }
            if (mExp.group(1).equals("(")){
                stack.push(lastindex);
            }else if (mExp.group(1).equals(")")){
                if (stack.empty())
                    break;
                int start = stack.pop();
                String subExp = tmpExp.substring(start + 1, lastindex);
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
                tmpExp = tmpExp.replace(start+1,lastindex,subExp);
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

                    tmpExp.replace(0,tmpExp.length(),m.replaceFirst(String.format("%.2G",result)));
                }
                m = Pattern.compile("([-+])\\(((\\1)\\d+\\.?\\d*\\))").matcher(tmpExp);
                while (m.find()){
                    tmpExp.replace(0,tmpExp.length(), m.replaceFirst(m.group().substring(3,m.group().length()-1)));
                }
                m = Pattern.compile("(?<!\\d)\\(([-+]?\\d+\\.?\\d*\\))").matcher(tmpExp);
                while (m.find()){
                    tmpExp.replace(0,tmpExp.length(), m.replaceFirst(m.group().substring(1,m.group().length()-1)));
                }
                m = Pattern.compile("\\(([-+]?\\d+\\.?\\d*\\))").matcher(tmpExp);
                while (m.find()){
                    tmpExp.replace(0,tmpExp.length(), m.replaceFirst(m.group().substring(1,m.group().length()-1)));
                }
                lastindex = lastindex == tmpExp.length() ? 0:start;
            }
        }


        if (countOperation > 0) {
            recurse(tmpExp.toString(),countOperation);
        }
    }

    public Solution() {
        //don't delete
    }
}
