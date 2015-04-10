package Program.graphs;

/**
 * Created by sircodesalot on 15/4/10.
 */
public class Node<T> {
  private final T item;
  private final int index;

  public Node(int index, T item) {
    this.item = item;
    this.index = index;
  }

  public T item() { return this.item; }

  public int index() { return this.index; }
}
