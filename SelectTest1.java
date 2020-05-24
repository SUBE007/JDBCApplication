import java.sql.*;
import java.io.*;
import java.util.Scanner;
public class  SelectTest1
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the city name:");

		String city=sc.nextLine();
		city="'"+city+"'";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection("jdbc:oracl:thin:@localhost:1521:orcl","scott","tiger");

		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM BANK WHERE ADDRS="+city);

           int count=0;
		while(rs.next()!=false)
		{
			count++;
          System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getFloat(3)+"  "+rs.getString(4));   
		}

		if(count==0)
		{
			System.out.print("No Record Found which you entered try Again::");

		}
           rs.close();
		   st.close();
		   con.close();

	}//main();;
}//class ;;;
