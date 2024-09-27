package week3_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1991 {

    static int N;

    static class Node {
        char self;
        Node left;
        Node right;

        public Node(char self, Node left, Node right) {
            this.self = self;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Node head = new Node('A', null, null);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char self = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(head, self, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }

    private static void postOrder(Node head) {
        if(head == null) {
            return;
        }

        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.self);
    }

    private static void inOrder(Node head) {
        if(head == null) {
            return;
        }

        inOrder(head.left);
        System.out.print(head.self);
        inOrder(head.right);
    }

    private static void preOrder(Node head) {
        if(head == null) {
            return;
        }

        System.out.print(head.self);
        preOrder(head.left);
        preOrder(head.right);
    }

    static void insert(Node temp, char self, char left, char right) {
        if(temp.self == self) {
            temp.left = left == '.' ? null : new Node(left, null, null);
            temp.right = right == '.' ? null : new Node(right, null, null);
        } else {
            if(temp.left != null) insert(temp.left, self, left, right);
            if(temp.right != null) insert(temp.right, self, left, right);
        }
    }
}
