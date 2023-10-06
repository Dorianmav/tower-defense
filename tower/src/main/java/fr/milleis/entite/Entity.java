package fr.milleis.entite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;

public abstract class Entity extends Rectangle implements Behaviorable {
    public Behavior behavior;

    public BufferedImage image;

    public Entity(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height);
        this.image = image;
    }

    public void paint(Graphics g) {
        g.drawImage(this.image, x, y,25,25, null);
    }

    @Override
    public Behavior getBehavior() {
        return this.behavior;
    }

    @Override
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }
}