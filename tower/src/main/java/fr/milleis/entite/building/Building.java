package fr.milleis.entite.building;

import java.awt.Point;
import java.awt.image.BufferedImage;

import fr.milleis.entite.Entity;

public class Building extends Entity {
    public int cost;
    public int cooldown;
    public Point target;

    public Building(int x, int y, BufferedImage image) {
        super(x, y, 50, 50, image);
        this.target = null;
    }

}