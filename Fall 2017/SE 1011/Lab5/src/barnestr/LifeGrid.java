package barnestr;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the grid of cells used to model Conway's Game of Life.
 *
 * @author Derek Riley
 * @version 2018AY
 */
public class LifeGrid {

    private static final double ALIVE_CHANCE = 0.5;

    /**
     * This instance variable stores the grid of Cells
     */
    private List<List<Cell>> cells;

    public int aliveCells = 0;
    public int deadCells = 0;

    /**
     * This constructor builds a LifeGrid using the size of the Pane passed and the scale of the cells
     *
     * @param gamePane viewing pane
     */
    public LifeGrid(Pane gamePane) {
        final int numberOfCellsWide = (int) gamePane.getPrefWidth() / Cell.SCALE;
        final int numberOfCellsHigh = (int) gamePane.getPrefHeight() / Cell.SCALE;
        cells = new ArrayList<>();

        //initialize the two dimensional ArrayList
        for (int i = 0; i < numberOfCellsHigh; i++) {
            cells.add(new ArrayList<>());
        }

        //create cells
        for (int i = 0; i < numberOfCellsHigh; i++) {     // yPosition
            for (int j = 0; j < numberOfCellsWide; j++) { // xPosition
                cells.get(i).add(new Cell(j, i));
            }
        }

        //set neighbors for all cells
        for (int i = 0; i < numberOfCellsHigh; i++) {     // yPosition
            for (int j = 0; j < numberOfCellsWide; j++) { // xPosition
                if (i > 0) {
                    if (j > 0) {
                        cells.get(i).get(j).setNeighborAboveLeft(cells.get(i - 1).get(j - 1));
                    }
                    cells.get(i).get(j).setNeighborAboveCenter(cells.get(i - 1).get(j));
                    if (j < numberOfCellsWide - 1) {
                        cells.get(i).get(j).setNeighborAboveRight(cells.get(i - 1).get(j + 1));
                    }
                }
                if (j > 0) {
                    cells.get(i).get(j).setNeighborMiddleLeft(cells.get(i).get(j - 1));
                }
                if (j < numberOfCellsWide - 1) {
                    cells.get(i).get(j).setNeighborMiddleRight(cells.get(i).get(j + 1));
                }
                if (i < numberOfCellsHigh - 1) { // bottom boarder elements
                    if (j > 0) {
                        cells.get(i).get(j).setNeighborBelowLeft(cells.get(i + 1).get(j - 1));
                    }
                    cells.get(i).get(j).setNeighborBelowCenter(cells.get(i + 1).get(j));
                    if (j < numberOfCellsWide - 1) {
                        cells.get(i).get(j).setNeighborBelowRight(cells.get(i + 1).get(j + 1));
                    }
                }
            }
        }
        initialize(gamePane);
    }

    /**
     * This method randomizes the life and death attributes of all cells in the cells.
     * Cells have a 50% chance of being alive or dead.
     */
    public void randomize() {
        aliveCells = 0;
        deadCells = 0;
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.setAlive(Math.random() < ALIVE_CHANCE);
                cell.updateColors();
                if (cell.isAlive()) {
                    aliveCells++;
                } else {
                    deadCells++;
                }
            }
        }
    }

    /**
     * This method triggers one iteration (tick) of the game of life rules for the entire grid.
     */
    public void iterate() {
        aliveCells = 0;
        deadCells = 0;
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.determineNextTick();
                if (cell.isAlive()) {
                    aliveCells++;
                } else {
                    deadCells++;
                }
            }
        }
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.updateTick();
            }
        }
    }

    /**
     * This method adds all the cell rectangles to the Pane
     */
    private void initialize(Pane gamePane) {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                gamePane.getChildren().add(cell);
            }
        }
    }

    /**
     * This method takes the location of a mouse click and sets the state of that cell to dead or alive.
     * @param location
     */
    public void setState(MouseEvent location) {
        boolean loop = true;
        for (int i=0; i<cells.get(0).size()*10 && loop; i+=10) {
            if (location.getX() < i+10) {
               for (int j=0; j<cells.size()*10 && loop; j+=10) {
                    if (location.getY() < j+10) {
                        if (cells.get(j/10).get(i/10).isAlive()) {
                            cells.get(j/10).get(i/10).setAlive(false);
                            cells.get(j/10).get(i/10).updateColors();
                            deadCells++;
                            aliveCells--;
                            loop = false;
                        } else {
                            cells.get(j/10).get(i/10).setAlive(true);
                            cells.get(j/10).get(i/10).updateColors();
                            aliveCells++;
                            if (deadCells > 0) {
                                deadCells--;
                            }
                            loop = false;
                        }
                    }
               }
            }
        }
    }
}
