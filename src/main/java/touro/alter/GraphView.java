package touro.alter;

import org.graalvm.compiler.graph.Graph;

import javax.swing.*;
import java.awt.*;

public class GraphView extends JComponent {

    private final Color NODE_COLOR = Color.DARK_GRAY;
    private final Color SINGLE_POINT_OF_FAILURE = Color.RED;
    private final Color NODE_OUTLINE_COLOR = Color.BLACK;
    private final Color NODE_TEXT_COLOR = Color.WHITE;
    private final Graph graph;

    public GraphView(Graph graph){
        this.graph = graph;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintGraph(g);
    }

    private void paintGraph(Graphics g){

    }
}
