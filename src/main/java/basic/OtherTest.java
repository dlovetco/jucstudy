package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mhh
 * @since 2020/8/20
 */
public class OtherTest {

    public static void main(String[] args) {
        int i = 0;
        List<Node> nodes = new ArrayList<>();
        for (int l = 1; l <= 2017; l++) {
            nodes.add(new Node(l, false));
        }
        nodes.forEach(node -> {
            if (node.i % 2 == 0) {
                node.b = !node.b;
            }
            if (node.i % 3 == 0) {
                node.b = !node.b;
            }
            if (node.i % 5 == 0) {
                node.b = !node.b;
            }
        });
        System.out.println(nodes.stream().map(Node::isB).filter(b -> b).count());
    }

    public static class Node {

        public boolean isB() {
            return b;
        }

        int i;

        boolean b = true;

        public Node(int i, boolean b) {
            this.i = i;
            this.b = b;
        }
    }
}
