package fr.milleis.entite.building;

import fr.milleis.behaviors.impl.tower.Find;
import fr.milleis.factory.ImageFactory;

public class BigTower extends Building {

    public BigTower(int x, int y) {
        super(x, y, ImageFactory.getImage(ImageFactory.IMAGE_BIG_TOWER));
        this.cost = 25;
        this.cooldown = 150;
        this.behavior = new Find();
    }

}