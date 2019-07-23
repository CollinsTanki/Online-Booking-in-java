package KQ;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18M01ACS033
 */
public class DBConnection {
    //creae the connection strings
    String host="jdbc:mysql://localhost:3306/logina";
    String user="root";
     String pass="";
     //DECLARE CONNECTION
     DBConnection conn=null;
     
     //initialize the connection object
     
     public Connection getConnection(){
         try{
             Connection conn= DriverManager.getConnection(host, user, pass);
            JOptionPane.showMessageDialog(null, "connection successful");
             return conn;
         }
         catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
             return null;
         }
         }

public void insertuser(String FirstName,String Surname,String Adress,String Email ,String IdNo,String DeparturePoint,String Destination,String Accomodation,String TotalCharges) {
String q="INSERT into users(FirstName,Surname,Adress,Email,IdNo,DeparturePoint,Destination,Accomodation,TotalCharges) VALUES(?,?,?,?,?,?,?,?,?)";
int k=0;
try{
       PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,FirstName);
       st.setString(2,Surname);
       st.setString(3,Adress);
       st.setString(4,Email);
       st.setString(5,IdNo);
        //st.setString(6,Flight);
         //st.setString(7,Ticket);
         // st.setString(8,Adult);
          // st.setString(9,Child);
            st.setString(6,DeparturePoint);
             st.setString(7,Destination);
              st.setString(8,Accomodation);               
                st.setString(9,TotalCharges);
               
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,IdNo+"Customer booking Records Saved successful");
       }
           
       
   }
catch(SQLException e){
    JOptionPane.showMessageDialog(null, e.getMessage());
    
}

}
 public ResultSet getrecord(){
         String q="SELECT * FROM users";
         try{
             Statement st=getConnection().createStatement();
             ResultSet rs=st.executeQuery(q);
             return rs;
         }
         catch(SQLException ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
              return null;
         }
         }
     public void deletepatient(String IdNo){
         
        String q="DELETE FROM users WHERE IdNo=?";
        int k=0;
        try {
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,IdNo);
            if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,IdNo+" Customer Records Deleted Successfully");
        } 
        }
            
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
              }
    }
       public void Updatepatient(String FirstName,String Surname,String Adress,String Email ,String IdNo,String DeparturePoint,String Destination,String Accomodation,String TotalCharges){
    String q="UPDATE hospital SET FirstName=?,Surname=?,Adress=?,Email=?,DeparturePoint=?,Destination=? WHERE IdNo=?";
    int k=0;
    try{
       
        
    PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,FirstName);
       st.setString(2,Surname);
       st.setString(3,Adress);
       st.setString(4,Email);
       st.setString(6,DeparturePoint);
             st.setString(7,Destination);
              st.setString(8,Accomodation);               
                st.setString(9,TotalCharges);
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null, "Patient Record Updated Successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
    
    
}
}
    

