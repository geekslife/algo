class P_4_7 {
    static class Node {
        Node left;
        Node right;
        Object value;
        Node(Object o) {
            this.value = o;
        }
    }

    public boolean covers( Node node, Node child ) {
        if (node == null) return false;
        if (node == child) return true;
        return covers( node.left, child ) || covers( node.right, child );
    }

    public Node findAncestor( Node node, Node a, Node b ) {
        if (node == null) return null; //!
        if (node == a || node == b) return node; //!
        if ( covers( node.left, a ) && covers( node.left, b ) )
            return findAncestor( node.left, a, b );
        if ( covers( node.right, a ) && covers( node.right, b ) )
            return findAncestor( node.right, a, b );
        return node;
    }

    public static void main(String[] args) {
        P_4_7 prob = new P_4_7();
        Node root = new Node("root");
        Node a = new Node("a");
        Node b = new Node("b");
        root.left = a;
        root.right = b;
        assert root == prob.findAncestor( root, a, b );

        root.left = null;
        Node p1 = new Node("p1");
        root.right = p1;
        p1.left = a;
        p1.right = b;
        assert p1 == prob.findAncestor( root, a, b );

        root.left = null;
        root.right = p1;
        p1.left = a;
        a.right = b;
        assert a == prob.findAncestor( root, a, b );
        System.out.println("pass all!");
    }
}
