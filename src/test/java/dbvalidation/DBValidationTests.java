package dbvalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class DBValidationTests {

    @Test
    public void testUserCount() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users");

        rs.next();
        int count = rs.getInt(1);

        Assert.assertTrue(count > 0, "User count should be greater than 0");

        conn.close();
    }
}

