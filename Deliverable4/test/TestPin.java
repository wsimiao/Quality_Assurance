
/**
 *
 * @author simiao
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;



public class TestPin {
    
    //Pinning Tests for Cell.toString
    //Ensure toString returns X when the cell is alive
    @Test
    public void testCellToStringAlive(){
        Cell newCell = new Cell(true);
        assertEquals(newCell.toString(), "X");
    }
    
    //Pining Tests for Cell.toString
    //Ensure toString returns . when the cell is dead
    @Test
    public void testCellToStringDead(){
        Cell newCell = new Cell(false);
        assertEquals(newCell.toString(), ".");
    }
    
    //Pinning Test for ConverToInt()
    //To ensure the returned value is 0 when passed 0
  @Test
  public void testConvertToInt() throws IllegalArgumentException, InvocationTargetException {
    Method method;
    try {
      Class[] argTypes = new Class[] { int.class };
      method = MainPanel.class.getDeclaredMethod("convertToInt", argTypes);
      method.setAccessible(true);
      MainPanel testPanel = new MainPanel(20);
      //invoke the convertToInt method
      Object returnValue = method.invoke(testPanel, 0);
      int result = ((Integer) returnValue).intValue();
      assertEquals(0, result);  
    } catch (NoSuchMethodException e) {
        fail(e.getMessage());
    } catch (InvocationTargetException e) {
        fail(e.getMessage());
    } catch (IllegalAccessException e) {
        fail(e.getMessage());
    }
  }
 
  @Test
  public void testConvertToIntPositive() throws IllegalArgumentException, InvocationTargetException {
    Method method;
    try {
      Class[] argTypes = new Class[] { int.class };
      method = MainPanel.class.getDeclaredMethod("convertToInt", argTypes);
      method.setAccessible(true);
      MainPanel testPanel = new MainPanel(20);
      //invoke the convertToInt method
      Object returnValue = method.invoke(testPanel, 20);
      int result = ((Integer) returnValue).intValue();
      assertEquals(20, result);  
    } catch (NoSuchMethodException e) {
        fail(e.getMessage());
    } catch (InvocationTargetException e) {
        fail(e.getMessage());
    } catch (IllegalAccessException e) {
        fail(e.getMessage());
    }
  }

  @Test
  public void testConvertToIntNegative() throws IllegalArgumentException, InvocationTargetException {
    Method method;
    try {
      Class[] argTypes = new Class[] { int.class };
      method = MainPanel.class.getDeclaredMethod("convertToInt", argTypes);
      method.setAccessible(true);
      MainPanel testPanel = new MainPanel(20);
      //invoke the convertToInt method
      Object returnValue = method.invoke(testPanel, -20);
      int result = ((Integer) returnValue).intValue();
      assertEquals(-20, result);  
      //fail("Function fails to account for negative number");
    } catch (NoSuchMethodException e) {
        fail(e.getMessage());
    } catch (InvocationTargetException e) {
        fail(e.getMessage());
    } catch (IllegalAccessException e) {
        fail(e.getMessage());
    }
  }
  
  //******************************
  //Tests for MainPanel.runContinuous() were performed manually
    
    
}
