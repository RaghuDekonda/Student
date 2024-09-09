package Student;

import java.sql.*;
import java.util.*;

public class mysqlCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter pin no:");
		int nu =sc.nextInt();
		System.out.print("Enter name:");
		String name =sc.next();
		System.out.print("Enter branch:");
		String branch =sc.next();
		System.out.print("Enter gender:");
		String gender =sc.next();
		System.out.print("Enter number:");
		String no=sc.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","R@ghu0123");
			
			System.out.println("Inserting Records");
			String sql="Insert into  student_details(std_id,std_name,std_branch,std_gender,std_number) values (?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,nu);
			stmt.setString(2, name);
			stmt.setString(3, branch);
			stmt.setString(4, gender);
			stmt.setString(5, no);
			stmt.execute();
			ResultSet r=stmt.executeQuery("select * from student_details") ;
			while(r.next()) {
				System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5));
						}con.close();
		}
		catch(Exception e){
	System.out.println(e);
		}
		sc.close();
	}

}
