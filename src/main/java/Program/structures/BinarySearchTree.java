package Program.structures;

/**
 * Created by sircodesalot on 14/12/18.
 */
public class BinarySearchTree<T extends Comparable<T>> {
  class Node {
    T value;
    int count;
    Node lhs;
    Node rhs;

    public Node(T value) {
      this.value = value;
      this.lhs = null;
      this.rhs = null;
      this.count = 1;
    }
  }

  private Node head;

  public void insert(T item) {
    this.head = insert(item, this.head);
  }

  private Node insert(T item, Node node) {
    if (node == null) return new Node(item);
    if (node.value.compareTo(item) <= 0) {
      node.lhs = insert(item, node.lhs);
    } else {
      node.rhs = insert(item, node.rhs);
    }

    node.count++;
    return node;
  }

  private Node find(T value, Node node) {
    if (node == null) return null;
    if (node.value.equals(value)) return node;
    if (node.value.compareTo(value) <= 0) {
      return find(value, node.lhs);
    } else {
      return find(value, node.rhs);
    }
  }

  public boolean contains(T item) {
    return find(item, this.head) != null;
  }

  public T select(int index) {
    return select(head, index);
  }

  public T select(Node node, int index) {
    int lhsSize = node.lhs != null ? node.lhs.count : 0;
    if (index < lhsSize) return select(node.lhs, index);
    if (index > lhsSize) return select(node.rhs, index - lhsSize - 1);
    return node.value;
  }

  public void partition(int index) {
    head = partition(head, index);
  }

  public void balance() {
    if (head == null) return;
    this.head = balance(head);
  }

//  private Node balance(Node node) {
//    if (node.count < 2) return node;
//    node = partition(node, node.count / 2);
//    node.lhs = balance(node.lhs);
//    node.rhs = balance(node.rhs);
//    return node;
//  }


  private Node balance(Node node) {
    if (node.count < 2) return node;
    node = partition(node, node.count / 2);
    node.lhs = balance(node.lhs);
    node.rhs = balance(node.rhs);
    return node;
  }

  private Node partition(Node node, int index) {
    int leftSize = (node.lhs == null) ? 0 : node.lhs.count;

    if (index < leftSize){
      node.lhs = partition(node.lhs, index);
      node = rotateRight(node);
    } else if (index > leftSize) {
      node.rhs = partition(node.rhs, index - leftSize - 1);
      node = rotateLeft(node);
    }

    return node;
  }

  public T head() { return this.head.value; }

  public void topInsert(T item) {
    this.head = topInsert(head, item);
  }

  public Node topInsert(Node node, T item) {
    if (node == null) return new Node(item);
    if (node.value.compareTo(item) <= 0) {
      node.lhs = topInsert(node.lhs, item);
      node = rotateRight(node);
    } else {
      node.rhs = topInsert(node.rhs, item);
      node =rotateLeft(node);
    }

    node.count++;
    return node;
  }

  public Node rotateRight(Node node) {
    Node temporary = node.lhs;
    node.lhs = temporary.rhs;
    temporary.rhs = node;

    node.count = recount(node);
    temporary.count = recount(temporary);
    return temporary;
  }


  public Node rotateLeft(Node node) {
    Node temporary = node.rhs;
    node.rhs = temporary.lhs;
    temporary.lhs = node;

    node.count = recount(node);
    temporary.count = recount(temporary);
    return temporary;
  }


  private int recount(Node node) {
    int count = 0;
    count += (node.lhs != null) ? node.lhs.count : 0;
    count += (node.rhs != null) ? node.rhs.count : 0;
    return count;
  }

}
