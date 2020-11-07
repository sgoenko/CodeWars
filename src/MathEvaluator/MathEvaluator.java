package MathEvaluator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathEvaluator {

	private final Pattern brackets = Pattern.compile("(-?)\\(([^()]+)\\)");
	private final Pattern[] operations = {
				Pattern.compile("(-?[0-9.]+)\\s*(/|\\*)\\s*(-?[0-9.]+)"),
				Pattern.compile("(-?[0-9.]+)\\s*(\\+|-)\\s*(-?[0-9.]+)")
	};

	public double calculate(String expression) {
		Matcher m;
		while ((m = brackets.matcher(expression)).find()) {
			String eval = calculateWithoutBrackets(m.group(2));
			if (!m.group(1).isEmpty())
				eval = negotiateExpression(eval);
			expression = replaceEvaluatedPart(expression, m, eval);
		}
		return Double.parseDouble(calculateWithoutBrackets(expression));
	}

	private String calculateWithoutBrackets(String expression) {
		Matcher m;

		for (int priority = 0; priority < 2; priority++) {
			while ((m = operations[priority].matcher(expression)).find()) {
				String eval = "" + parseAndEvaluateOperation(m, priority);
				expression = replaceEvaluatedPart(expression, m, eval);
			}
		}
		return expression;
	}

	private String replaceEvaluatedPart(String expression, Matcher m, String eval) {
		return expression.substring(0, m.start()) + eval + expression.substring(m.end());
	}

	private String negotiateExpression(String eval) {
		return eval.startsWith("-") ? eval.substring(1) : "-" + eval;
	}

	private double parseAndEvaluateOperation(Matcher m, int priority) {
		double x = Double.parseDouble(m.group(1));
		double y = Double.parseDouble(m.group(3));

		double result = 0;
		if (priority == 0) {
			result = m.group(2).equals("*") ? x * y : x / y;
		} else if (priority == 1) {
			result = m.group(2).equals("+") ? x + y : x - y;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new MathEvaluator().calculate("(4 ) - 2 / (2 + -3) * 4.33 - -6"));
	}

}
