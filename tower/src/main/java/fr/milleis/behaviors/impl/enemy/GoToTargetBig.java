package fr.milleis.behaviors.impl.enemy;

import fr.milleis.Main;
import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;
import fr.milleis.entite.enemy.BigEnemy;

public class GoToTargetBig implements Behavior {

    BigEnemy bigEnemy;

    @Override
    public void run(Behaviorable behaviorable) {
        bigEnemy = (BigEnemy) behaviorable;

        if ((bigEnemy.x != Main.jFrame.getWidth()) && (bigEnemy.y != Main.jFrame.getHeight())) {
            bigEnemy.x += 1;
            bigEnemy.y += 1;
        }
    }

}