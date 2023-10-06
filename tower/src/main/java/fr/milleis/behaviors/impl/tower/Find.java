package fr.milleis.behaviors.impl.tower;

import java.util.ArrayList;

import fr.milleis.Main;
import fr.milleis.behaviors.Behavior;
import fr.milleis.behaviors.Behaviorable;
import fr.milleis.entite.Entity;
import fr.milleis.entite.building.Building;
import fr.milleis.entite.enemy.Enemy;

public class Find implements Behavior {

    public static Building building;

    @Override
    public void run(Behaviorable behaviorable) {

        building = (Building) behaviorable;

        // System.out.println("Let's go shoot them all!");

        var enemy = findNearEnemy((ArrayList<Entity>) Main.entities.clone(), building);
        
        building.target = enemy.getLocation();
        
        if (building.target != null) {
            // System.out.println("not null");
            behaviorable.setBehavior(new Shoot());
        } else {
            // System.out.println("I have no enemies.");
            behaviorable.setBehavior(new Find());
        }
    }

    public static Enemy findNearEnemy(ArrayList<Entity> enemies, Building building) {
        if (enemies == null || enemies.isEmpty()) {
            return null;
        }

        Enemy nearestEnemy = null;
        double minDistance = 15000;

        for (var enemy : enemies) {
            if (!(enemy instanceof Enemy))
                continue;

            double currentDistance = distance(enemy, building);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                nearestEnemy = (Enemy) enemy;
            }
        }

        return nearestEnemy;
    }

    private static double distance(Entity nearestEnemy, Building building) {

        int dx = building.x - nearestEnemy.x;
        int dy = building.y - nearestEnemy.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}