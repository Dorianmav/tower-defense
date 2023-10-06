package fr.milleis.behaviors.impl.enemy;

import fr.milleis.Main;
import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;
import fr.milleis.entite.enemy.BasicEnemy;

public class GoToTarget implements Behavior {

    BasicEnemy enemy;

    @Override
    public void run(Behaviorable behaviorable) {
        enemy = (BasicEnemy) behaviorable;

        if ((enemy.x != Main.jFrame.getWidth()) && (enemy.y != Main.jFrame.getHeight())) {
            enemy.x += 2;
            enemy.y += 2;
        }
    }

}