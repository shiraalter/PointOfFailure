package touro.alter;

import org.junit.Test;

import static org.junit.Assert.*;

    public class GraphNodeTest {

        @Test
        public void getConnections() {
            //GIVEN
            GraphNode node1 = new GraphNode("1");
            GraphNode node2 = new GraphNode("2");
            GraphNode node3 = new GraphNode("3");

            node1.addConnection(node2);
            node1.addConnection(node3);

            //WHEN & THEN
            assertNotNull(node1.getConnections());

        }

        @Test
        public void addConnection() {
            //GIVEN


            GraphNode node1 = new GraphNode("1");
            GraphNode node2 = new GraphNode("2");
            GraphNode node3 = new GraphNode("3");

            //WHEN
            node1.addConnection(node2);
            node1.addConnection(node3);

            //THEN
            assertNotNull(node1.getConnections());
            assertTrue(node1.getConnections().size() == 2);

        }

        @Test
        public void removeConnection() {
            //GIVEN
            GraphNode node1 = new GraphNode("1");
            GraphNode node2 = new GraphNode("2");
            GraphNode node3 = new GraphNode("3");

            node1.addConnection(node2);
            node1.addConnection(node3);

            //WHEN
            node1.removeConnection(node2);

            //THEN
            assertTrue(node1.getConnections().size() == 1);

        }


    }

