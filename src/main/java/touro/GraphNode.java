package touro;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
    private String name;
    private List<GraphNode> connections;

    public GraphNode(String name){
        this.name = name;
        connections = new ArrayList<>();
    }

    public void addConnection(GraphNode node) {
        connections.add(node);
    }

    public void removeConnection(GraphNode node){
        connections.remove(node);
    }

    public List<GraphNode> getConnections() {
        return connections;
    }

    public GraphNode getNode(){
        return this;
    }


}
