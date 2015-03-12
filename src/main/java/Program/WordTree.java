package Program;

/**
 * Created by sircodesalot on 14/12/19.
 */
public class WordTree {
  public class Node {
    Node lhs;
    Node rhs;

    int offset;
    String string;

    public Node(String string, int offset) {
      this.string = string;
      this.offset = offset;
    }
  }

  public Node rotateRight(Node node) {
    Node temp = node.lhs;
    node.lhs = temp.rhs;
    temp.rhs = node;

    return temp;
  }

  public Node rotateLeft(Node node) {
    Node temp = node.rhs;
    node.rhs = temp.lhs;
    temp.lhs = node;

    return temp;
  }

  public WordTree(String text) {
    int location = 0;
    for (String word : text.split(" ")) {
      this.insert(word, location);
      location += word.length() + 1;
    }
  }

  private Node head;
  private void insert(String string, int location) {
    this.head = this.insert(head, string, location);
  }

  private Node insert(Node node, String string, int location) {
    if (node == null) {
      return new Node(string, location);
    }

    if (string.compareTo(node.string) <= 0) {
      node.lhs = insert(node.lhs, string, location);
    } else {
      node.rhs = insert(node.rhs, string, location);
    }

    return node;
  }

  private Node find(Node node, String string) {
    if (node == null) {
      return null;
    } else if (string.equals(node.string)) {
      return node;
    }

    if (string.compareTo(node.string) <= 0) {
      return find(node.lhs, string);
    } else {
      return find(node.rhs, string);
    }
  }

  public int getOffset(String key) {
    Node node = find(head, key);
    if (node != null) {
      return node.offset;
    }

    return -1;
  }

  public boolean containsKey(String key) {
    return find(head, key) != null;
  }
}
