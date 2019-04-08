/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddedmediaplayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author comqsjb
 */
public class ClipTest {
    
    private static Clip clip1 = new Clip();
    private static Clip clip2 = new Clip();
    
    public ClipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Clip.
     */
    @Test
    public void testSetTitleToEmptyStringKeepsPreviousValue()
    {
        System.out.println("testSetTitleToEmptyStringKeepsPreviousValue");
        
        String title = "Sub Clip 1";

        clip1.setTitle(title);
        
        clip1.setTitle(null); // test for null title
        assertEquals(title, clip1.getTitle());
        
        clip1.setTitle(""); // test for title with empty String
        assertEquals(title, clip1.getTitle());
        

        String notEmptyTitle = "New Title for Sub Clip 1";
        clip1.setTitle(notEmptyTitle); // test for actual title which will be changed
        assertEquals(notEmptyTitle, clip1.getTitle());
    }

    @Test
    public void testSetEndBeforeStartKeepsPreviousValue()
    {
    }

    @Test
    public void testEqualsOnEqualClips() 
    {
    }
    
    @Test
    public void testEqualsOnNonEqualClips() 
    {
    }
    
    @Test
    public void testSetEndToNegativeNumberKeepsPreviousValue() 
    {
    }
    
    @Test
    public void testSetStartToValidPositiveNumber() 
    {    
    }
    
    
    
}
