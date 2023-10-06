package fr.milleis.entite.enemy;

import java.awt.image.BufferedImage;

import fr.milleis.entite.Entity;

public abstract class Enemy extends Entity {

    public int hp;
    public int reward;

    public Enemy(int x, int y, BufferedImage image) {
        super(x, y, 30, 30, image);
    }

}