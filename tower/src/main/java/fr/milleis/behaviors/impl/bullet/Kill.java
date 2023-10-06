package fr.milleis.behaviors.impl.bullet;

import java.util.ArrayList;

import fr.milleis.Main;
import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;
import fr.milleis.entite.Entity;
import fr.milleis.entite.enemy.Enemy;
import fr.milleis.entite.projectile.Bullet;

public class Kill implements Behavior {

    Bullet bullet;

    @Override
    public void run(Behaviorable behaviorable) {
        bullet = (Bullet) behaviorable;

        for (var e : (ArrayList<Entity>) Main.entities.clone()) {
            if (!(e instanceof Enemy))
                continue;
            var enemy = (Enemy) e;
            enemy.hp--;
            Main.entities.remove(bullet);
            if (enemy.hp <= 0) {
                Main.entities.remove(enemy);
                Main.coin += enemy.reward;
            }
        }

    }
}