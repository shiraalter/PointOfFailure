package touro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphView extends JComponent {

    private final Color NODE_COLOR = Color.DARK_GRAY;
    private final Color SINGLE_POINT_OF_FAILURE = Color.RED;
    private final Color NODE_TEXT_COLOR = Color.YELLOW;
    private final Color EDGE_COLOR = Color.BLACK;
    private static final int NODE_SIZE = 30;
    private static final int HEIGHT = 900;
    private static final int WIDTH = 900;
    private int x = -500;
    private int y = 0;
    private static final int X_CENTER = WIDTH / 2;
    private static final int Y_CENTER = HEIGHT / 2;
    private final GraphSearch graph;
    private final GraphInput nodeList;


    public GraphView(GraphSearch graph, GraphInput nodeList){
        this.graph = graph;
        this.nodeList = nodeList;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.translate(X_CENTER, Y_CENTER);
        paintGraph(g);
    }

    private void paintGraph(Graphics g){
        int index = 0;
        List<GraphNode> graphNodes = nodeList.getNetList().get(index);
        HashMap<GraphNode, Integer> spof = graph.getPointsOfFailure(graphNodes);
        HashMap<GraphNode, Integer> xNode = new HashMap<>();

        for(GraphNode graphNode : graphNodes){
            g.setColor(spof.containsKey(graphNode) ? SINGLE_POINT_OF_FAILURE : NODE_COLOR);
            x += 100;
            xNode.put(graphNode, x);
            g.fillOval(x, y, NODE_SIZE, NODE_SIZE);
            g.setColor(NODE_TEXT_COLOR);
            g.drawString(graphNode.getName(), x + 10, y +15);

            for(GraphNode connection : graphNode.getConnections()){
                if(xNode.containsKey(connection)){
                    int goalX = xNode.get(connection);
                    g.setColor(EDGE_COLOR);
                    g.drawArc(goalX + ((NODE_SIZE/2)), y - 15, x - goalX,100,0, -180);
                }
            }
        }
    }
}
