import java.util.List;
import java.util.ArrayList;


public class BST<K extends Comparable<K>, V> {
    public class Node {
        public K key;
        public V val;
        public Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node root;
    private int size = 0;

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;
        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        if (node == null) return null;
        return node.val;
    }

    private Node get(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterable<Node> iterator() {
        List<Node> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node node, List<Node> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    public int size() {
        return size;
    }
}
