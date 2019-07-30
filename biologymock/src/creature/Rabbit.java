package creature;

import cell.Cell;
import field.Location;

import java.awt.*;
import java.util.ArrayList;

public class Rabbit extends Creature implements Cell {
    public Rabbit() {
        super(19, 2);
    }

    @Override
    public void draw(Graphics g, int row, int col, int size) {
        int alpha = (int) ((1 - getPerOfAge()) * 255);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(row, col, size, size);
    }

    @Override
    public Creature breed() {
        Creature ret = null;
        if (isBreedable() && Math.random() < 0.10) {
            ret = new Rabbit();
        }
        return ret;
    }

    @Override
    public Location feed(ArrayList<Location> neighbour) {
        Location ret = null;
        if (neighbour.size() > 0 && Math.random() < 0.15) {
            ret = neighbour.get((int) (Math.random() * neighbour.size()));
            longerLife(0.5);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Rabbit:" + super.toString();
    }
}
