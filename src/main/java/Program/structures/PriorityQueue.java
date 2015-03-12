package Program.structures;

/**
 * Created by sircodesalot on 14/12/18.
 */
public class PriorityQueue<T extends Comparable<T>> {
  private int bottom = 0;
  private T[] heap = (T[])new Comparable[4];

  public void push(T item) {
    int current = bottom;
    int parent = current / 2;

    if (bottom >= heap.length) expand();
    heap[bottom++] = item;

    while (current > 0 && less(heap[parent], heap[current])) {
      swap(parent, current);
      current = parent;
      parent = current / 2;
    }
  }

  public T pop() {
    int parent = 0;
    int left = 1;
    int right = 2;


    T item = heap[0];
    heap[0] = heap[--bottom];
    while (left <= bottom) {
      int child;
      if (right < bottom && less(heap[left], heap[right])) {
        child = right;
      } else {
        child = left;
      }

      if (!less(heap[parent], heap[child])) {
        break;
      }

      swap(parent, child);
      parent = child;
      left = child * 2;
      right = child * 2 + 1;

    }

    return item;
  }

  private boolean less(T lhs, T rhs) {
    return lhs.compareTo(rhs) < 0;
  }

  private void swap(int lhs, int rhs) {
    T temporary = heap[lhs];
    heap[lhs] = heap[rhs];
    heap[rhs] = temporary;
  }

  public void expand() {
    T[] old = this.heap;
    this.heap = (T[])new Comparable[heap.length * 2];

    for (int index = 0; index < old.length; index++) {
      heap[index] = old[index];
    }
  }

  public boolean empty() {
    return bottom == 0;
  }
}

