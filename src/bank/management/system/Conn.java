package bank.management.system;
import java.sql.*;

public class Conn {
    public PreparedStatement statement;
    Connection cn;
    Statement stmt;

    public Conn() {
        try {
            // Load MySQL driver (optional in modern JDBC but still good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem",
                    "root",
                    "Tanishk@10"
            );
            stmt = cn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
