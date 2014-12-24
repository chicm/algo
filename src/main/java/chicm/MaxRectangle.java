package chicm;

import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class MaxRectangle {

  public static void main(String[] args) {
    int[] h = {2, 1, 5, 6, 4, 3, 10, 2, 2,2};
    System.out.println("area:" + maxRectangleArea(h));
  }

  public static int maxRectangleArea(int[] h) {
    if(h.length == 0)
      return 0;
    if(h.length == 1)
      return h[0];
    int max = 0;
    int len = h.length;
    LinkedList<Integer> stack = new LinkedList<Integer>();
    
    int i = 0;
    while(i < len) {
      
      if(stack.isEmpty() || h[i] > h[stack.peek()]) {
        stack.push(i++);
      } else {
        int prev = stack.pop();
        max = Math.max(max, h[prev] * (stack.isEmpty()? i: i - stack.peek() -1));
      }
    }
    while(!stack.isEmpty() ) {
      int prev = stack.pop();
      max = Math.max(max, h[prev] * (stack.isEmpty()? len: len - stack.peek() -1));
    }
    return max;
        
  }
}
