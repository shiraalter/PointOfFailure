package touro;

import java.util.HashMap;
import java.util.List;

public class GraphController {
    List<List<GraphNode>> netList;
    GraphSearch graphSearch;
    int netNumber = 0;

    public GraphController(List<List<GraphNode>> netList, GraphSearch graphSearch) {
        this.netList = netList;
        this.graphSearch = graphSearch;
        getSPFs();
    }

    private void getSPFs() {

        for (List<GraphNode> nodeList : netList) {
            netNumber++;
            System.out.println("Network #" + netNumber);
            HashMap<GraphNode, Integer> spf = graphSearch.getPointsOfFailure(nodeList);
            if (!spf.isEmpty()) {
                spf.forEach((key, value) -> {
                    System.out.format("\tSPF node %s leaves %d subnets%n", key.getName(), value);
                });
            }
            else {
                System.out.println("\tNo SPF nodes");
            }
        }
    }
}
