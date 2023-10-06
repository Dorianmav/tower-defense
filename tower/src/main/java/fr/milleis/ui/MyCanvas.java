package fr.milleis.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import fr.milleis.Main;
import fr.milleis.entite.Entity;
import fr.milleis.entite.GridManager;
import fr.milleis.entite.enemy.Enemy;
import fr.milleis.factory.ImageFactory;

public class MyCanvas extends JPanel {

    ArrayList<Enemy> listEnemy = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.drawString("Money: " + Main.coin + " G", this.getWidth() - 100, 20);
        g.drawString("Tower: ", this.getWidth() - 100, 40);

        for (var entity : (ArrayList<Entity>) Main.entities.clone()) {
            entity.paint(g);
        }

        g.drawImage(ImageFactory.getImage(ImageFactory.IMAGE_TOWER), this.getWidth() - 80, 45,   25, 25,null);
        g.drawString("A: 5G", this.getWidth() - 85, 85);

        g.drawImage(ImageFactory.getImage(ImageFactory.IMAGE_BIG_TOWER), this.getWidth() - 40, 45,  25, 25, null);
        g.drawString("E: 25G", this.getWidth() - 45, 85);

        // if (listEnemy.isEmpty()) {
        //     g.setColor(Color.WHITE);
        //     g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        //     g.setColor(Color.BLACK);
        //     g.setFont(new Font("Serif", Font.BOLD, 50));
        //     g.drawString("Fin de la partie", (this.getWidth() / 2) - 175, (this.getHeight() / 2));
        // }

        // Draw the grid based on the data in the 'grid' list
        for (int row = 0; row < GridManager.NUM_ROWS; row++) {
            for (int col = 0; col < GridManager.NUM_COLS; col++) {
                if (GridManager.grid.get(row).get(col)) {
                    // Draw a tower in the cell
                    g.setColor(Color.RED);
                    g.fillRect(col * GridManager.CELL_SIZE, row * GridManager.CELL_SIZE, GridManager.CELL_SIZE, GridManager.CELL_SIZE);
                } else {
                    // Draw an empty cell
                    g.setColor(Color.GRAY);
                    g.drawRect(col * GridManager.CELL_SIZE, row * GridManager.CELL_SIZE, GridManager.CELL_SIZE, GridManager.CELL_SIZE);
                }
            }
        }

    }

}