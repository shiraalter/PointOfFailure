package touro;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphSearch {
    private ArrayList<GraphNode> nodes = new ArrayList<>();
    private ArrayList<GraphNode> tempNodes = new ArrayList<>();
    private ArrayList<GraphNode> remainingConnections = new ArrayList<>();
    private HashMap<GraphNode, Integer> pointsOfFailure = new HashMap<>();
    private GraphNode potentialSPF;
    private int numSubnets;

    public HashMap<GraphNode, Integer> getPointsOfFailure(ArrayList<GraphNode> nodesList) {
        nodes.clear();
        nodes = nodesList;
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

    //remove node by copying the list into a different array, without that one node
    private void removeNode(GraphNode nodeToRemove) {
        tempNodes.clear();
        for (GraphNode node : nodes) {
            if (!node.equals(nodeToRemove)) {
                GraphNode copiedNode = new GraphNode(node);
                tempNodes.add(copiedNode);
            }
        }
    }

    //search for the SPF starting with the first node
    private void findSPF(GraphNode node) {
        remainingConnections.clear();

        GraphNode startingNode = tempNodes.get(0);
        search(startingNode, node);

        //if the two are not equal in size, some nodes could not be reached - there is an SPF
        if (remainingConnections.size() != tempNodes.size()) {
            numSubnets++;
            for (GraphNode connectedNode : remainingConnections) {
                tempNodes.remove(connectedNode);
            }
            //now use the remaining nodes in temp nodes to find how many more subnets there are
            findSPF(node);
        }

        //at the last subnet, remainingConnections and tempNodes will be the same size.
        //it is a subnet then, if tempNodes is not the same size as nodes, without the one we removed
        else if (tempNodes.size() != nodes.size() - 1){
            numSubnets++;
        }

    }

    //recursive search to find the SPF, if any
    private void search(GraphNode startingNode, GraphNode nodeRemoved) {
        remainingConnections.add(startingNode);
        for (GraphNode child : startingNode.getConnections()) {
            if (!child.equals(nodeRemoved) && !remainingConnections.contains(child)) {
                search(child, nodeRemoved);
            }
        }
    }
}
