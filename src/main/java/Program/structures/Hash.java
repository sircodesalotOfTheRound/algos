package Program.structures;

/**
 * Created by sircodesalot on 14/12/16.
 */
public class Hash<T> {
  class Link {
    T item;
    Link next;
    public Link(T item, Link next) {
      this.item = item;
      this.next = next;
    }
  }

  int size = 11;
  Object[] items = new Object[size];

  private int hash(T item) { return Math.abs(item.hashCode()) % size; }
  private Link find(T item) {
    int hash = hash(item);
    for (Link current = (Link)items[hash]; current != null; current = current.next) {
      if (current.item.equals(item)) {
        return current;
      }
    }

    return null;
  }

  public boolean contains(T item) { return find(item) != null; }

  public boolean add(T item) {
    if (!contains(item)) {
      int hash = hash(item);
      items[hash] = new Link(item, (Link)items[hash]);
      return true;
    } else {
      return  false;
    }
  }
}
