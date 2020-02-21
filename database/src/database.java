import java.sql.*;

public class database {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:sql://localhost:3306/employees", "root", "6Neekosam@");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees.workers");
            rs.next();
            System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
            st.close();
            con.close();


    }
}