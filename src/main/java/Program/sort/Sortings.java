package Program.sort;

/**
 * Created by sircodesalot on 15/3/9.
 */
public class Sortings {
  private static void swap(int[] numbers, int lhs, int rhs) {
    int temporary = numbers[lhs];
    numbers[lhs] = numbers[rhs];
    numbers[rhs] = temporary;
  }

  public static int[] selection(int[] numbers) {
    for (int index = 0; index < numbers.length; index++) {
      for (int selection = index; selection < numbers.length; selection++) {
        if (numbers[index] > numbers[selection]) {
          swap(numbers, index, selection);
        }
      }
    }

    return numbers;
  }

  public static int[] insertion(int[] numbers) {
    for (int index = 1; index < numbers.length; index++) {
      for (int insertion = index; insertion > 0 && numbers[insertion] < numbers[insertion - 1]; insertion--) {
        swap(numbers, insertion, insertion - 1);
      }
    }

    return numbers;
  }

  public static int partition(int[] numbers, int left, int right) {
    int lhs = left - 1;
    int rhs = right;
    int comparison = numbers[right];

    while (true) {
      while (numbers[++lhs] < comparison);
      while (numbers[--rhs] > comparison) if (lhs == rhs) break;
      if (lhs >= rhs) break;
      swap(numbers, lhs, rhs);
    }

    swap(numbers, lhs, right);
    return lhs;
  }

  public static int[] quicksort(int[] numbers) {
    return quicksort(numbers, 0, numbers.length - 1);
  }

  public static int[] quicksort(int[] numbers, int lhs, int rhs) {
    if (lhs >= rhs) return numbers;
    int center = partition(numbers, lhs, rhs);
    quicksort(numbers, lhs, center - 1);
    quicksort(numbers, center + 1, rhs);
    return numbers;
  }

  public static int rank(int[] items, int rank) {
    return rank(items, 0, items.length - 1, rank);
  }

  public static int rank(int[] items, int lhs, int rhs, int rank) {
    if (lhs > rhs) return -1;
    int center = partition(items, lhs, rhs);

    if (rank < center) return rank(items, lhs, center - 1, rank);
    if (rank > center) return rank(items, center + 1, rhs, rank);
    return items[center];
  }
}
