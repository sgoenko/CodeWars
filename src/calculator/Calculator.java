package calculator;

import java.util.Stack;

public class Calculator {
  public static Double evaluate(String expression) {
    String[] parts = expression.split(" ");
    Stack<Double> s = new Stack<>();
    
    for (int i=0; i<parts.length; i+=2) {
      if (i == 0 || parts[i-1].equals("+")) {
        s.push(Double.valueOf(parts[i]));
      } else if (parts[i-1].equals("-")) {
        s.push(-Double.valueOf(parts[i]));
      } else if (parts[i-1].equals("*")) {
        s.push(s.pop()*Double.valueOf(parts[i]));
      } else if (parts[i-1].equals("/")) {
        s.push(s.pop()/Double.valueOf(parts[i]));
      }
    }
    
    double r = 0.0;
    while(!s.isEmpty()) {
      r += s.pop();
    }
    // your code here
    return r;
  }
}
