package agh.ics.oop;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.util.Arrays;

public class ColorFiller {
    public static Image generateColorImage(int width,int height, int red, int green,int blue,int opacity){

        WritableImage img = new WritableImage(width,height);
        PixelWriter pixelWriter = img.getPixelWriter();

        int pixel = (opacity << 24) | (red<<16) |(green<<8) | blue;
        int[] pixels = new int[width*height];
        Arrays.fill(pixels,pixel);

        pixelWriter.setPixels(0,0,width,height,PixelFormat.getIntArgbInstance(),pixels,0,width);
        return img;
    }
}
