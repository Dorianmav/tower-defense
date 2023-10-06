package fr.milleis.entite.enemy;

import fr.milleis.behaviors.impl.enemy.GoToTargetBig;
import fr.milleis.factory.ImageFactory;

public class BigEnemy extends Enemy {

    public BigEnemy() {
        super(0, 0, ImageFactory.getImage(ImageFactory.IMAGE_BIG_ENEMY));
        this.hp = 10;
        this.reward = 20;
        this.behavior = new GoToTargetBig();

    }
}