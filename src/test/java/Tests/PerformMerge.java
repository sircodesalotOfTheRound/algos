package Tests;

import org.junit.Test;

/**
 * Created by sircodesalot on 15/2/24.
 */
public class PerformMerge {

  public int[] merge(int[] left, int[] right) {
    int length = left.length + right.length;
    int[] array = new int[length];
    int lhs = 0;
    int rhs = 0;
    for (int index = 0; index < length; index++) {
      if (lhs >= left.length || (rhs < right.length && left[lhs] > right[rhs])) {
        array[index] = right[rhs++];
      } else {
        array[index] = left[lhs++];
      }
    }

    return array;
  }

  public boolean equals(int[] lhs, int[] rhs) {
    if (lhs.length != rhs.length) return false;
    int length = lhs.length;
    for (int index = 0; index < length; index++) {
      if (lhs[index] != rhs[index]) return false;
    }

    return true;
  }

  public int[] toArray(int ... numbers) {
    return numbers;
  }

  @Test
  public void run() {
    assert(equals(merge(toArray(2, 4), toArray(1, 5)), toArray(1, 2, 4, 5)));
    assert(equals(merge(toArray(1, 6), toArray(1, 2, 3)), toArray(1, 1, 2, 3, 6)));

    assert(equals(merge(toArray(1, 2, 3, 4, 5), toArray(6, 7, 8, 9, 10)), toArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    assert(equals(merge(toArray(1, 3, 5, 7, 9), toArray(2, 4, 6, 8, 10)), toArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

  }
}
