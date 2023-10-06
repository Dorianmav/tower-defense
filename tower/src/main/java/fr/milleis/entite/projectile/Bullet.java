package fr.milleis.entite.projectile;

import java.awt.Point;

import fr.milleis.behaviors.impl.bullet.GoKill;
import fr.milleis.entite.Entity;
import fr.milleis.factory.ImageFactory;

public class Bullet extends Entity {

    private Point target;

    public Bullet(int x, int y, Point target) {
        super(x, y, 3, 10, ImageFactory.getImage(ImageFactory.IMAGE_BULLET));
        this.target = target;
        this.behavior = new GoKill();
    }

    /**
     * @return Point return the target
     */
    public Point getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Point target) {
        this.target = target;
    }

}