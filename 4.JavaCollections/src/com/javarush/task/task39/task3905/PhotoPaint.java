package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (image == null || desiredColor == null )
            return false;

        Color currentColor;
        try {
            if (image[y]==null)
                return false;
            currentColor = image[y][x];

        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
        if (currentColor==desiredColor) {
            return false;
        }
        if (currentColor == null ) {
            return false;
        }
        paintFill(image, x, y, desiredColor, currentColor);

        return true;
    }

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor, Color currentColor) {
        try {
            if ( currentColor != image[y][x]) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        image[y][x] = desiredColor;
        for (int i = 0; i < 360; i += 90) {
            try {
                paintFill(image, x + (int) Math.cos(Math.toRadians(i)), y + (int) Math.sin(Math.toRadians(i)), desiredColor, currentColor);
            } catch (Exception e) {
            }
        }
        return true;
    }
}
