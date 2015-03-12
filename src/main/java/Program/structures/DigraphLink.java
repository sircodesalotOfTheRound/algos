package Program.structures;

/**
 * Created by sircodesalot on 15/2/6.
 */
public class DigraphLink<T, U> {
  private final DigraphNode<T, U> source;
  private final DigraphNode<T, U> destination;
  private final double weight;

  public DigraphLink(DigraphNode<T, U> source, DigraphNode<T, U> destination, double weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }

  public DigraphNode<T, U> source() { return source; }
  public DigraphNode<T, U> destination() { return destination; }
  public double weight() { return this.weight; }
}
