package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;



/* 
Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать статический класс Word.
3. Класс Solution не должен содержать статические поля.
4. Метод detectAllWords должен быть статическим.
5. Метод detectAllWords должен быть публичным.
6. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same","orgn").forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static boolean findWord (Word WordObj, int Lvl, int CurrentX, int CurrentY, int[][] Crossword){
        int maxX = Crossword[1].length;
        int maxY = Crossword.length;

        if (Lvl > WordObj.text.length()-1){
            return false;
        }
        if (Lvl == 0) {
            for (int i = 0; i <maxY; i++) {
                for (int j = 0; j < maxX; j++) {
                    if(WordObj.text.charAt(Lvl)==(char)Crossword[i][j]){
                        WordObj.startX = j;
                        WordObj.endX = j;
                        WordObj.startY = i;
                        WordObj.endY = i;
                        if (Lvl == WordObj.text.length()-1){
                            return true;
                        }

                        if(findWord(WordObj,Lvl+1,0,0,Crossword)){
                            return true;
                        }
                    }
                }

            }
        }else {
            if (CurrentX == 0 && CurrentY == 0) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        try {
                            if (i == 0 && j == 0 ){
                                continue;
                            }
//                            System.out.println("1 "+(i!= 0 || j!= 0));
//                            System.out.println("2 "+(WordObj.text.charAt(Lvl) == (char)Crossword[WordObj.startY+i][WordObj.startX+j]));
//                            System.out.println("3 "+((i!= 0 || j!= 0)&&(WordObj.text.charAt(Lvl) == (char)Crossword[WordObj.startY+i][WordObj.startX+j])));
                            if ( (i!= 0 || j!= 0) && (WordObj.text.charAt(Lvl) == (char)Crossword[WordObj.startY+i][WordObj.startX+j]) ) {
                                WordObj.endX = j + WordObj.startX;
                                WordObj.endY = i + WordObj.startY;
                                if (Lvl == WordObj.text.length()-1){
                                    return true;
                                }

                                if(findWord(WordObj,Lvl+1,j,i,Crossword)){
                                    return true;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
//                            e.printStackTrace();
                        }
                    }
                }
            } else {
                if (WordObj.text.charAt(Lvl) == (char)Crossword[WordObj.endY+CurrentY][WordObj.endX+CurrentX]){
                    WordObj.endX += CurrentX ;
                    WordObj.endY += CurrentY ;
                    if (Lvl == WordObj.text.length()-1){
                        return true;
                    }

                    if(findWord(WordObj,Lvl+1,CurrentX,CurrentY,Crossword)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String s : words) {
            Word word = new Word(s);
            list.add(word);
            findWord(word,0,0,0,crossword);
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
