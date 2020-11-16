package touro.alter;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphSearch {
    private final ArrayList<GraphNode> nodes;
    private ArrayList<GraphNode> tempNodes = new ArrayList<>();
    private ArrayList<GraphNode> remainingConnections = new ArrayList<>();
    private HashMap<GraphNode, Integer> pointsOfFailure = new HashMap<>();
    private GraphNode potentialSPF;
    private int numSubnets;

    public GraphSearch(ArrayList<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public HashMap<GraphNode, Integer> getPointsOfFailure() {
        for (GraphNode node : nodes) {
            potentialSPF = node;
            numSubnets = 0;
            removeNode(node);
            findSPF(node);
            if (numSubnets != 0) {
                pointsOfFailure.put(potentialSPF, numSubnets);
            }
        }
        return pointsOfFailure;
    }

    private void removeNode(GraphNode nodeToRemove) {
        tempNodes.clear();
        for (GraphNode node : nodes) {
            if (!node.equals(nodeToRemove)) {
                GraphNode copiedNode = new GraphNode(node);
                tempNodes.add(copiedNode);
            }
        }
    }

    private void findSPF(GraphNode node) {
        remainingConnections.clear();

        GraphNode startingNode = tempNodes.get(0);
        search(startingNode, node);

        if (remainingConnections.size() != tempNodes.size()) {
            numSubnets++;
            for (GraphNode connectedNode : remainingConnections) {
                tempNodes.remove(connectedNode);
            }
            findSPF(node);
        }

        else if (tempNodes.size() != nodes.size() - 1){
            numSubnets++;
        }

    }

    private void search(GraphNode startingNode, GraphNode nodeRemoved) {
//        TODO: this prbly has a bug because it doesnt check nodes past the first connection it finds
        remainingConnections.add(startingNode);
        int index = 0;
        for (GraphNode child : startingNode.getConnections()) {
            index++;
            if (!child.equals(nodeRemoved) && !remainingConnections.contains(child)) {
                search(child, nodeRemoved);
            }
        }
        if (index == startingNode.getConnections().size()) {
        }
    }
}
