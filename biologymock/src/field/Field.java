package field;

import cell.Cell;
import creature.Creature;

import java.util.ArrayList;

public class Field {
    private int width;
    private int height;
    private Cell[][] field;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Cell[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell get(int row, int col) {
        return field[row][col];
    }

    public Cell get(Location l) {
        return field[l.getRow()][l.getCol()];
    }

    public Cell place(int r, int c, Cell cell) {
        Cell temp = field[r][c];
        field[r][c] = cell;
        return temp;
    }

    public Cell remove(int r, int c) {
        Cell rem = field[r][c];
        field[r][c] = null;
        return rem;
    }

    public void remove(Location loc) {
        remove(loc.getRow(), loc.getCol());
    }

    public void move(int row, int col, Location loc) {
        field[loc.getRow()][loc.getCol()] = field[row][col];
        remove(row, col);
    }

    public void clear() {
        for (Cell[] c : field) {
            c = null;
        }
    }

    public Cell[] getNeibour(int row, int col, int rd) {
        ArrayList<Cell> list = new ArrayList<>();
        for (int i = -rd; i <= rd; i++) {
            for (int j = -rd; j <= rd; j++) {
                int r = row + i;
                int c = col + j;
                if (r > 0 && r < height && c > 0 && c < width && !(r == 0 && c == 0))
                    list.add(field[r][c]);
            }
        }
        return list.toArray(new Cell[list.size()]);
    }

    public Location[] getFreeNeibour(int row, int col, int rd) {
        ArrayList<Location> list = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = row + i;
                int c = col + j;
                if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) {
                    Cell cell = field[r][c];
                    if (cell == null)
                        list.add(new Location(r, c));
                }
            }
        }
        return list.toArray(new Location[list.size()]);
    }

    public Location[] getCretNeibour(int row, int col, int rd, Creature cret) {
        ArrayList<Location> list = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = row + i;
                int c = col + j;
                if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) {
                    Cell cell = field[r][c];
//                    if (cell instanceof Rabbit)
                    if ((cell != null) && cell.getClass().isInstance(cret))
                        list.add(new Location(r, c));
                }
            }
        }
        return list.toArray(new Location[list.size()]);
    }

    public boolean placeRandomAdj(int r, int c, int rd, Cell cell) {
        boolean ret = false;
        Location[] freeAdj = getFreeNeibour(r, c, rd);
        int len = freeAdj.length;
        if (len > 0) {
            int i = (int) (Math.random() * len);
            Location locr = freeAdj[i];
            field[locr.getRow()][locr.getCol()] = cell;
            ret = true;
        }
        return ret;
    }
}
