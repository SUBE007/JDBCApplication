import java.sql.*;
import java.io.*;
import java.util.Scanner;
class SelectTest3 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Character :");

		String name=sc.next();
		name ="'"+name+ "%'";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
          Statement st=con.createStatement();

		   
          String query="SELECT * FROM BANKINFO WHERE NAME LIKE"+name;
             System.out.print(query);
		   ResultSet rs=st.executeQuery(query);

		  boolean flag=false;
		  while(rs.next()!=false)
		{
			  flag=true;
                   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
		}
		if(flag==false)
		{
               
            System.out.print("No record is Found");
		}

		rs.close();
		st.close();
		con.close();

	}
}

