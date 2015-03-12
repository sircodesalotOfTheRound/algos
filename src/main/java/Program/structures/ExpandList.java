package Program.structures;

import java.util.Iterator;

/**
 * Created by sircodesalot on 14/12/18.
 */
public class ExpandList<T> implements Iterable<T> {
  private int insertionIndex = 0;
  private Object[] items = new Object[4];

  public void add(T item) {
    if (insertionIndex >= items.length) {
      this.items = resize();
    }

    items[insertionIndex++] = item;
  }

  public T get(int index) {
    return (T) items[index];
  }

  public Object[] resize() {
    Object[] expansion = new Object[this.items.length * 2];
    int index = 0;
    for (Object item : this.items) {
      expansion[index++] = item;
    }

    return expansion;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Object[] items = ExpandList.this.items;
      private int index = 0;
      private int max = ExpandList.this.insertionIndex;

      @Override
      public boolean hasNext() {
        return index < max;
      }

      @Override
      public T next() { return (T)items[index++]; }
    };
  }
}

