package Program;

import java.util.Stack;

/**
 * Created by sircodesalot on 14/12/16.
 */
public class WeirdingQueue<T> {
  private final Stack<T> inbox = new Stack<T>();
  private final Stack<T> outbox = new Stack<T>();

  public boolean empty() {
    return outbox.empty() && inbox.empty();
  }

  public void enqueue(T item) {
    this.inbox.push(item);
  }

  public T dequeue() {
    if (outbox.empty()) {
      dumpInbox();
    }

    return outbox.pop();
  }

  private void dumpInbox() {
    while (!inbox.empty()) {
      outbox.push(inbox.pop());
    }
  }
}
