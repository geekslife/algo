public class P_10_8 {
    class Node {
        Node( int value ) {
            this(value,0);
        }
        Node( int value, int count ) {
            this.value = value;
            this.count = count;
        }
        int count;
        int value;
        Node left;
        Node right;
    }

    Node root;

    void track( int x ) {
        if (root == null) {
            root = new Node(x);
        } else {
            traverse( root , x );
        }
    }

    void increaseChildren(Node node) {
        if (node != null) {
            node.count++;
            if (node.left != null) {
                increaseChildren(node.left);
            }
            if (node.right != null) {
                increaseChildren(node.right);
            }
        }
    }

    Node traverse( Node node, int x ) {
        if (node == null)
            return null;
        if (node.value < x ) {
            if (node.right == null) {
                return node.right = new Node(x,node.value+1);
            } else {
                return traverse( node.right, x );
            }
        } else if (node.value == x ) {
            node.count++;
            increaseChildren(node.right);
            return node;
        } else { // node.value > x
            node.count++;
            if (node.left == null) {
                return node.left = new Node(x, node.count-1);
            } else {
                return traverse( node.left, x );
            }
        }
    }

    int getRankOfNum( int n ) {
        Node node = root;
        while( node != null ) {
            if (node.value == n) {
                return node.count;
            } else if (node.value < n ) {
                node = node.left;
            } else if (node.value > n ) {
                node = node.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P_10_8 p = new P_10_8();
        assert p.root == null;
        p.track( 3 );
        assert p.getRankOfNum( 3 ) == 0;
        assert p.getRankOfNum( 4 ) == -1;
        p.track( 5 );
        assert p.getRankOfNum( 3 ) == 0;
        assert p.getRankOfNum( 5 ) == 1;
        p.track( 4 );
        assert p.getRankOfNum( 3 ) == 0;
        assert p.getRankOfNum( 5 ) == 2;
        assert p.getRankOfNum( 4 ) == 1;
        p.track( 7 );
        assert p.getRankOfNum( 3 ) == 0;
        assert p.getRankOfNum( 5 ) == 2;
        assert p.getRankOfNum( 4 ) == 1;
        assert p.getRankOfNum( 7 ) == 3;
        p.track( 5 );
        assert p.getRankOfNum( 3 ) == 0;
        assert p.getRankOfNum( 5 ) == 3;
        assert p.getRankOfNum( 4 ) == 1;
        assert p.getRankOfNum( 7 ) == 4;
        p.track( 6 );
        assert p.getRankOfNum( 3 ) == 0;
        assert p.getRankOfNum( 5 ) == 3;
        assert p.getRankOfNum( 4 ) == 1;
        assert p.getRankOfNum( 7 ) == 5;
        assert p.getRankOfNum( 6 ) == 4;

        System.out.println("OK");
    }
}
