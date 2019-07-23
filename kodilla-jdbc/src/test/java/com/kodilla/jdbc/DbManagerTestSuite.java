package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnection() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUser() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ". " + rs.getString("FIRSTNAME") + ", "
                    + rs.getString("LASTNAME"));
            counter++;
        }

        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT US.FIRSTNAME, US.LASTNAME, COUNT(*) AS ISSUES_NUMBER\n" +
                "FROM USERS US JOIN ISSUES ISS ON US.ID = ISS.ISSUESLIST_ID\n" +
                "GROUP BY ISS.ISSUESLIST_ID\n" +
                "HAVING COUNT(*) > 1\n" +
                "ORDER BY US.LASTNAME, US.FIRSTNAME;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME") + " - "
                    + rs.getInt("ISSUES_NUMBER") + " posts.");
            counter++;
        }

        rs.close();
        statement.close();
        Assert.assertEquals(2, counter);
    }
}
