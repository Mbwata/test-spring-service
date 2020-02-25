/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mattservice.springboot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matthouse
 */
public class HelloControllerTest {
    
    public HelloControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getClaimNo method, of class HelloController.
     */
//    @Test
//    public void testGetClaimNo() {
//        System.out.println("getClaimNo");
//        String url = "jdbc:postgresql://claim-db.claim-dev:5432/claimnumber";
//        String user = "user1";
//        String password = "passord";
//        String expResult = "fail";
//        try (Connection con = DriverManager.getConnection(url, user, password);
//                PreparedStatement pst1 = con.prepareStatement("select concat ('Z-', cast(count(*)+1 as varchar),'-',translate (cast(current_date as varchar),'-','')) from claim_no_history where create_date > current_date");
//                ResultSet rs1 = pst1.executeQuery()) {

//            if (rs1.next()) {
//                System.out.println(rs1.getString(1));
//                expResult = rs1.getString(1);
//            }

//        } catch (SQLException ex) {

//            Logger lgr = Logger.getLogger(HelloController.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//            expResult = "sql Error";
//        }
        
//        String result = HelloController.getClaimNo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of index method, of class HelloController.
     */
//    @Test
//    public void testIndex() {
//        System.out.println("index");
//        HelloController instance = new HelloController();
//        String expResult = "";
//        String result = instance.index();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
