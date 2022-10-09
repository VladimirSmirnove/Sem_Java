
class Node {
    int key;
    Node left, right;
  
    public Node(int item) {
    key = item;
    left = right = null;
    }
  }
  
  class BinaryTree {
    Node root;
  
    BinaryTree(int key) {
    root = new Node(key);
    }
  
    BinaryTree() {
    root = null;
    }
  
    // Центрированный обход дерева
    public void traverseInOrder(Node node, String space) {
    if (node != null) {
      traverseInOrder(node.left, space + " ");
      System.out.printf("%s%s\n", space, node.key);
      traverseInOrder(node.right, space + " ");
    }
    }
  
    // Обратный обход дерева
    public void traversePostOrder(Node node, String space) {
    if (node != null) {
      traversePostOrder(node.left, space + " ");
      traversePostOrder(node.right, space + " ");
      System.out.printf("%s%s\n", space, node.key);
    }
    }
  
    // Прямой обход дерева
    public void traversePreOrder(Node node, String space) {
    if (node != null) {
      System.out.printf("%s%s\n", space, node.key);
      traversePreOrder(node.left, space + " ");
      traversePreOrder(node.right, space + " ");
    }
    }
  
    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
  
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
  
    System.out.print("Прямой обход дерева: \n");
    tree.traversePreOrder(tree.root, " ");
    System.out.print("\nЦентрированный обход дерева: \n");
    tree.traverseInOrder(tree.root, " ");
    System.out.print("\nОбратный обход дерева: \n");
    tree.traversePostOrder(tree.root, " ");
    }
  }