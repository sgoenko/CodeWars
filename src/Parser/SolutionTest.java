package Parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class SolutionTest {
  
  @Test
  public void fixedTests() {
      System.out.println(Parser.parseInt("one million"));
      assertEquals(1000000 , Parser.parseInt("one million"));

      System.out.println(Parser.parseInt("twenty"));
      assertEquals(20 , Parser.parseInt("twenty"));

      System.out.println(Parser.parseInt("two hundred forty-six"));
      assertEquals(246 , Parser.parseInt("two hundred forty-six"));

      System.out.println(Parser.parseInt("three thousand two hundred forty-six"));
      assertEquals(3246 , Parser.parseInt("three thousand two hundred forty-six"));
  }
}