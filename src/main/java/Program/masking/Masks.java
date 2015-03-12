package Program.masking;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by sircodesalot on 14/12/22.
 */
public class Masks {
  public static int countOnes(int value) {
    int count = 0;
    for (int remainder = value; remainder != 0; remainder = remainder & (remainder - 1)) {
      count++;
    }

    return count;
  }

  public static boolean isPowerOfTwo(int value) {
    if (value == 0) return false;

    return (value & value - 1) == 0;
  }

  public static boolean countParity(int value) {
    boolean parity = false;
    while (value > 0) {
      parity = !parity;
      value = value & (value - 1);
    }

    return parity;
  }

  public static int setBit(int value, int bitNumber) {
    return value | (1<<bitNumber);
  }

  public static int toggleBit(int value, int bitNumber) {
    return value ^ (1 << bitNumber);
  }

  public static int rightPropogateRightBit(int value) {
    return value | value - 1;
  }

  public static int isolateRightmostBit(int value) {
    return value & -value;
  }

  public static int unsetBit(int value, int bitNumber) {
    return value & ~(1<<bitNumber);
  }

  public static boolean hasOppositeSigns(int lhs, int rhs) {
    return (lhs ^ rhs) < 0;
  }

  public static int absoluteValueWithoutBranching(int value) {
    throw new NotImplementedException();
  }

  public static int swap(int lhs, int rhs) {
    lhs ^= rhs;
    rhs ^= lhs;
    lhs ^= rhs;

    return lhs;
  }
}
