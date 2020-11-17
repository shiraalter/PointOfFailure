package touro;


import java.util.List;

public class Main {


    public static void main(String[] args) {
        GraphInput creator = new GraphInput(args[0]);
        GraphSearch search = new GraphSearch();
        List<List<GraphNode>> netList = creator.getNetList();
        GraphView view = new GraphView(search, creator);
        GraphFrame frame = new GraphFrame(view);

        frame.setVisible(true);
        GraphController graphController = new GraphController(netList, search);

    }



}
