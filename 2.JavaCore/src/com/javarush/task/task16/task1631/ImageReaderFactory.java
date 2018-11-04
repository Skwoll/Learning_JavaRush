package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import javax.imageio.ImageTypeSpecifier;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException{
        ImageReader imageReader=null;

        try {
            ImageTypes.valueOf(imageType.name());
            switch (imageType) {
                case BMP:
                    imageReader = new BmpReader();
                    break;
                case JPG:
                    imageReader = new JpgReader();
                    break;
                case PNG:
                    imageReader = new PngReader();
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return imageReader;
    }
}
