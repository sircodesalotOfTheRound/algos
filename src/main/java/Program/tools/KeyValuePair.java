package Program.tools;

/**
 * Created by sircodesalot on 14/12/19.
 */
public class KeyValuePair<T, U> {
  private T key;
  private U value;

  public KeyValuePair(T key, U value) {
    this.key = key;
    this.value = value;
  }

  public T key() {
    return this.key;
  }

  public U value() {
    return this.value;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", key, value);
  }
}
