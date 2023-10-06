package fr.milleis.entite.building;

import fr.milleis.behaviors.impl.tower.Find;
import fr.milleis.factory.ImageFactory;

public class Tower extends Building {

    public Tower(int x, int y) {
        super(x, y, ImageFactory.getImage(ImageFactory.IMAGE_TOWER));
        this.cost = 5;
        this.cooldown = 300;
        this.behavior = new Find();
    }

}