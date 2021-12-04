package databaseops;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQL_JDBC {
    private static Connection c = null;
    public static void ConnectDatabase() throws ClassNotFoundException, SQLException {
        //Connection c = null;
        String url = "jdbc:postgresql://localhost:5432/test";
        String user = "postgres";
        String password = "megane4869";
        try{
            Class.forName("org.postgresql.Driver");
            /* To use psql in maven
             * Add file .jar manually, using F4 --> library
             * Using Maven:
             * We can add jdbc to project as a dependency
             * Add to pom.xml
             * <dependencies> add_dependency_here </dependencies>
             * Ref: https://www.enterprisedb.com/postgres-tutorials/how-add-postgresql-driver-dependency-maven
             */
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        finally {
            c.close();
        }
        System.out.println("Database connected successfully");
        //c.close();
    }

    public static void ExitDatabase() throws SQLException
    {
        c.close();
        System.out.println("Database disconnected!");
    }
}
