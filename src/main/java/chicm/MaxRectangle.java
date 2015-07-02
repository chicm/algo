package chicm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class MaxRectangle {

  public static void main(String[] args) {
    int[] h = {2, 1, 5, 6, 4, 3, 10, 2, 2,2};
    int[] h2 = {4,2};
    int[] h3 = {2, 5, 3, 4, 1};
    System.out.println("area:" + maxRectangleArea(h));
    System.out.println("area:" + maxRectangleArea(h2));
    System.out.println("area:" + largestRectangleArea(h2));
    System.out.println("area:" + largestRectangleArea(h3));
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
  
  public static int largestRectangleArea(int[] height) {
    if(height == null || height.length == 0) {
        return 0;
    }
    if(height.length == 1) {
        return height[0];
    }
    Deque<Integer> stack = new LinkedList<>();
    int max = height[0];
    
    for(int i = 0; i < height.length; ) {
        if(stack.isEmpty() || height[i] > height[stack.peek()]) {
            stack.push(i++);
        } else { 
            // while current height < stack.peek(), do not increase i counter,
            // to loop until current height > stack.peek()
            int topIndex = stack.pop();
            int curArea = height[topIndex] * (stack.isEmpty()? i: i-1-stack.peek());
            if(curArea > max) {
                max = curArea;
            }
        }
    }
    while(!stack.isEmpty()) {
        int topIndex = stack.pop();
        int curArea = height[topIndex] * (stack.isEmpty()? height.length: height.length-1-stack.peek());
        if(curArea > max) {
            max = curArea;
        }
    }
    return max;
}
}
