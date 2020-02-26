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
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

@RestController
public class HelloController {

    public static String getClaimNo() {

        //String url = "jdbc:postgresql://claim-db:5432/claimnumber";
        String url = "";
        String user = "user1";
        String password = "passord";
        String claimno = "poop";
        String query = "insert into claim_no_history (claim_no) values( ? )";

//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        String dbConfigPath = rootPath + "connection.properties";
//        try (InputStream input = new FileInputStream(dbConfigPath)) {
//
//            Properties prop = new Properties();
//
//            // load a properties file
//            prop.load(input);
//
//            // get the property value
//            url = prop.getProperty("URL");
//            user = prop.getProperty("Uname");
//            password = prop.getProperty("password");
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        Properties prop = getDBconnection();

        url = prop.getProperty("URL");
        user = prop.getProperty("Uname");
        password = prop.getProperty("password");

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst3 = con.prepareStatement("delete from claim_no_history where claim_no = 'crap'")) {

            pst3.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HelloController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst1 = con.prepareStatement("select concat ('Q-', cast(count(*)+1 as varchar),'-',translate (cast(current_date as varchar),'-','')) from claim_no_history where create_date > current_date");
                ResultSet rs1 = pst1.executeQuery()) {

            if (rs1.next()) {
                System.out.println(rs1.getString(1));
                claimno = rs1.getString(1);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HelloController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            claimno = url;
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

    public static Properties getDBconnection() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String dbConfigPath = rootPath + "connection.properties";
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(dbConfigPath)) {

            // load a properties file
            prop.load(input);

            // get the property value
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    public static String gethealth() {

        String healthdate = "Oh Hello!";

        return healthdate;
    }

    @RequestMapping("/")
    public String index() {
        String claimno;

        claimno = getClaimNo();

        return claimno;
    }

    @RequestMapping("/healthcheck")
    public String healthcheck() {

        String healthcheck = gethealth();

        return healthcheck;
    }

}
