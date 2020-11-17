package touro;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphFrame extends JFrame {

    private GraphView view;
    List<List<GraphNode>> netList;

    public GraphFrame(GraphView view, List<List<GraphNode>> netList){
        this.view = view;
        this.netList = netList;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Single Point of Failure");
        setSize(900,900);
        setLayout(new BorderLayout());

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Choose the network to view: ");
        optionsPanel.add(label, BorderLayout.WEST);

        int addNum = 0;
        String options[] = new String[netList.size()];
        for (List list : netList) {
            options[addNum] = (String.valueOf(++addNum));
        }

        JComboBox netOptions = new JComboBox(options);
        optionsPanel.add(netOptions, BorderLayout.CENTER);

        add(optionsPanel, BorderLayout.SOUTH);

        add(view);

        netOptions.addActionListener(actionEvent -> {
            int netToView = netOptions.getSelectedIndex();
            view.setIndex(netToView);
            repaint();
        });

    }
}
