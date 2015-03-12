package Tests.googley;

import Program.structures.BinarySearchTree;
import org.junit.Test;

/**
 * Created by sircodesalot on 15/3/5.
 */
public class TestBinaryTree {

  @Test
  public void test() {
    int[] numbers = new int[] { 0, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    for (int number : numbers) {
      tree.insert(number);
    }

    assert(tree.head() == 0);
    assert(tree.contains(9));
    assert(!tree.contains(20));
    assert(tree.select(5) == 4);
  }

  @Test
  public void testTopInsert() {
    int[] numbers = new int[] { 0, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    for (int number : numbers) {
      tree.topInsert(number);
    }

    assert(tree.head() == 5);
  }


  @Test
  public void testPartition() {
    int[] numbers = new int[] { 0, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    for (int number : numbers) {
      tree.insert(number);
    }

    tree.partition(8);
    //assert(tree.head() == 9);
  }
}
