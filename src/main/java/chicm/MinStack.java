package chicm;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

 * @author chicm
 *
 */

class MinStack {
  private int[] stack;
  private int top=-1;
  private int capacity;
  
  private int[] min;
  private int minTop=-1;
  
  public MinStack() {
      stack = new int[100];
      this.capacity = 100;
      min = new int[100];
  }
  
  private void copyOnFull() {
      int newSize = capacity * 2;
      int[] newStack = new int[newSize];
      int[] newMin = new int[newSize];
      System.arraycopy(stack, 0, newStack, 0, capacity-1);
      System.arraycopy(min, 0, newMin, 0, capacity-1);
      stack = newStack;
      min = newMin;
      capacity = newSize;
  }
  
  public void push(int x) {
      if(top == capacity -1) {
          copyOnFull();
      }
      stack[++top] = x;
      
      if(minTop == -1 || x <= min[minTop]) {
          min[++minTop] = x;
      }
  }

  public void pop() {
      if(top == -1) {
          return;
      }
      
      if(stack[top] <= min[minTop]  && minTop != -1) {
          minTop--;
      }
      top--;
      
  }

  public int top() {
      return stack[top];
  }

  public int getMin() {
      return min[minTop];
  }
}
