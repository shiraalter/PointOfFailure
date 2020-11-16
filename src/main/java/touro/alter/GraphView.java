package touro.alter;

import org.graalvm.compiler.graph.Graph;

import javax.swing.*;
import java.awt.*;

public class GraphView extends JComponent {

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
