package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);
        tree.insert(17);
        tree.insert(22);
        tree.insert(25);
        tree.insert(27);
        System.out.println(tree);
    }
}
