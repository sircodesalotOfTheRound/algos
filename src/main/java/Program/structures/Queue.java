package Program.structures;

/**
 * Created by sircodesalot on 14/12/23.
 */
public class Queue<T> {
  private class Link {
    T item;
    Link next;
    public Link(T item, Link next) {
      this.item = item;
      this.next = next;
    }
  }

  private Link head;
  private Link tail;

  public void enqueue(T item) {
    if (head == null) {
      head = tail = new Link(item, null);
    } else {
      tail.next = new Link(item, null);
      tail = tail.next;
    }
  }

  public boolean isEmpty() { return this.head == null; }

  public T dequeue() {
    T item = this.head.item;
    this.head = this.head.next;
    return item;
  }

}

