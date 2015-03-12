package Program.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sircodesalot on 14/12/22.
 */
public class Digraph<T, U> {
  private Map<T, DigraphNode<T, U>> nodes = new HashMap<>();

  public void addNode(T key, U value) {
    DigraphNode<T, U> node = new DigraphNode<T, U>(key, value);
    nodes.put(key, node);
  }

  public void connect(T lhs, T rhs, double weight) {
    DigraphNode<T, U> source = nodes.get(lhs);
    DigraphNode<T, U> destination = nodes.get(rhs);
    DigraphLink<T, U> connection = new DigraphLink<>(source, destination, weight);

    source.add(connection);
  }

  public void connect(T lhs, T rhs) {
    this.connect(lhs, rhs, 1);
  }

  public DigraphNode<T, U> get(T key) {
    return nodes.get(key);
  }
}
