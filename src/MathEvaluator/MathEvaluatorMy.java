package MathEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MathEvaluatorMy {

	public double calculate(String expression) {

		System.out.println(expression);
		expression = expression.replaceAll(" ", "");

		String normal = normalize(expression);
		System.out.println(normal);

		String regular = evalueteParentheses(normal);
		System.out.println(regular);

		double result = evaluate(regular);
		return result;
	}

	public static String normalize(String expression) {

		List<Character> chars = expression 
			      .chars() 
			      .mapToObj(e -> (char)e) 
			      .collect(Collectors.toList()); 
		
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < chars.size(); i++) {
									
			if (i==0 && chars.get(i) != '(' || Character.isDigit(chars.get(i)) || chars.get(i) == '.') {
				builder.append(chars.get(i));
				
			} else if (chars.get(i) == '-') {

				if ( (chars.get(i-1) == '-' || chars.get(i-1) == '+' || 
						chars.get(i-1) == '*' || chars.get(i-1) == '/' || chars.get(i-1) == '(')
					&& 	
					 (chars.get(i+1) == '(')
				) {
					builder.append(" ( -1 * ");
					chars.add(chars.lastIndexOf(')'), ')');
					
				} else if (Character.isDigit(chars.get(i-1)) || chars.get(i-1) == ')') {
					builder.append(" - ");
				} else {
					builder.append(" -");
				}
			} else {
				builder.append(' ');
				builder.append(chars.get(i));
				builder.append(' ');
			}
		}
		return builder.toString();

	}

	public static String evalueteParentheses(String expression) {
//		String[] parts = expression.split("\s+");

		String[] parts = expression.split(" ");
		String[] trash = expression.split(" ");

		int size = 0;
		for (String string : trash) {
			if (!string.isBlank()) {
				parts[size++] = string;
			}
		}

		Stack<String> s = new Stack<>();

//		for (int i = 0; i < parts.length; i++) {
		for (int i = 0; i < size; i++) {
			if (parts[i].equals(")")) {
				List<String> exp = new ArrayList<>();
				exp.add(parts[i]);

				String previous;
				do {
					previous = s.pop();
					exp.add(" " + previous);
				} while (!previous.equals("("));

				StringBuilder builder = new StringBuilder();
				for (int index=exp.size()-1; index>=0; index--) {
					builder.append(exp.get(index));
				}
				builder.deleteCharAt(0);
				builder.deleteCharAt(0);
				builder.deleteCharAt(0);
				builder.deleteCharAt(builder.length() - 1);

				s.push(evaluate(builder.toString()).toString());

			} else {
				s.push(parts[i]);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (String cur : s) {
			builder.append(cur + " ");
		}

		return builder.toString();
	}

	public static Double evaluate(String expression) {
		String[] parts = expression.split(" ");
		Stack<Double> s = new Stack<>();

		for (int i = 0; i < parts.length; i += 2) {
			if (i == 0 || parts[i - 1].equals("+")) {
				s.push(Double.valueOf(parts[i]));
			} else if (parts[i - 1].equals("-")) {
				s.push(-Double.valueOf(parts[i]));
			} else if (parts[i - 1].equals("*")) {
				s.push(s.pop() * Double.valueOf(parts[i]));
			} else if (parts[i - 1].equals("/")) {
				s.push(s.pop() / Double.valueOf(parts[i]));
			}
		}

		double r = 0.0;
		while (!s.isEmpty()) {
			r += s.pop();
		}
		// your code here
		return r;
	}

	public static void main(String[] args) {
//		double result = new MathEvaluator().calculate("12* 123/-(-5 + 2)");
		double result = new MathEvaluator().calculate("(1 - 2) + -(-(-(-4)))");
//		double result = new MathEvaluator().calculate("-123");
		System.out.println(result);
	}

}