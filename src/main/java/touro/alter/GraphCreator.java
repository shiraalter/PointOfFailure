package touro.alter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * reads input from text file and creates connections between nodes to make "graph"
 */
public class GraphCreator {

   private List<GraphNode> nodeList = new ArrayList<>();

    public GraphCreator(String file){
        try {
            Scanner inputFile = new Scanner(new File(file));
            while(inputFile.hasNextLine()) {
                String input = inputFile.nextLine();

                connectNodes(input);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void connectNodes(String input) {
        if (!input.contentEquals("0")) {
           String vertices[] = input.split(" ");

           GraphNode firstNode = new GraphNode(vertices[0]);
           GraphNode secondNode = new GraphNode(vertices[1]);

           //check that list doesn't already contain node
           if(!containsName(nodeList, firstNode.getName())){
               nodeList.add(firstNode);
           }

          if(!containsName(nodeList,secondNode.getName())){
               nodeList.add(secondNode);
           }

          //BUG: not adding connection to old node already in list because created new nodes in beginning of method
           firstNode.addConnection(secondNode);
           secondNode.addConnection(firstNode);
        }

    }

    public boolean containsName(List<GraphNode> list, String name){
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }
}
