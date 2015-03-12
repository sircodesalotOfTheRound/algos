package Tests.googley;

import Program.structures.Link;
import org.junit.Test;

/**
 * Created by sircodesalot on 15/3/5.
 */
public class LinkTest {
  @Test
  public void test() {
    Link<Character> something = Link.fromString("Something");

    assert(something.findHalf().value == 't');
    int index = "Something".length();
    for (Link current = something.reverseAfter(); current != null; current = current.next) {
      assert(current.value.equals("Something".charAt(--index)));
    }
  }
}
