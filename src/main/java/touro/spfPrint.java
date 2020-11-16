package touro;

import java.util.HashMap;
import java.util.List;

public class spfPrint {
    List<List<GraphNode>> netList;
    GraphSearch graphSearch;

    public spfPrint(List<List<GraphNode>> netList, GraphSearch graphSearch) {
        this.netList = netList;
        this.graphSearch = graphSearch;
        getSPFs();
    }

    private void getSPFs() {

        for (List<GraphNode> nodeList : netList) {
            HashMap<GraphNode, Integer> spf = graphSearch.getPointsOfFailure(nodeList);
            spf.forEach((k, v) -> {
                System.out.format("key: %s, value: %d%n", k.getName(), v);
            });
        }
    }
}
