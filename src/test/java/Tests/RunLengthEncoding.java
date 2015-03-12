package Tests;

import org.junit.Test;

/**
 * Created by sircodesalot on 15/2/24.
 */
public class RunLengthEncoding {
  private static String runLengthEncoding(String string) {
    if (string == null || string.isEmpty()) {
      return string;
    }

    StringBuilder builder = new StringBuilder();
    char last = string.charAt(0);
    int count = 1;
    for (int index = 1; index < string.length(); index++) {
      char letter = string.charAt(index);
      if (index == string.length() - 1 && (letter != last)) {
        builder.append(last).append(count);
        builder.append(letter).append(1);
      } else if (index == string.length() - 1) {
        builder.append(last).append(count + 1);
      } else if (letter != last) {
        builder.append(last).append(count);
        last = letter;
        count = 1;
      } else {
        count++;
      }
    }

    return builder.toString();
  }

  @Test
  public void test() {
    assert (runLengthEncoding("aaabbbcccddd").equals("a3b3c3d3"));
    assert (runLengthEncoding("aaaaabbbbbccccddddddeeeee").equals("a5b5c4d6e5"));
    assert (runLengthEncoding("abcdefghijklmnop").equals("a1b1c1d1e1f1g1h1i1j1k1l1m1n1o1p1"));
    assert (runLengthEncoding("").equals(""));
    assert (runLengthEncoding(null) == null);
  }
}
