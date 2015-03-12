package Program.structures;

/**
 * Created by sircodesalot on 14/12/23.
 */
public class Link<T> {
  public Link<T> next;
  public T value;

  public Link(T value, Link<T> next) {
    this.value = value;
    this.next = next;
  }

  public Link<T> findHalf() {
    Link<T> slow = this;
    Link<T> fast = this;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }


  public static Link<Character> fromString(String string) {
    Link<Character> current = null;
    for (int index = string.length() - 1; index >= 0; index--) {
      current = new Link<>(string.charAt(index), current);
    }

    return current;
  }

  public void display() {
    for (Link<T> current = this; current != null; current = current.next) {
      System.out.print(current.value);
    }

    System.out.println();
  }

//  public Link<T> reverseAfter() {
//    Link<T> current = this, reverse = null;
//    while (current != null) {
//      Link<T> temporary = current.next;
//      current.next = reverse;
//      reverse = current;
//      current = temporary;
//    }
//
//    return reverse;
//  }

  public Link<T> reverseAfter() {
    Link<T> current = this, reverse = null;
    while (current != null) {
      Link<T> temporary = current.next;
      current.next = reverse;
      reverse = current;
      current = temporary;
    }

    return reverse;
  }
}
