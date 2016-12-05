import java.util.ArrayList;

public class FindSubtree {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int v) {
            value = v;
        }

        @Override
        public boolean equals(Object o) {
            if ( (o!=null) && (o instanceof Node) ) {
                return this.value == ((Node)o).value;
            }
            return false;
        }
    }

    Node bigtreeRoot;

    public boolean hasSubtree(Node subtreeRoot) {
        ArrayList queue = new ArrayList();
        queue.add( bigtreeRoot );
        while( !queue.isEmpty() ) {
            Node node = (Node) queue.remove(0);
            if ( node.equals(subtreeRoot) ) {
                boolean b = isEqual(node,subtreeRoot);
                if (b) return true;
            } 
            //-- 이하 로직을 else 에만 집어넣음 ㅠㅠ
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    public boolean isEqual(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if ((n1 == null && n2 != null) ||
            (n2 == null && n1 != null)) return false;
        return (n1.value == n2.value) && isEqual(n1.left,n2.left) && isEqual(n1.right,n2.right);
    }

    public static void main(String[] args) {
        Node bigtree = new Node(1);
        bigtree.left = new Node(2);
        bigtree.left.left = new Node(3);
        bigtree.left.right = new Node(4);
        bigtree.right = new Node(5);

        Node subtree = new Node(2);
        FindSubtree fs = new FindSubtree();
        fs.bigtreeRoot = bigtree;
        System.out.println("expected:false =>"+fs.hasSubtree(subtree));
        subtree.left = new Node(3);
        subtree.right=new Node(4);
        System.out.println("expected:true =>"+fs.hasSubtree(subtree));
    }
}
