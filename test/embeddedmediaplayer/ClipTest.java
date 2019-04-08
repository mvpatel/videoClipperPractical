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
    
    private static Clip clip1;
    private static Clip clip2;
    
    String commonTitle = "Clip Title";
    int commonClipStart = 5; // common start for this test
    int commonClipEnd = 20; // common end for this test
    
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
        clip1 = new Clip();
        clip2 = new Clip();
        
        // setting common values for properties of clip1 
        clip1.setTitle(commonTitle);
        clip1.setStart(commonClipStart);
        clip1.setEnd(commonClipEnd);
        
        // setting common values for properties of clip2 which excatly same as clip1
        clip2.setTitle(commonTitle);
        clip2.setStart(commonClipStart);
        clip2.setEnd(commonClipEnd);
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
        
        int endValueBefore = clip1.getEnd();
        
        clip1.setEnd(4); // set end value smaller than start value
        assertEquals(endValueBefore, clip1.getEnd());
        
        clip1.setEnd(0); // set end value 0 and test which is also smaller than start value
        assertEquals(endValueBefore, clip1.getEnd());
        
        clip1.setEnd(-10); // set end value in minus which is also smaller than start value
        assertEquals(endValueBefore, clip1.getEnd());
        
        // following added extra tests for good coverage
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
        System.out.println("testEqualsOnEqualClips");
        
        // test for exectly same values for both clips
        assertEquals(true, clip1.equals(clip2));
        
        clip1.setTitle("");
        clip2.setTitle("");
        assertEquals(true, clip1.equals(clip2));
        
        clip1.setStart(0);
        clip2.setStart(0);
        assertEquals(true, clip1.equals(clip2));
        
        
        clip1.setEnd(0);
        clip2.setEnd(0);
        assertEquals(true, clip1.equals(clip2));
        
                
        // make a clip2 null and test
        clip2 = null;
        assertEquals(false, clip1.equals(clip2));

    }
    
    @Test
    public void testEqualsOnNonEqualClips() 
    {
        System.out.println("testEqualsOnNonEqualClips");
        
        // change the title in clip2 and test
        clip2.setTitle("Clip Title new");
        assertEquals(false, clip1.equals(clip2));
        
        // change title back to common value and change the start for test
        clip2.setTitle(commonTitle);
        clip2.setStart(10);
        assertEquals(false, clip1.equals(clip2));

        // change start back to common value and change end value for test
        clip2.setStart(commonClipStart);
        clip2.setEnd(30);
        assertEquals(false, clip1.equals(clip2));
        
        // make a clip2 null and test
        clip2 = null;
        assertEquals(false, clip1.equals(clip2));
    }
    
    @Test
    public void testSetEndToNegativeNumberKeepsPreviousValue() 
    {
        // there is a problem on method name that's why 1 is added in the end
        System.out.println("testSetEndToNegativeNumberKeepsPreviousValue");
        
        int endValueBefore = clip1.getEnd();
        
        
        clip1.setEnd(-10);
        assertEquals(endValueBefore, clip1.getEnd());
        
        clip1.setEnd(0);
        assertEquals(endValueBefore, clip1.getEnd());
    }
    
    @Test
    public void testSetStartToValidPositiveNumber() 
    { 
        // there is a problem on method name that's why 1 is added in the end
        System.out.println("testSetEndBeforeStartKeepsPreviousValue1");
        
        int startValueBefore = clip1.getStart();
        
                
        clip1.setStart(40);
        assertEquals(startValueBefore, clip1.getStart());
        
        clip1.setStart(4);
        assertEquals(4, clip1.getStart());
        
        clip1.setStart(0);
        assertEquals(0, clip1.getStart());
       
        
        clip1.setStart(20);
        assertEquals(20, clip1.getStart());

    }
    @Test
    public void testGetUpperCase() 
    {
        
    System.out.println("testGetUpperCase");
    
      String lowerCaseString = "Clip 1";
      assertEquals(lowerCaseString.toUpperCase(), clip1.getUpperCase(lowerCaseString));
      
      lowerCaseString = "";
      assertEquals(lowerCaseString.toUpperCase(), clip1.getUpperCase(lowerCaseString)); 

    }
    
    @Test
    public void testGetTimeInSecondsBack() {
    
        System.out.println("testGetTimeInSecondsBack");
        
        int currentSeconds = 50;
        int minusFromCurrentSeconds = 1;
        
        assertEquals(currentSeconds - minusFromCurrentSeconds, clip1.getTimeInSecondsBack(currentSeconds, minusFromCurrentSeconds));
        
        minusFromCurrentSeconds = 0;
        assertEquals(currentSeconds, clip1.getTimeInSecondsBack(currentSeconds, minusFromCurrentSeconds));
        
        minusFromCurrentSeconds = 51;
        assertEquals(currentSeconds, clip1.getTimeInSecondsBack(currentSeconds, minusFromCurrentSeconds));
        
        minusFromCurrentSeconds = 100;
        assertEquals(currentSeconds, clip1.getTimeInSecondsBack(currentSeconds, minusFromCurrentSeconds));
    }
    
    
    
}
