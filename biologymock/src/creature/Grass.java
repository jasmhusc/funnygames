package creature;

import cell.Cell;

import java.awt.*;

public class Grass extends Creature implements Cell {
    public Grass() {
        super(5, 1);
    }

    @Override
    public void draw(Graphics g, int row, int col, int size) {
        int alpha = (int) ((1 - getPerOfAge()) * 255);
        g.setColor(new Color(0, 255, 0, alpha));
        g.fill3DRect(row, col, size, size, true);
    }

    @Override
    public Creature breed() {
        Creature ret = null;
        if (isBreedable() && Math.random() < 0.2) {
            ret = new Grass();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Grass:" + super.toString();
    }
}
