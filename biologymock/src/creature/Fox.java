package creature;

import cell.Cell;
import field.Location;

import java.awt.*;
import java.util.ArrayList;

public class Fox extends Creature implements Cell {
    public Fox() {
        super(20, 4);
    }

    @Override
    public void draw(Graphics g, int row, int col, int size) {
        int alpha = (int) ((1 - getPerOfAge()) * 255);
        g.setColor(new Color(255, 0, 0, alpha));
        g.fillRect(row, col, size, size);
    }

    @Override
    public Location feed(ArrayList<Location> neighbour) {
        Location ret = null;
        if (neighbour.size() > 0 && Math.random() < 0.25) {
            ret = neighbour.get((int) (Math.random() * neighbour.size()));
            longerLife(2);
        }
        return ret;
    }

    @Override
    public Creature breed() {
        Creature ret = null;
        if (isBreedable() && Math.random() < 0.05) {
            ret = new Fox();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Fox:" + super.toString();
    }
}
