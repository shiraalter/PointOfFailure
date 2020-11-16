package touro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * reads input from text file and creates connections between nodes to make "graph"
 */
public class GraphInput {

    private List<GraphNode> nodeList = new ArrayList<>();
    private List<List<GraphNode>> netList = new ArrayList<>();

    public GraphInput(String file) {
        try {
            Scanner inputFile = new Scanner(new File(file));
            while (inputFile.hasNextLine()) {
                String input = inputFile.nextLine();

                //if end of file, add entire list of nodes to netList
                if (!input.contentEquals("")) {
                    if (!input.contentEquals("0")) {
                        connectNodes(input);
                    } else {
                        netList.add(new ArrayList<>(nodeList)); //deep copy of nodeList so netList is unaffected by clear()
                    }
                } else {
                    nodeList.clear();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param input - gets two nodes at a time and checks if they exist in nodeList. If not, add them to list and create connections.
     *              If they do exist, assign new GraphNode object to the existing node in the list and create connections between the existing nodes.
     */
    private void connectNodes(String input) {
        String[] vertices = input.split(" ");

        GraphNode node1 = new GraphNode(vertices[0]);
        GraphNode node2 = new GraphNode(vertices[1]);

        if (nodeList.contains(node1)) {
            int index = nodeList.indexOf(node1);
            GraphNode existingNode1 = nodeList.get(index);   //find the node that exists in list

            if (nodeList.contains(node2)) {
                int index2 = nodeList.indexOf(node2);
                GraphNode existingNode2 = nodeList.get(index2);

                //both nodes already exist in list, connect them
                existingNode1.addConnection(existingNode2);
                existingNode2.addConnection(existingNode1);
            } else {
                nodeList.add(node2);
                existingNode1.addConnection(node2);
                node2.addConnection(existingNode1);
            }

        }
        else {
            nodeList.add(node1);
            if (nodeList.contains(node2)) {
                int index2 = nodeList.indexOf(node2);
                GraphNode existingNode2 = nodeList.get(index2);
                node1.addConnection(existingNode2);
                existingNode2.addConnection(node1);
            } else {
                nodeList.add(node2);
                node1.addConnection(node2);
                node2.addConnection(node1);
            }
        }
    }

    private List<List<GraphNode>> getNetList() {
        return netList;
    }
}
