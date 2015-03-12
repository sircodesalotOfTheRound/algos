package Program.structures;

/**
 * Created by sircodesalot on 14/12/23.
 */
public class Stack<T> {
  class Link {
    T item;
    Link next;

    public Link(T item, Link next) {
      this.item = item;
      this.next = next;
    }
  }

  private Link head;

  public void push (T item) {
    this.head = new Link(item, head);
  }

  public T pop() {
    T item = this.head.item;
    this.head = this.head.next;
    return item;
  }

  public boolean isEmpty() { return this.head != null; }
}

