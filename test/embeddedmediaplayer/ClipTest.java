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
        System.out.println("testSetEndBeforeStartKeepsPreviousValue");
        
        clip1.setStart(5);
        clip1.setEnd(20);
        
        int endValueBefore = clip1.getEnd();
        
        clip1.setEnd(4); // set end value smaller than start value
        assertEquals(endValueBefore, clip1.getEnd());
        
        clip1.setEnd(0); // set end value 0 and test which is also smaller than start value
        assertEquals(endValueBefore, clip1.getEnd());
        
        clip1.setEnd(-10); // set end value in minus which is also smaller than start value
        assertEquals(endValueBefore, clip1.getEnd());
        
        clip1.setEnd(5); // set end value equal to start value
        assertEquals(5, clip1.getEnd());
        
        clip1.setEnd(20); // set end value equal to current end value
        assertEquals(20, clip1.getEnd());
        
        clip1.setEnd(40); // set end value larger than current end value
        assertEquals(40, clip1.getEnd());
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
