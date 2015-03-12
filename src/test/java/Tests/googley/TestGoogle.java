package Tests.googley;

import Program.structures.Hash;
import Program.structures.MyHashMap;
import Program.structures.Queue;
import Program.structures.Stack;
import org.junit.Test;

/**
 * Created by sircodesalot on 15/3/5.
 */
public class TestGoogle {
  @Test
  public void testStack() {
    int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    Stack<Integer> stack = new Stack<>();
    for (int number : numbers) {
      stack.push(number);
    }

    int index = numbers.length;
    while(!stack.isEmpty()) {
      assert(stack.pop() == numbers[--index]);
    }
  }

  @Test
  public void testQueue() {
    int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    Queue<Integer> queue = new Queue<>();
    for (int number : numbers) {
      queue.enqueue(number);
    }

    int index = 0;
    while(!queue.isEmpty()) {
      assert(queue.dequeue() == numbers[index++]);
    }
  }


  @Test
  public void testHash() {
    int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    Hash<Integer> hash = new Hash<>();
    for (int number : numbers) {
      hash.add(number);
    }

    assert(hash.contains(5));
    assert(!hash.contains(20));

    assert(!hash.add(5));
    assert(hash.add(20));

  }


  @Test
  public void testMap() {
    MyHashMap<Integer, String> map = new MyHashMap<>();
    map.add(1, "first");
    map.add(2, "second");
    map.add(3, "third");
    map.add(4, "fourth");

    assert(map.containsKey(1));
    assert(!map.containsKey(5));

    assert(map.get(4).equals("fourth"));
  }
}
