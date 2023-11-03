//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;

public class Box {
    int w;
    int h;
    int d;
    Box c;
    Color color;

    public Box() {
    }

    public Box(int w, int h, int d) {
        this.w = w;
        this.h = h;
        this.d = d;
    }

    public Box(int w, int h, int d, Box c) {
        this(w, h, d);
        this.c = c;
    }

    public int getVolume() {
        return this.w * this.h * this.d;
    }

    public int getVolume(int w, int h, int d) {
        return w * h * d;
    }

    public void setColor(Box c) {
        this.c = c;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    protected int getWidth() {
        return this.w;
    }
}
