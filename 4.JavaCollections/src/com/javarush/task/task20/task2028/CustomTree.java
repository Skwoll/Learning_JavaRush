package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(2)
1. При попытке вызвать метод get(int index) должно возникать исключение типа UnsupportedOperationException.
2. При попытке вызвать метод set(int index, String element) должно возникать исключение типа UnsupportedOperationException.
3. При попытке вызвать метод add(int index, String element) должно возникать исключение типа UnsupportedOperationException.
4. При попытке вызвать метод String remove(int index) должно возникать исключение типа UnsupportedOperationException.
5. При попытке вызвать метод subList(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.
6. При попытке вызвать метод removeRange(int fromIndex, int toIndex) должно возникать исключение типа UnsupportedOperationException.
7. При попытке вызвать метод addAll(int index, Collection<? extends String> c) должно возникать исключение типа UnsupportedOperationException.
Построй дерево(3)
1. Класс CustomTree.Entry должен быть объявлен с модификатором доступа по умолчанию.
2. Класс CustomTree.Entry должен поддерживать интерфейс Serializable.
3. В классе CustomTree.Entry должно существовать поле elementName типа String.
4. В классе CustomTree.Entry должно существовать поле availableToAddLeftChildren типа boolean.
5. В классе CustomTree.Entry должно существовать поле availableToAddRightChildren типа boolean.
6. В классе CustomTree.Entry должно существовать поле parent типа Entry.
7. В классе CustomTree.Entry должно существовать поле leftChild типа Entry.
8. В классе CustomTree.Entry должно существовать поле rightChild типа Entry.
9. В классе CustomTree.Entry должен быть корректно реализован конструктор с одним параметром типа String (смотри условие).
10. В классе CustomTree.Entry должен корректно реализован метод isAvailableToAddChildren (смотри условие).
Построй дерево(4)
1. В классе CustomTree должно существовать поле root типа Entry.
2. В классе CustomTree должны быть переопределены методы add(String s) и size().
3. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    //region Attributes
    Entry<String> root;
    int size;
    //endregion

    //region Methods
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
//        return null;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
//        return super.set(index, element);
    }

    @Override
    public boolean add(String s) {
        boolean added =false;

        Entry<String> currentEntry = root;
        Queue<Entry> queue = new LinkedList<>();

        while (!added){
            currentEntry.checkChildren();
            if(currentEntry.isAvailableToAddChildren()){
                if (currentEntry.availableToAddLeftChildren) {
                    currentEntry.leftChild = new Entry<>(s);
                    currentEntry.leftChild.parent = currentEntry;
                    added = true;
                }else{
                    currentEntry.rightChild = new Entry<>(s);
                    currentEntry.rightChild.parent = currentEntry;
                    added = true;
                }
            }else {
                queue.add(currentEntry.leftChild);
                queue.add(currentEntry.rightChild);
                if (!queue.isEmpty()){
                    currentEntry = queue.poll();
                }
            }
        }
        this.size++;

        return added;
    }

    public String getParent (String EntryName){
        Entry<String> currentEntry;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        String name = "";

        while (!queue.isEmpty()){
                currentEntry = queue.poll();
            if (currentEntry.elementName.equals(EntryName))
            {
                name = currentEntry.parent.elementName;
                break;
            }
            currentEntry.checkChildren();

            if (!currentEntry.availableToAddLeftChildren) {
                queue.add(currentEntry.leftChild);
                }
            if (!currentEntry.availableToAddRightChildren){
                queue.add(currentEntry.rightChild);
            }

        }

        return name;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
//        super.add(index, element);
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
//        return super.remove(index);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
//        return super.addAll(index, c);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
//        return super.subList(fromIndex, toIndex);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
//        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public int size() {
        return size;
    }
    //endregion

    //region Constructors
    public CustomTree (){
        root = new Entry<>("Noname");
        root.lineNumber = 1;
        size = 0;
    }
    //endregion

    //region Classes
    static class Entry<T> implements Serializable{
        //region Attributes
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        //endregion

        //region Constructors
        public Entry(String elementName){
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        //endregion

        //region Methods
        void checkChildren (){
            availableToAddLeftChildren = leftChild == null;
            availableToAddRightChildren = rightChild ==null;
        }

        boolean isAvailableToAddChildren(){
            return availableToAddRightChildren || availableToAddLeftChildren;
        }
        //endregion

    }
    //endregion
}
