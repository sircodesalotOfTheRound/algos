package Tests.googley;

import Program.sort.Sortings;
import org.junit.Test;

/**
 * Created by sircodesalot on 15/3/9.
 */
public class SortTests {

  private int[] generateNumbers() {
    return new int[] { 0, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
  }

  public void testInorder(int[] numbers) {
    int last = Integer.MIN_VALUE;
    for (int number : numbers) {
      assert(number >= last);
      last = number;
    }
  }

  @Test
  public void testSelectionSort() {
    int[] numbers = generateNumbers();
    Sortings.selection(numbers);
    testInorder(numbers);
  }

  @Test
  public void testInsertionSort() {
    int[] numbers = generateNumbers();
    Sortings.insertion(numbers);
    testInorder(numbers);
  }

  @Test
  public void testQuicksort() {
    int[] numbers = generateNumbers();
    Sortings.quicksort(numbers);
    testInorder(numbers);
  }

  @Test
  public void testRank() {
    int[] numbers = generateNumbers();
    assert(Sortings.rank(numbers, 7) == 7);
  }
}
