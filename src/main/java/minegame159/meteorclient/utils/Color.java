package minegame159.meteorclient.utils;

public class Color {
    public int r, g, b, a;

    public Color() {
        this(255, 255, 255, 255);
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        a = 255;

        validate();
    }

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        validate();
    }

    public Color(int packed) {
        r = toRGBAR(packed);
        g = toRGBAG(packed);
        b = toRGBAB(packed);
        a = toRGBAA(packed);
    }

    public Color(Color color) {
        this.r = color.r;
        this.g = color.g;
        this.b = color.b;
        this.a = color.a;
    }

    public void set(Color value) {
        r = value.r;
        g = value.g;
        b = value.b;
        a = value.a;

        validate();
    }

    public void validate() {
        if (r < 0) r = 0;
        else if (r > 255) r = 255;

        if (g < 0) g = 0;
        else if (g > 255) g = 255;

        if (b < 0) b = 0;
        else if (b > 255) b = 255;

        if (a < 0) a = 0;
        else if (a > 255) a = 255;
    }

    public int getPacked() {
        return fromRGBA(r, g, b, a);
    }

    @Override
    public String toString() {
        return r + " " + g + " " + b + " " + a;
    }

    public static int fromRGBA(int r, int g, int b, int a) {
        return (r << 16) + (g << 8) + (b << 0) + (a << 24);
    }
    public static int toRGBAR(int color) {
        return (color >> 16) & 0x000000FF;
    }
    public static int toRGBAG(int color) {
        return (color >> 8) & 0x000000FF;
    }
    public static int toRGBAB(int color) {
        return (color >> 0) & 0x000000FF;
    }
    public static int toRGBAA(int color) {
        return (color >> 24) & 0x000000FF;
    }
}
