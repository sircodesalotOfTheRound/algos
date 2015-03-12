package Program.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sircodesalot on 15/2/2.
 */
public class DigraphNode<T, U> {
  T key;
  U value;
  Set<DigraphLink<T, U>> connections = new HashSet<>();

  public DigraphNode(T key, U value) {
    this.key = key;
    this.value = value;
  }

  public void add(DigraphLink<T, U> connection) {
    this.connections.add(connection);
  }

  public T key() { return this.key; }
  public U value() { return this.value; }

  public Iterable<DigraphLink<T, U>> connections() { return this.connections; }
  public void remove(DigraphNode node) { this.remove(node); }
}
