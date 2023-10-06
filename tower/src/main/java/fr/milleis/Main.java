package fr.milleis;

import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;

import fr.milleis.entite.Entity;
import fr.milleis.entite.GridManager;
import fr.milleis.entite.enemy.BasicEnemy;
import fr.milleis.entite.enemy.BigEnemy;
import fr.milleis.listener.KeybordListener;
import fr.milleis.listener.CustomMouseListener;
import fr.milleis.ui.MyCanvas;

public class Main {

    public static JFrame jFrame;
    public static MyCanvas myCanvas;

    public static ArrayList<Entity> entities = new ArrayList<>();

    public static int coin;

    public static Rectangle[] grid;

    public static void main(String[] args) {
        jFrame = new JFrame("Tower defense");
        myCanvas = new MyCanvas();

        coin = 25;

        CustomMouseListener listener = new CustomMouseListener();

        jFrame.setSize(600, 600);

        new GridManager().initComponent();
        jFrame.setContentPane(myCanvas);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addKeyListener(new KeybordListener(jFrame));
        jFrame.addMouseListener(listener);
        jFrame.addMouseMotionListener(listener);
        jFrame.setFocusable(true);

        BasicEnemy dorian = new BasicEnemy();
        BigEnemy arthur = new BigEnemy();

        entities.add(dorian);
        entities.add(arthur);

        new Thread(() -> {
            while (true) {

                for (var entite : ((ArrayList<Entity>) entities.clone())) {
                    entite.getBehavior().run(entite);
                }
                try {
                    Thread.sleep(30);
                    myCanvas.repaint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }

}