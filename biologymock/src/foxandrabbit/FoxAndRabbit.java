package foxandrabbit;

import creature.*;
import cell.Cell;
import field.*;
import creature.Grass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FoxAndRabbit {

    public FoxAndRabbit() {
        Field theField = getField(50);
        View view = new View(theField);
        JFrame frame = getJFrame(view);
        start(theField, frame, 200);
    }

    public static void main(String[] args) {
        new FoxAndRabbit();
    }

    private void start(Field theField, JFrame frame, int num) {
        for (int i = 0; i < num; i++) {
            step(theField);
            frame.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Field getField(int size) {
        Field theField = new Field(size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double probability = Math.random();
                if (probability < 0.05) {
                    theField.place(i, j, new Fox());
                } else if (probability < 0.15) {
                    theField.place(i, j, new Rabbit());
                } else if (probability < 0.18) {
                    theField.place(i, j, new Grass());
                }
            }
        }
        return theField;
    }

    private JFrame getJFrame(View view) {
        JFrame frame = new JFrame();
        frame.setTitle("狐狸和兔子");
        frame.add(view, BorderLayout.SOUTH);

        JPanel title = new JPanel();
        title.setLayout(new FlowLayout());
        JButton prepare = new JButton("准 备");
        title.add(prepare);
        JButton begin = new JButton("开 始");
        title.add(begin);
        JButton close = new JButton("暂 停");
        title.add(close);
        frame.add(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\javafile\\timg.jpg"));
        frame.setVisible(true);
        return frame;
    }

    private void step(Field theField) {
        for (int row = 0; row < theField.getHeight(); row++) {
            for (int col = 0; col < theField.getWidth(); col++) {
                Cell cell = theField.get(row, col);
                if (cell != null) {
                    // 先grow()，再看是否活着
                    Creature creature = (Creature) cell;
                    creature.grow();
                    if (creature.isAlive()) {
                        // move
                        Location loc;
                        if (creature instanceof Fox) {
                            loc = creature.move(theField.getFreeNeibour(row, col, 3));
                        } else if (creature instanceof Rabbit) {
                            loc = creature.move(theField.getFreeNeibour(row, col, 2));
                        } else {
                            loc = null;
                        }
                        if (loc != null) {
                            theField.move(row, col, loc);
                        }
                        // breed
                        Creature breed = creature.breed();
                        if (breed != null) {
                            if (creature instanceof Fox) {
                                theField.placeRandomAdj(row, col, 3, (Cell) breed);
                            } else if (creature instanceof Rabbit) {
                                theField.placeRandomAdj(row, col, 1, (Cell) breed);
                            } else {
                                theField.placeRandomAdj(row, col, 2, (Cell) breed);
                            }
                        }
                        /* eat
                         获取周围邻居，拿走兔子，不为空就可以随机吃一个，在Field中移除被吃掉的兔子(需要携带位置信息)*/
                        if (creature instanceof Fox) {
                            eat(theField, row, col, new Rabbit());
                        } else if (creature instanceof Rabbit) {
                            eat(theField, row, col, new Grass());
                        } else {
                            //eat(theField, row, col, creature); 草不吃食物
                        }
                    } else {
                        // 死了就移除
                        theField.remove(row, col);
                    }
                } else {
                    // 为空以比较小的机率长出青草
                    if (Math.random() < 0.001)
                        theField.place(row, col, new Grass());
                }
            }
        }
    }

    private void eat(Field theField, int row, int col, Creature creature) {
        // 传入的是要吃食物的生物位置信息，以及被吃的是什么生物。
        ArrayList<Location> listCretLoc = new ArrayList<Location>();
        ArrayList<Creature> listCret = new ArrayList<>();
        Location[] cretNeibour = theField.getCretNeibour(row, col, 1, new Rabbit());
        for (Location cretloc : cretNeibour) {
            Creature cretFeded = (Creature) theField.get(cretloc);
            if (cretFeded != null) {
                listCretLoc.add(cretloc);
                listCret.add(cretFeded);
            }
        }
        if (listCret.size() > 0) {
            // 需要向feed函数传一个Animal集合
            Location fedLoc = creature.feed(listCretLoc);
            if (fedLoc != null) {
                theField.remove(fedLoc);
            }
        }
    }
}
