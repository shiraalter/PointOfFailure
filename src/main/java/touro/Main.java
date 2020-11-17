package touro;


public class Main {


    public static void main(String[] args) {
        GraphInput creator = new GraphInput(args[0]);
        GraphSearch search = new GraphSearch();
        GraphView view = new GraphView(search, creator);
        GraphFrame frame = new GraphFrame(view);

        frame.setVisible(true);

    }



}
