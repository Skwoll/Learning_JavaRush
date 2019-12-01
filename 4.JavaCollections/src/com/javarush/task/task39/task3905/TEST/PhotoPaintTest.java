package com.javarush.task.task39.task3905.TEST;

import com.javarush.task.task39.task3905.Color;
import com.javarush.task.task39.task3905.PhotoPaint;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PhotoPaintTest {

    Color[][] image = {{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
    Color[][] imageOut = {{Color.BLUE,Color.BLUE,Color.BLUE},{Color.BLUE,Color.BLUE,Color.BLUE},{Color.BLUE,Color.YELLOW,Color.BLUE}};

    private PhotoPaint paint;
    @Before
    public void init(){
        paint = new PhotoPaint();
    }
    @Test
    public void paintFill() {

        assertEquals(true,paint.paintFill(image,0,0,Color.BLUE));
        assertArrayEquals(imageOut,image);
    }
    @Test
    public void paintFill1() {
        assertEquals(false,paint.paintFill(image,-1,0,Color.BLUE));
    }
    @Test
    public void paintFill2() {
        assertEquals(false,paint.paintFill(image,0,0,Color.GREEN));
    }
    @Test
    public void paintFill3() {
        image = new Color[][]{{null,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        imageOut = new Color[][]{{null,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        assertEquals(false,paint.paintFill(image,0,0,Color.BLUE));
        for (Color[] colors : image) {
            System.out.println(Arrays.toString(colors));
        }
        assertArrayEquals(imageOut,image);
    }
    @Test
    public void paintFill4() {
        image = new Color[][]{{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        imageOut = new Color[][]{{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};;
        assertEquals(false,paint.paintFill(image,0,0,null));
        assertArrayEquals(imageOut,image);

    }
    @Test
    public void paintFill5() {
        image = new Color[][]{{null,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        imageOut = new Color[][]{{null,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        assertEquals(false,paint.paintFill(image,0,0,null));
        assertArrayEquals(imageOut,image);
    }
    @Test
    public void paintFill6() {
        image = null;
        imageOut = null;
        assertEquals(false,paint.paintFill(image,0,0,null));
        assertArrayEquals(imageOut,image);
    }

    @Test
    public void paintFill7() {
        image = null;
        imageOut = null;
        assertEquals(false,paint.paintFill(image,0,0,Color.BLUE));
        assertArrayEquals(imageOut,image);
    }
    @Test
    public void paintFill8() {
        image = new Color[][]{{Color.YELLOW,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        imageOut = new Color[][]{{Color.BLUE,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};;
        assertEquals(true,paint.paintFill(image,0,0,Color.BLUE));
        assertArrayEquals(imageOut,image);
    }

    @Test
    public void paintFill9() {
        image = new Color[][]{{Color.RED,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.YELLOW},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        imageOut = new Color[][]{{Color.RED,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.YELLOW},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        assertEquals(false,paint.paintFill(image,0,0,Color.RED));
        for (Color[] colors : image) {
            System.out.println(Arrays.toString(colors));
        }
        for (Color[] colors : imageOut) {
            System.out.println(Arrays.toString(colors));
        }
        assertArrayEquals(imageOut,image);

    }

}