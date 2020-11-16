package touro.alter;

import javax.swing.*;

public class GraphFrame extends JFrame {

    private GraphView view;

    public GraphFrame(GraphView view){
        this.view = view;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Single Point of Failure");
        setSize(900,900);
        add(view);
        view.repaint();

    }
}
