package tree;

import java.util.Collections;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by geekslife on 2017. 1. 10..
 */
public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void preorder(Node node) {
        if (node !=null) {
            System.err.println("> "+node.value);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if (node!=null) {
            inorder(node.left);
            System.err.println("> "+node.value);
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.err.println("> "+node.value);
        }
    }

    static class Node {
        public Node(int value) {
            this(value,null,null);
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void setValue(int i) { this.value = i; }
        public int getValue() { return this.value; }

        int value;
        Node left;
        Node right;

        public String toString(int tabindex) {
            String prefix = Collections.nCopies(tabindex,"\t").stream().collect(Collectors.joining(""));
            String str = prefix+"Node<"+tabindex+":"+value+">\n";
            if (left!=null)
                str += prefix+"\t(L)"+left.toString(tabindex+1);
            if (right!=null)
                str += prefix+"\t(R)"+right.toString(tabindex+1);
            return str;
        }

        public String toString() {
            return toString(0);
        }
    }

    public static Node getTestNode() {
        return new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5,
                                new Node(6,
                                        null,
                                        new Node(7)
                                        ),
                                null
                        )
                ),
                new Node(3,
                        new Node(8),
                        new Node( 9)
                )
        );
    }

    public static void main(String[] args) {
        System.err.println(getTestNode());
        BinaryTree tree = new BinaryTree( getTestNode() );
        tree.preorder(tree.root);
        System.err.println("------- inorder -----");
        tree.inorder(tree.root);
        System.err.println("------- postorder -----");
        tree.postorder(tree.root);
    }
}
