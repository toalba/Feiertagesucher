import java.sql.*;
import java.util.HashMap;

public class Mariadb {
    // JDBC driver name and database URL
    private String driver;
    private String host;
    private String user;
    private String password;
    private Connection conn;

    public Mariadb() throws ClassNotFoundException {
        this.driver = "org.mariadb.jdbc.Driver";
        this.host = "jdbc:mariadb://localhost:3306/javafeiertage";
        this.user = "root";
        this.password = "";
        Class.forName(this.driver);
        try {
            this.conn = DriverManager.getConnection(this.host, this.user, this.password);
            System.out.println("Conn established");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    public void Inserttodb(String statement)
    {
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(statement);
            System.out.println("SQL executed: '"+statement+"'");
        }
        catch (SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
    public HashMap<String,Integer> getData()
    {
        HashMap<String,Integer> data = new HashMap<String,Integer>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from feiertage");

            while(rs.next())
            {
                data.put("Montag",rs.getInt("Montag"));
                data.put("Dienstag",rs.getInt("Dienstag"));
                data.put("Mittwoch",rs.getInt("Mittwoch"));
                data.put("Donnerstag",rs.getInt("Donnerstag"));
                data.put("Freitag",rs.getInt("Montag"));
            }
            rs.close();
            return data;
        }
        catch (SQLException se)
        {

        }
        return  data;
    }


}

