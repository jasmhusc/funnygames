package field;

import cell.Cell;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final long serialVersionUID = 1l;
    private static final int GRID_SIZE = 10;
    private Field field;

    public View(Field field) {
        this.field = field;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 把边框都设置出来
        g.setColor(Color.GRAY);
        for (int row = 0; row < field.getHeight(); row++) {
            g.drawLine(0, row * GRID_SIZE, field.getWidth() * GRID_SIZE, row * GRID_SIZE);
        }
        for (int col = 0; col < field.getWidth(); col++) {
            g.drawLine(col * GRID_SIZE, 0, col * GRID_SIZE, field.getHeight() * GRID_SIZE);
        }
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Cell cell = field.get(row, col);
                if (cell != null) {
                    cell.draw(g, row * GRID_SIZE, col * GRID_SIZE, GRID_SIZE);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(field.getWidth() * GRID_SIZE + 1, field.getHeight() * GRID_SIZE + 1);
    }
}
