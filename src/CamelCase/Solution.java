package CamelCase;
import java.util.Stack;

class Solution{

  public static String toCamelCase(String s){
	  String[] camel = s.split("[_-]");
	  for (int i=1; i<camel.length; i++) {
		  camel[i] = camel[i].substring(0, 1).toUpperCase() + camel[i].substring(1);
	  }
	  return String.join("", camel);
  }
  
  public static String whoLikesIt(String... names) {
      if (names.length == 0)
    	  return "no one likes this";
      if (names.length == 1)
    	  return String.format("%s likes this", names[0]); 
      if (names.length == 2)
    	  return String.format("%s and %s like this", names[0], names[1]); 
      if (names.length == 3)
    	  return String.format("%s, %s and %s like this", names[0], names[1], names[2]); 

      return String.format("%s, %s and %d others like this", names[0], names[1], names.length -2); 
  }
/*
  public static boolean isValid(String braces) {
	  char[] br1 = {'(', ')'};
	  char[] br2 = {'{', '}'};
	  char[] br3 = {'[', ']'};
	  int next;
	  try {
	  for (int i = 0; i<braces.length(); i++ ) {
		  char cur = braces.charAt(i);
		  if (cur == br1[0]) {
			  if(braces.charAt(i+1) == cur)
				  next = braces.lastIndexOf(br1[1]);
			  else
				  next = braces.indexOf(br1[1]);
			  if ( (next == -1) || (next-i>1) && !isValid(braces.substring(i+1, next))) {
				  return false;
			  }
			  i = next;
		  }
		  else if (cur == br2[0]) {
			  if(braces.charAt(i+1) == cur)
				  next = braces.lastIndexOf(br2[1]);
			  else
				  next = braces.indexOf(br2[1]);
			  if ((next == -1) || (next-i>1) && !isValid(braces.substring(i+1, next))) {
				  return false;
			  }
			  i = next;
		  }
		  else if (cur == br3[0]) {
			  if(braces.charAt(i+1) == cur)
				  next = braces.lastIndexOf(br3[1]);
			  else
				  next = braces.indexOf(br3[1]);
			  if ((next == -1) || (next-i>1) && !isValid(braces.substring(i+1, next))) {
				  return false;
			  }
			  i = next;
		  }
		  else
			  return false;
	  }
	  return true;
	  }
	  catch(Exception e) {
		  return false;
	  }
  }
 */ 
  
  public static boolean isValid(String braces) {
	    Stack<Character> s = new Stack<>();
	    for (char c : braces.toCharArray()) 
	      if (s.size() > 0 && isClosing(s.peek(), c)) s.pop(); 
	      else s.push(c);
	    return s.size() == 0;
	  }
	  
  public static boolean isClosing(char x, char c) {
	    return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
  }
	  
  public static void main(String[] args) {
	  String s;
	  s="[(])";
	  System.out.println(isValid(s));
	  s="()";
	  System.out.println(isValid(s));
	  s="[]";
	  System.out.println(isValid(s));
	  s="{}";
	  System.out.println(isValid(s));
	  s="(){}[]";
	  System.out.println(isValid(s));
	  s="([{}])";
	  System.out.println(isValid(s));
	  s="[{}]";
	  System.out.println(isValid(s));
	  s="{}";
	  System.out.println(isValid(s));
	  s="({})[({})]";
	  System.out.println(isValid(s));
	  s="{}";
	  System.out.println(isValid(s));
	  s="({})";
	  System.out.println(isValid(s));
	  s="{}";
	  System.out.println(isValid(s));
	  s="(({{[[]]}}))";
	  System.out.println(isValid(s));
	  s="({{[[]]}})";	  
	  System.out.println(isValid(s));
  }
}
