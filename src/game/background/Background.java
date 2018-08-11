package game.background;

import base.GameObject;
import renderer.ImageRenderer;
import renderer.RectRenderer;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        this.renderer = new ImageRenderer("image/8320.jpg", 1300, 760);
    }
}
