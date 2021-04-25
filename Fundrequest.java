/**
 * 
 */
package fund_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBHandler;

/**
 * @author Asus
 *
 */
@SuppressWarnings("unused")
public class Fundrequest {
	
	//insert
	public String insertFundReq(String rName, String fundingC, String project, 
			String email, String Phone, String address, String AccNo) 
	{
		
		 String output = "";
		
		 try
		 {  
			 Connection con = DBHandler.connect();
		 
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting."; 
			 }
			 
			 //checking for empty inserts
			 if(rName == null)
			 {
				 return "Feild empty ";
			 }
			 else if(fundingC == null)
			 {
				 return "Feild empty ";
			 }
			 else if(project == null)
			 {
				 return "Feild empty ";
			 }
			 else if(email == null)
			 {
				 return "Feild empty ";
			 }
			 else if(Phone == null)
			 {
				 return "Feild empty ";
			 }
			 else if(address == null)
			 {
				 return "Feild empty ";
			 }
			 else if(AccNo == null)
			 {
				 return "Feild empty ";
			 }
		 
			 // create a prepared statement		 
			 String query = " insert into FundReq(rName, fundingC, project, email, Phone, address, AccNo)";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, rName);
			 preparedStmt.setString(3, fundingC);
			 preparedStmt.setString(4, project);
			 preparedStmt.setString(5, email);
			 preparedStmt.setString(6, Phone);
			 preparedStmt.setString(7, address);
			 preparedStmt.setString(8, AccNo);
		 
			 preparedStmt.execute();
			 con.close();
			 output = "Inserted successfully";
		 }
		 catch (Exception e)
		 {
			 output = "Error while inserting the payment.";
			 System.err.println(e.getMessage());	
		 }
		 	 return output;
		 }
	
	//read
	public String readFundReq()
    {	 
	 String output = "";
	 
	 try
	 {
	
		 Connection con = DBHandler.connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for reading."; 
		 }
		 // Prepare the html table to be displayed
	 
		 output = "<table border=\"1\"><tr><th>Resercher's Name</th><th>Fnding Cmpany</th><th>Project Name</th><th>Email</th><th>Phone</th>"
	 		+ "<th>Address</th><th>Account No</th></tr>";
	 
		 String query = "select * from Fund_Pay";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
	 
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
			 String rname = rs.getString("ResercherName");
			 String fundingC = rs.getString("FundingCompany");
			 String project = rs.getString("ProjectName");
			 String email = rs.getString("Email");
			 String Phone = rs.getString("Phone");
			 String address = rs.getString("Address");
			 String AccNO = rs.getString("AccountNO");
	  
			 // Add into the html table
			 output += "<tr><td>" + rname + "</td>";
			 output += "<td>" + fundingC + "</td>";
			 output += "<td>" + project + "</td>";
			 output += "<td>" + email + "</td>";
			 output += "<td>" + Phone + "</td>";
			 output += "<td>" + address + "</td>";
			 output += "<td>" + AccNO + "</td>";
	 
		 }
	 
		 con.close();
		 // Complete the html table
		 output += "</table>";
	 }
	 catch (Exception e)
	 {
		 output = "Error while reading the payment.";
		 System.err.println(e.getMessage());
	 }
	 	return output; 
     }
	
	//Update
	public String updateFundReqString (String rName, String fundingC, String project, 
	String email, String Phone, String address, String AccNo)
	{
		
	 String output = "";
	 
	 try
	 {
		 Connection con = DBHandler.connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for updating."; 
		 }
		 
		//check if the feilds are null
		 if(rName == null)
		 {
			 return "Feild empty ";
		 }
		 else if(fundingC == null)
		 {
			 return "Feild empty ";
		 }
		 else if(project == null)
		 {
			 return "Feild empty ";
		 }
		 else if(email == null)
		 {
			 return "Feild empty ";
		 }
		 else if(Phone == null)
		 {
			 return "Feild empty ";
		 }
		 else if(address == null)
		 {
			 return "Feild empty ";
		 }
		 else if(AccNo == null)
		 {
			 return "Feild empty ";
		 }
	 
		 
		 // create a prepared statement
		 String query = "UPDATE FundReq SET rName=?,fundingC=?,project=?,email=?,Phone=?,address=?,AccNo=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
	 
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, rName);
		 preparedStmt.setString(3, fundingC);
		 preparedStmt.setString(4, project);
		 preparedStmt.setString(5, email);
		 preparedStmt.setString(6, Phone);
		 preparedStmt.setString(7, address);
		 preparedStmt.setString(8, AccNo);
		 
		 
	 
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
		 output = "Error while updating the Funding Request.";
		 System.err.println(e.getMessage());
	 }
	 	return output;
	 }
	
	//Delete
	public String deleteFundReq(String UserID)
	{
		
	 String output = "";
	 
	 try
	 {
		 
		 Connection con = DBHandler.connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for deleting."; 
		 }
		 
		 //Check payID is null 
		 if(UserID == null)
		 {
			 return "UserID cannot be null";
		 }
		 
		 // create a prepared statement
		 String query = "delete from funding request list where UserID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, UserID);
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
		 output = "Error while deleting the Funding Request.";
		 System.err.println(e.getMessage());
	 }
	 	return output;
	 } 

}

