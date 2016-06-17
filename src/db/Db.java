package db;

import gui.*;
import hr.*;
import inventory.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Db {
    
        //declare variables
        Connection conn = null;
        ResultSet res = null;
        PreparedStatement prepStat = null;
        String sql = null;
        Statement stat = null;
        
        public Db(){
        try
            {
            try {               
                Class.forName("com.mysql.jdbc.Driver");
               
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                //db connection
                conn = DriverManager.getConnection("jdbc:mysql://sql.computerstudi.es:3306/gc200303856", "gc200303856", "hXYG-a^6");
                stat = conn.createStatement();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage() + " - " +e.getSQLState() + " - " +e.getErrorCode());                
            }
        }
        
        public ResultSet populateEmployeeDropdown(){
            try{
                prepStat = conn.prepareStatement("select firstName, lastName from employees");
                res = prepStat.executeQuery();
            
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            System.out.println(res);
            return res;
        }
        
        public ResultSet populateProductDropdown(){
            try{
                prepStat = conn.prepareStatement("select name from product");
                res = prepStat.executeQuery();            

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            System.out.println(res);
            return res;
        }
        
                //find resultset 
                public ResultSet find(String table,String colName, String parameter){
                    try{
                        prepStat = conn.prepareStatement("select * from " + table + " where " + colName + "= ?");
                        System.out.println("select * from " + table + " where " + colName + "= ?");
                        prepStat.setString(1, parameter);
                        res = prepStat.executeQuery();
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    return res;
                }
                //add employee
                public void add(CommissionSalesEmployee emp){

                    //try catch for invalid inputs
                    try{
                        if(emp.getAge() > 80 || emp.getAge() <= 15 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter valid age from 16 - 80!");
                            conn.abort(null);
                        }
                        
                        if(emp.getCommissionRate() > 1.0 || emp.getCommissionRate() <= 0.0)
                        {
                            JOptionPane.showMessageDialog(null, "Please enter Commission Rate from range 0.1 - 1.0!");
                        }
                        //else insert in to database
                        else
                        {

                        sql = "INSERT INTO `gc200303856`.`employees` (`firstName`, `lastName`, `age`, `position`, `year`, `month`, `day`, `sales`, `comRate`) VALUES ('"
                                + emp.getFirstName() + "', '" + emp.getLastName() + "', '" + emp.getAge() + "', '"+ emp.getPosition() 
                                + "', '" + emp.getHireYear() + "', '" + emp.getHireMonth() + "', '" + emp.getHireDay() 
                                + "', '" + emp.getGrossSales() + "', '" + emp.getCommissionRate() + "')";
                        System.out.println(sql);
                        stat.executeUpdate(sql);
                        
                        JOptionPane.showMessageDialog(null, "The employee has been successfully saved! :)");
                        }
                    }
                    catch(SQLException sql_e){
                        JOptionPane.showMessageDialog(null,sql_e.getMessage());
                    }
                }

                //add product method
                public void add(Product p){
                    //try for invalid input 
                    try{
                        if(p.getProductCost() <= 0 )
                        {
                            JOptionPane.showMessageDialog(null,"Please enter a valid positive non-zero value for Product Cost!");
                            conn.abort(null);
                        }
                        if(p.getProductPrice() <= 0 )
                        {
                            JOptionPane.showMessageDialog(null,"Please enter a valid positive non-zero value for Product Price!");
                        }
                        else
                        {
                        //else insert in to database
                        sql="INSERT INTO `gc200303856`.`product` (`name`, `category`, `manufacturer`, `description`, `partNum`, `productCost`, `productPrice`, `productMarkup`) "
                                + "VALUES ('" + p.getProductName()+ "', '" + p.getCategory() + "', '" + p.getManufacturer() + "', '" + p.getDescription()
                                + "', '" + p.getPartNum()+ "', '" + p.getProductCost() + "', '" + p.getProductPrice() + "', '" + p.getProductMarkup() + "')";
                        System.out.println(sql);
                        stat.executeUpdate(sql);
                        
                        JOptionPane.showMessageDialog(null, "The product has been successfully saved! :)");
                        }
                    }
                    catch(SQLException sql_ex){
                        JOptionPane.showMessageDialog(null,sql_ex.getMessage());
                    }

                }
        }