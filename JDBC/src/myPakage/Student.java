package myPakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Student {
   public void createDatabase()
    {
       try{
        String url="jdbc:mysql://localhost:3306/";
        // String db="db";
        String userName="root";
        String password="Suryansh@13";
        Connection conn=DriverManager.getConnection(url,userName,password);
       
        Statement stm=conn.createStatement();
        String query ="create database db"; 
       
        
       stm.execute(query); 
       System.out.println("Database created Successfully ");
       conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void createTable(){
     try{
        String url="jdbc:mysql://localhost:3306/";
        String db="db";
        String userName="root";
        String password="Suryansh@13";
        Connection conn=DriverManager.getConnection(url+db,userName,password);
       
        Statement stm=conn.createStatement();
        String query ="create table student (sid int(3),sname varchar(200),semail varchar(200))"; 
       
        
       stm.execute(query); 
       System.out.println("Table created Successfully ");
       conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void createData(){
try{
        String url="jdbc:mysql://localhost:3306/";
        String db="db";
        String userName="root";
        String password="Suryansh@13";
        Connection conn=DriverManager.getConnection(url+db,userName,password);
       
       
        String query ="INSERT into student (sid,sname,semail) VALUES(?,?,?)"; 
        PreparedStatement pstm=conn.prepareStatement(query);
        pstm.setInt(1, 12);
        pstm.setString(2,"Boom" );
        pstm.setString(3, "boom15@gamil.com");
       pstm.executeUpdate(); 
       System.out.println("Inserted Successfully ");
       conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void readData(){
    try{
        String url="jdbc:mysql://localhost:3306/";
        String db="db";
        String userName="root";
        String password="Suryansh@13";
        Connection conn=DriverManager.getConnection(url+db,userName,password);
       
       
        String query ="select * from student"; 
        Statement stm=conn.createStatement();
        ResultSet rs= stm.executeQuery(query);
       while(rs.next()){
        System.out.println("id = "+rs.getInt(1));
        System.out.println("name = "+rs.getString(2));
        System.out.println("email = "+rs.getString(3));
       
       }
       System.out.println("Read Successfully ");
       conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void updateData(){
    try{
        String url="jdbc:mysql://localhost:3306/";
        String db="db";
        String userName="root";
        String password="Suryansh@13";
        Connection conn=DriverManager.getConnection(url+db,userName,password);
       
       
        String query ="Update student set sid=? where sname=?"; 
        PreparedStatement pstm=conn.prepareStatement(query);
        pstm.setInt(1, 9);
        pstm.setString(2,"Suryansh Gupta" );
       
       pstm.execute(); 
       System.out.println("Data updated Successfully ");
       conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void deleteData() {
    try{
        String url="jdbc:mysql://localhost:3306/";
        String db="db";
        String userName="root";
        String password="Suryansh@13";
        Connection conn=DriverManager.getConnection(url+db,userName,password);
       
       
        String query ="DELETE from  student where sid=?"; 
        PreparedStatement pstm=conn.prepareStatement(query);
        pstm.setInt(1,9 );
       
       pstm.executeUpdate(); 
       System.out.println("Data deleted Successfully ");
       conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
