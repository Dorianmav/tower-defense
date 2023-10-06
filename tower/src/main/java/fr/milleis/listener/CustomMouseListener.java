package fr.milleis.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.milleis.entite.GridManager;

public class CustomMouseListener extends MouseAdapter {

    public CustomMouseListener() {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        KeybordListener.pointMouse = e.getPoint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int clickedRow = e.getY() / GridManager.CELL_SIZE;
        int clickedCol = e.getX() / GridManager.CELL_SIZE;

        // Place a tower in the clicked cell (toggle between empty and tower)
        GridManager.grid.get(clickedRow).set(clickedCol, !GridManager.grid.get(clickedRow).get(clickedCol));

        
        //repaint(); // Repaint the panel to reflect the changes
    }

}