package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void PrintName () {
        System.out.println(this.toString());
    }

    public void PrintClassName (){
        System.out.println(this.getClass().getSimpleName());
    }
}
