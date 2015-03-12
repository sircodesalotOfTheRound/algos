package Program.structures;

/**
 * add, contains, expand, keys, iterator, get
 */
public class MyHashMap<T, U> {
  class Link {
    T key;
    U value;
    Link next;
    public Link(T key, U value, Link next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  int length = 11;
  Object[] items = new Object[length];

  public int hash(T item) {
    return Math.abs(item.hashCode()) % length;
  }

  private Link find(T key) {
    int hash = hash(key);
    for (Link current = (Link) items[hash]; current != null; current = current.next) {
      if (current.key.equals(key)) {
        return current;
      }
    }

    return null;
  }

  public boolean add(T key, U value) {
    if (find(key) == null) {
      int hash = hash(key);
      items[hash] = new Link(key, value, (Link)items[hash]);
      return true;
    }
    return false;
  }

  public boolean containsKey(T key) {
    return find(key) != null;
  }

  public U get(T key) {
    return find(key).value;
  }


}

