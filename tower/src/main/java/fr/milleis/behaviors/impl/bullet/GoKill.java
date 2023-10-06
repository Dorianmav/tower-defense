package fr.milleis.behaviors.impl.bullet;

import java.util.ArrayList;

import fr.milleis.Main;
import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;
import fr.milleis.entite.Entity;
import fr.milleis.entite.enemy.Enemy;
import fr.milleis.entite.projectile.Bullet;

public class GoKill implements Behavior {
    Bullet bullet;

    // receve the current location of the enemy when the tower find it
    @Override
    public void run(Behaviorable behaviorable) {
        bullet = (Bullet) behaviorable;

        if (bullet.x > bullet.getTarget().x) {
            bullet.x -= 10;
        } else if (bullet.x < bullet.getTarget().y) {
            bullet.x += 10;
        }
        if (bullet.y > bullet.getTarget().x) {
            bullet.y -= 10;
        } else if (bullet.y < bullet.getTarget().y) {
            bullet.y += 10;
        }
        Main.entities.stream().filter(e -> e instanceof Enemy)
                .forEach((e) -> {
                    if (e.intersects(bullet)) {
                        behaviorable.setBehavior(new Kill());
                    }
                });

        if (bullet.contains(bullet.getTarget())) {

            ((ArrayList<Entity>) Main.entities.clone()).remove(bullet);

        }

        // Main.entities.stream().filter(e -> e instanceof Bullet)
        //         .forEach((e) -> {
        //             if (bullet.contains(bullet.getTarget())) {

        //                 ((ArrayList<Entity>) Main.entities.clone()).remove(e);

        //             }
        //         });

    }

}