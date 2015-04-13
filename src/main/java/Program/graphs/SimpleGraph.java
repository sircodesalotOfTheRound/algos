package Program.graphs;

import java.util.*;

/**
 * Created by sircodesalot on 15/4/10.
 */
public class SimpleGraph<T> {
  private final List<Node<T>> nodesByIndex = new ArrayList<>();
  private final Map<Node<T>, Set<Node<T>>> links = new HashMap<>();

  public int add(T item) {
    int index = nodesByIndex.size();
    Node<T> node = new Node<T>(index, item);

    nodesByIndex.add(node);
    return index;
  }

  public int getIndex(Node<T> node) {
    return node.index();
  }

  public Node<T> getByIndex(int index) {
    return this.nodesByIndex.get(index);
  }

  public void addEdge(int begin, int end) {
    this.addEdge(getByIndex(begin), getByIndex(end));
  }

  public void addEdge(Node<T> begin, Node<T> end) {
    this.getEdgestForNode(begin).add(end);
  }

  public void removeEdge(int begin, int end) {
    this.removeEdge(getByIndex(begin), getByIndex(end));
  }

  public void removeEdge(Node<T> begin, Node<T> end) {
    this.getEdgestForNode(begin).remove(end);
  }

  public Set<Node<T>> getEdges(Node<T> node) {
    return this.getEdgestForNode(node);
  }

  private Set<Node<T>> getEdgestForNode(Node<T> node) {
    if (!this.links.containsKey(node)) {
      this.links.put(node, new HashSet<>());
    }

    return this.links.get(node);
  }
}
