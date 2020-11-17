package touro;


import java.util.List;

public class GraphMain {


    public static void main(String[] args) {
        GraphInput creator = new GraphInput(args[0]);
        GraphSearch search = new GraphSearch();
        List<List<GraphNode>> netList = creator.getNetList();
        GraphController graphController = new GraphController(netList, search);
        GraphView view = new GraphView(search, creator);
        GraphFrame frame = new GraphFrame(view, netList);

        frame.setVisible(true);

    }



}
