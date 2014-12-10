package chicm;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * @author chicm
 *
 */

public class SingleNumber2 {
  public int singleNumber(int A[]) {
    int result = 0;
      int count[] = new int[32];
      for (int i = 0; i < 32; i++) {
          for (int j = 0; j < A.length; j++) {
              if (((A[j] >> i) & 1) != 0) {
                  count[i]++;
              }
          }
          result |= ((count[i] % 3) << i);
      }
      return result;
  }
}
