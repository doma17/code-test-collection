import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodes);
        Tree tree = new Tree(nodes[0]);
        for (int i = 1; i < n; i++) {
            tree.add(nodes[i]);
        }
        return new int[][]{tree.prefixTraversal(), tree.postTraversal()};
    }
}

class Tree {
    private Node root;
    private int size;

    public Tree(Node root) {
        this.root = root;
        this.size = 1;
    }

    public void add(Node node) {
        add(root, node);
        size++;
    }

    private void add(Node parent, Node child) {
        int parentValue = parent.x;
        int childValue = child.x;

        if (childValue < parentValue) { // 자식이 부모 노드의 왼쪽에 있을 때
            if (parent.left == null) { // 부모 노드의 왼쪽이 비어있음
                parent.left = child;
            }
            else if (child.y < parent.left.y) { // 부모 노드의 왼쪽 자식이 존재하고 기존 왼쪽 자식 보다 아래에 위치함
                add(parent.left, child);
            }
            else { // 부모 노드의 왼쪽 자식 보다 위에 위치함
                add(child, parent.left);
                parent.left = child;
            }
        }
        else {
            if (parent.right == null) { // 부모 노드의 오른쪽이 비어있음
                parent.right = child;
            }
            else if (child.y < parent.right.y) { // 부모 노드의 오른쪽 자식이 존재하고 기존 오른쪽 자식 보다 아래에 위치함
                add(parent.right, child);
            }
            else { // 부모 노드의 오른쪽 자식 보다 위에 위치함
                add(child, parent.right);
                parent.right = child;
            }
        }
    }

    public int[] prefixTraversal() {
        Queue<Integer> queue = new LinkedList<>();
        prefixTraversal(queue, root);

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public void prefixTraversal(Queue<Integer> queue, Node node) {
        if (node == null) return;

        // 전위순회
        queue.add(node.num);
        prefixTraversal(queue, node.left);
        prefixTraversal(queue, node.right);
    }

    public int[] postTraversal() {
        Queue<Integer> queue = new LinkedList<>();
        postTraversal(queue, root);

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public void postTraversal(Queue<Integer> queue, Node node) {
        if (node == null) return;

        // 후위순회
        postTraversal(queue, node.left);
        postTraversal(queue, node.right);
        queue.add(node.num);
    }
}

class Node implements Comparable<Node> {
    public int x, y, num;
    public Node left, right;

    public Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;

        left = right = null;
    }


    @Override
    public int compareTo(Node o) {
        return o.y == this.y ? this.x - o.x : o.y - this.y;
    }
}