package fr.milleis.entite.enemy;

import fr.milleis.behaviors.impl.enemy.GoToTarget;
import fr.milleis.factory.ImageFactory;

public class BasicEnemy extends Enemy {

    public BasicEnemy() {
        super(0, 0, ImageFactory.getImage(ImageFactory.IMAGE_BASIC_ENEMY));

        this.hp = 3;
        this.reward = 5;
        this.behavior = new GoToTarget();

    }

}