import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connection {
    public static void main(String args[])throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","6Neekosam@");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * from employees.workers;");
        while (rs.next()){
            System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4));
        }
        st.close();
        con.close();



    }
}
