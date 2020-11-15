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
        //read text from file
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
           List<String> vertices = Arrays.asList(input.split(" "));

           GraphNode firstNode = new GraphNode(vertices.get(0));
           GraphNode secondNode = new GraphNode(vertices.get(1));

           if(!nodeList.contains(firstNode)){
               nodeList.add(firstNode);
           }

           if(!nodeList.contains(secondNode)){
               nodeList.add(secondNode);
           }

           firstNode.addConnection(secondNode);
           secondNode.addConnection(firstNode);

        }
    }

    

}
