package life;

import java.util.Random;

public class Universe {

    private final Cell[][] cells;
    private final Cell[][] oldCells;

    public Universe(int size) {

        Random random = new Random();

        cells = new Cell[size][size];
        oldCells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                getCells()[i][j] = new Cell(i, j, random.nextBoolean());
                oldCells[i][j] = new Cell(i, j, getCells()[i][j].isAlive());
            }
        }

    }

    private Cell[] findNeighbours(Cell cell) {

        Cell[] neighbours = new Cell[8];
        int cellX = cell.getPositionX();
        int cellY = cell.getPositionY();

        int leftIndex = cellY == 0 ? getCells().length - 1 : cellY - 1;
        int rightIndex = cellY == getCells().length - 1 ? 0 : cellY + 1;

        int upIndex = cellX == 0 ? getCells().length - 1 : cellX - 1;
        int downIndex = cellX == getCells().length - 1 ? 0 : cellX + 1;

        neighbours[0] = oldCells[upIndex][leftIndex];
        neighbours[1] = oldCells[upIndex][cellY];
        neighbours[2] = oldCells[upIndex][rightIndex];
        neighbours[3] = oldCells[cellX][leftIndex];
        neighbours[4] = oldCells[cellX][rightIndex];
        neighbours[5] = oldCells[downIndex][leftIndex];
        neighbours[6] = oldCells[downIndex][cellY];
        neighbours[7] = oldCells[downIndex][rightIndex];

        return neighbours;

    }

    public void nextGeneration() {

        for (Cell[] line : oldCells) {
            for (Cell cell : line) {

                Cell[] neighbours = findNeighbours(cell);
                int aliveNeighbours = countAliveNeighbours(neighbours);

                if (cell.isAlive() && aliveNeighbours != 2 && aliveNeighbours != 3) {
                    getCells()[cell.getPositionX()][cell.getPositionY()].setAlive(false);
                } else if (!cell.isAlive() && aliveNeighbours == 3) {
                    getCells()[cell.getPositionX()][cell.getPositionY()].setAlive(true);
                }

            }
        }

        for (int i = 0; i < oldCells.length; i++) {
            for (int j = 0; j < oldCells.length; j++) {
                oldCells[i][j] = new Cell(i, j, getCells()[i][j].isAlive());
            }
        }

    }

    private int countAliveNeighbours(Cell[] neighbours) {
        int count = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.isAlive()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Cell[] line : getCells()) {
            for (Cell cell : line) {
                result.append(cell.isAlive() ? "O" : " ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public int countAlive() {
        int count = 0;
        for (Cell[] line : getCells()) {
            for (Cell cell : line) {
                if (cell.isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Cell[][] getCells() {
        return cells;
    }

}
