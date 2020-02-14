package com.mattservice.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HelloController {

    public static String getClaimNo(){
        
        String url = "jdbc:postgresql://claim-db.claim-dev:5432/claimnumber";
        String user = "user1";
        String password = "passord";
        String claimno = "poop";
        String query = "insert into claim_no_history (claim_no) values( ? )";
//        Connection c = null;
//      try {
//         Class.forName("org.postgresql.Driver");
//         c = DriverManager
//            .getConnection("jdbc:postgresql://localhost:5432/claimnumber",
//            "user1", "passord");
//      } catch (Exception e) {
//         e.printStackTrace();
//         System.err.println(e.getClass().getName()+": "+e.getMessage());
//         System.exit(0);
//      }
//      System.out.println("Opened database successfully");
   
  
         try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst3 = con.prepareStatement("delete from claim_no_history where claim_no = 'crap'")) {
            
            pst3.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HelloController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }  

        
         try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst1 = con.prepareStatement("select concat ('Z-', cast(count(*)+1 as varchar),'-',translate (cast(current_date as varchar),'-','')) from claim_no_history where create_date > current_date");
                ResultSet rs1 = pst1.executeQuery()) {

            if (rs1.next()) {
                System.out.println(rs1.getString(1));
                claimno = rs1.getString(1);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HelloController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            claimno = "crap1";
        }
     
         try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst2 = con.prepareStatement(query)) {
            
            
            pst2.setString(1, claimno);
            pst2.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HelloController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
         
         
       
         
     return claimno;
    }
    
    @RequestMapping("/")
    public String index() {
        String claimno;
        
        claimno = getClaimNo();
        
        return claimno;
    }

}
