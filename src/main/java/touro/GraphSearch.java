package touro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphSearch {
    private List<GraphNode> nodes = new ArrayList<>();
    private List<GraphNode> tempNodes = new ArrayList<>();
    private List<GraphNode> checkedNodes = new ArrayList<>();
    private HashMap<GraphNode, Integer> pointsOfFailure = new HashMap<>();
    private GraphNode potentialSPF;
    private int numSubnets;

    public HashMap<GraphNode, Integer> getPointsOfFailure(List<GraphNode> nodesList) {
        pointsOfFailure.clear();
        deepCopyNodes(nodesList);
        for (GraphNode node : nodes) {
            potentialSPF = node;
            numSubnets = 0;
            removeNode(potentialSPF);
            findSPF(potentialSPF);
            if (numSubnets != 0) {
                pointsOfFailure.put(potentialSPF, numSubnets);
            }
        }
        return pointsOfFailure;
    }

    private void deepCopyNodes(List<GraphNode> nodesList) {
        nodes.clear();
        for (GraphNode node : nodesList) {
            nodes.add(new GraphNode(node));
        }
    }

    //remove node by copying the list into a different array, without that one node
    private void removeNode(GraphNode nodeToRemove) {
        tempNodes.clear();
        for (GraphNode node : nodes) {
            if (!node.equals(nodeToRemove)) {
                tempNodes.add(new GraphNode(node));
            }
        }
    }

    //search for the SPF starting with the first node
    private void findSPF(GraphNode node) {
        checkedNodes.clear();

        GraphNode startingNode = tempNodes.get(0);
        search(startingNode, node);

        //if the two are not equal in size, some nodes could not be reached - there is an SPF
        if (checkedNodes.size() != tempNodes.size()) {
            numSubnets++;
            for (GraphNode connectedNode : checkedNodes) {
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
        checkedNodes.add(startingNode);
        for (GraphNode child : startingNode.getConnections()) {
            if (!child.equals(nodeRemoved) && !checkedNodes.contains(child)) {
                search(child, nodeRemoved);
            }
        }
    }
}
