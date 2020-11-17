package touro;

import java.util.HashMap;
import java.util.List;

public class getSPFs {
    List<List<GraphNode>> netList;
    GraphSearch graphSearch;
    GraphView view;
    int netNumber = 0;

    public getSPFs(List<List<GraphNode>> netList, GraphSearch graphSearch, GraphView view) {
        this.netList = netList;
        this.graphSearch = graphSearch;
        this.view = view;
        printAndPaint();
    }

    private void printAndPaint() {

        for (List<GraphNode> nodeList : netList) {
            netNumber++;
            System.out.println("Network #" + netNumber);
            HashMap<GraphNode, Integer> spf = graphSearch.getPointsOfFailure(nodeList);
            if (!spf.isEmpty()) {
                spf.forEach((key, value) -> {
                    System.out.format("SPF node %s leaves %d subnets%n", key.getName(), value);
                    view.paintSPF(key);
                });
            }
        }
    }
}
