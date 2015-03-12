package Tests.googley;

import org.junit.Test;

/**
 * Created by sircodesalot on 15/3/5.
 */
public class TestBinarySearch {

  int binarySearch(int[] numbers, int lhs, int rhs, int value) {
    int middle = (lhs + rhs) / 2;
    int compare = numbers[middle];
    if (lhs > rhs) return -1;
    if (compare == value) return compare;
    if (value < compare) {
      return binarySearch(numbers, lhs, middle - 1, value);
    } else {
      return binarySearch(numbers, middle + 1, rhs, value);
    }
  }

  @Test
  public void test() {
    int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    assert(binarySearch(numbers, 0, 9, 5) == 5);
    assert(binarySearch(numbers, 0, 9, 20) == -1);
  }
}
