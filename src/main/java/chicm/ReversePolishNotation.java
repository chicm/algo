package chicm;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

  public static void main(String[] args) {
    ReversePolishNotation f = new ReversePolishNotation();
    
    String[] notation = {"5", "3", "+", "5", "-", "6", "7", "+", "+"};
    
    System.out.println(f.evalRPN(notation));

  }
  public int evalRPN(String[] tokens) {
    if(tokens == null || tokens.length == 2) {
      throw new RuntimeException("Invalid notation");
    }
    if(tokens.length == 1) {
        return Integer.parseInt(tokens[0]);
    }
    
    Deque<String> q = new LinkedList<String>();
    
    for(String s: tokens) {
        String token = s.trim();
        if(token.length() > 0 && isOperator(token)) {
            int op2 = Integer.parseInt(q.pop());
            int op1 = Integer.parseInt(q.pop());
            int result = 0;
            switch(token) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    result = op1 / op2;
                    break;
            }
            q.push(new Integer(result).toString());
        } else if(token.length() > 0) {
            q.push(token);
        }
    }
    return Integer.parseInt(q.pop());
  }

  private boolean isOperator(String op) {
      return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
  }
}
