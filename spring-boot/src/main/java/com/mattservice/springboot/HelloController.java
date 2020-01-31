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
                PreparedStatement pst = con.prepareStatement("SELECT VERSION()");
                ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
                claimno = rs.getString(1);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HelloController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            claimno = "crap";
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
