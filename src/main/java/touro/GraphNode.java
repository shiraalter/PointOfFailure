package touro;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
    private String name;
    private List<GraphNode> connections;

    public GraphNode(String name) {
        this.name = name;
        connections = new ArrayList<>();
    }

    public GraphNode(GraphNode node) {
        this.name = node.name;
        this.connections = new ArrayList<>();
        for (GraphNode connection : node.getConnections()) {
            this.addConnection(connection);
        }
    }

    public String getName() {
        return name;
    }

    public void addConnection(GraphNode node) {
        connections.add(node);
    }

    public void removeConnection(GraphNode node) {
        connections.remove(node);
    }

    public List<GraphNode> getConnections() {
        return connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(name, graphNode.name);
    }
}
