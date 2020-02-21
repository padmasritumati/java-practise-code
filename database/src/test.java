import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class Test
{
    public static void main(String []args)
    {
        try{
//Loading driver
            Class.forName("com.mysql.jdbc.Driver");

//creating connection
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql:/ /localhost:3306/employees","root","6Neekosam@");

            Statement s = con.createStatement();	//creating statement

            ResultSet rs = s.executeQuery ("SELECT * FROM employees.workers WHERE Last_Name='singh';");	//executing statement

            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }

            con.close();	//closing connection
        }catch(Exception e){
            System.out.println(e);
        }
    }
}