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
Построй дерево(5)
1. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
2. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
3. Если переданный объект не является строкой, метод remove() должен бросить UnsupportedOperationException.
4. Если ни один элемент не способен иметь потомков, необходимо восстановить такую возможность.
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    //region Attributes
    Entry<String> root;
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
            if(!currentEntry.isAvailableToAddChildren() && currentEntry.leftChild == null && currentEntry.rightChild == null){
                currentEntry.availableToAddLeftChildren=true;
                currentEntry.availableToAddRightChildren=true;
            }

            if(currentEntry.isAvailableToAddChildren()){
                if (currentEntry.availableToAddLeftChildren) {
                    currentEntry.leftChild = new Entry<>(s);
                    currentEntry.leftChild.parent = currentEntry;
                    currentEntry.availableToAddLeftChildren = false;
                    added = true;
                }else{
                    currentEntry.rightChild = new Entry<>(s);
                    currentEntry.rightChild.parent = currentEntry;
                    currentEntry.availableToAddRightChildren = false;
                    added = true;
                }
            }else {
                if(currentEntry.leftChild != null){
                    queue.add(currentEntry.leftChild);
                }
                if (currentEntry.rightChild != null) {
                    queue.add(currentEntry.rightChild);
                }
                if (!queue.isEmpty()){
                    currentEntry = queue.poll();
                }
            }
        }

        return added;
    }

    public String getParent (String EntryName){
        Entry<String> currentEntry;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        String name = "null";

        while (!queue.isEmpty()){
                currentEntry = queue.poll();
            if (currentEntry.elementName.equals(EntryName))
            {
                name = currentEntry.parent.elementName;
                break;
            }
            if (currentEntry.leftChild != null) {

                queue.add(currentEntry.leftChild);
            }
            if (currentEntry.rightChild != null){
                queue.add(currentEntry.rightChild);
            }
        }
        return name;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        boolean deleted = false;
        Entry<String> currentEntry;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            currentEntry = queue.poll();
            if (currentEntry.elementName.equals(o))
            {
                if(currentEntry.parent.leftChild==currentEntry){
                    currentEntry.parent.leftChild=null;
                }
                if(currentEntry.parent.rightChild==currentEntry){
                    currentEntry.parent.rightChild=null;
                }

                deleted = true;
                break;
            }

//            currentEntry.checkChildren();

            if (currentEntry.leftChild != null) {
                queue.add(currentEntry.leftChild);
            }
            if (currentEntry.rightChild != null){
                queue.add(currentEntry.rightChild);
            }
        }

        return deleted;

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
        Entry<String> currentEntry;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        int size = -1;

        while (!queue.isEmpty()){
            currentEntry = queue.poll();
            size++;
            if (currentEntry.leftChild != null) {

                queue.add(currentEntry.leftChild);
            }
            if (currentEntry.rightChild != null){
                queue.add(currentEntry.rightChild);
            }
        }
        return size;
    }
    //endregion

    //region Constructors
    public CustomTree (){
        root = new Entry<>("Noname");
        root.lineNumber = 1;
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
