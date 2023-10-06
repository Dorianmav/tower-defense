package fr.milleis.entite;

import java.util.ArrayList;
import java.util.List;

public class GridManager {

    public static final int NUM_ROWS = 25;
    public static final int NUM_COLS = 25;
    public static final int CELL_SIZE = 25;

    public static List<List<Boolean>> grid;

    public GridManager() {

    }

    public void initComponent() {
        // Initialize the grid
        grid = new ArrayList<>();
        for (int i = 0; i < NUM_ROWS; i++) {
            List<Boolean> row = new ArrayList<>();
            for (int j = 0; j < NUM_COLS; j++) {
                row.add(false); // Initialize all cells as empty (no tower)
            }
            grid.add(row);
        }
    }

}