package fr.milleis.behaviors.impl.tower;

import java.util.Timer;
import java.util.TimerTask;

import fr.milleis.Main;
import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;
import fr.milleis.entite.building.Building;
import fr.milleis.entite.projectile.Bullet;

public class Shoot implements Behavior {

    Bullet bullet;
    Building building;
    boolean launched = false;

    @Override
    public void run(Behaviorable behaviorable) {
        building = (Building) behaviorable;
        if (launched) {
            return;
        }

        launched = true;
        Timer timer = new Timer();
        TimerTask go = new TimerTask() {
            @Override
            public void run() {
                bullet = new Bullet(building.x, building.y, building.target);
                Main.entities.add(bullet);
                behaviorable.setBehavior(new Shoot());
            }
        };
        timer.schedule(go, building.cooldown);

    }

}