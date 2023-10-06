package fr.milleis.listener;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import fr.milleis.Main;
import fr.milleis.entite.building.BigTower;
import fr.milleis.entite.building.Tower;

public class KeybordListener extends KeyAdapter {
    private JFrame jFrame;
    public static Point pointMouse;

    public KeybordListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                if (Main.coin >= 5) {
                    Main.entities.add(new Tower(pointMouse.x - 25, pointMouse.y - 50));
                    Main.coin -= 5;
                }
                break;
            case KeyEvent.VK_E:
                if (Main.coin >= 25) {
                    Main.entities.add(new BigTower(pointMouse.x - 25, pointMouse.y - 50));
                    Main.coin -= 25;
                }
                break;
            default:
                break;
        }
    }
}