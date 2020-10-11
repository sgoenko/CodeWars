package calculator;
import java.sql.*;

	public class CalculatorJdbc {
	  // Replaced "try" with try-with-resource 
	  // Thanks user Slix!
	  public static Double evaluate(String expression) {
	    try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
	        Statement stat = conn.createStatement();) {

	      Class.forName("org.sqlite.JDBC");
	      ResultSet rs = stat.executeQuery("select " + expression + " amount");
	      rs.next();
	      return rs.getDouble(1);
	    } catch (Exception e) {
	      return 0.0;
	    }
	  }
	}