package com.javarush.task.task22.task2213;
/*
Тетрис(8):
1. В классе Figure должно быть создано приватное поле x типа int.
2. В классе Figure должно быть создано приватное поле y типа int.
3. В классе Figure должно быть создано приватное поле matrix типа int[][](целочисленный двумерный массив).
4. В классе Figure должен быть создан корректный геттер для поля х.
5. В классе Figure должен быть создан корректный геттер для поля y.
6. В классе Figure должен быть создан корректный геттер для поля matrix.
7. В классе Figure должен быть создан корректно работающий public конструктор с тремя параметрами int, int и int[][] (x, y и matrix).
Тетрис(10):
1. В классе Figure должен быть создан метод left без параметров.
2. В классе Figure должен быть создан метод right без параметров.
3. В классе Figure должен быть создан метод down без параметров.
4. В классе Figure должен быть создан метод up без параметров.
5. В классе Figure должен быть создан метод rotate без параметров.
6. В классе Figure должен быть создан метод downMaximum без параметров.
7. В классе Figure должен быть создан метод isCurrentPositionAvailable без параметров.
8. В классе Figure должен быть создан метод landed без параметров.
9. Метод isCurrentPositionAvailable должен возвращать true.
 */
public class Figure {
    //region Fields
    private int x;
    private int y;
    private int[][] matrix;
    //endregion


    //region Properties
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
    //endregion

    //region Methods
    public void left(){

    }
    public void right(){

    }
    public void down(){

    }
    public void up(){

    }
    public void rotate(){

    }
    public void downMaximum(){

    }
    public boolean isCurrentPositionAvailable(){
        return true;
    }
    public void landed(){

    }
    //endregion

    public Figure(int x, int y, int[][] matrix){
        this.x=x;
        this.y=y;
        this.matrix = matrix;
    }
}
