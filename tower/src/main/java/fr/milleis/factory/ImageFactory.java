package fr.milleis.factory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageFactory {

    public final static String IMAGE_TOWER = "towerLow.png";
    public final static String IMAGE_BIG_TOWER = "towerMid.png";
    public final static String IMAGE_BASIC_ENEMY = "enemy.jpg";
    public final static String IMAGE_BIG_ENEMY = "bigEnemy.jpg";
    public final static String IMAGE_BULLET = "Just_A_Bullet.png";

    private ImageFactory() {
    };

    private static HashMap<String, BufferedImage> images = new HashMap<>();

    public static BufferedImage getImage(String name) {
        if (!images.containsKey(name))
            try {
                images.put(name, ImageIO.read(new File("src\\main\\resources\\assets\\" + name)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return images.get(name);
    }

}