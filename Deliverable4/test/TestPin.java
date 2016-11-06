
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
    //Pining Test for Cell.toString
    //Ensure toString returns
    //Ensure ToString returns "X" with multiple Cells
  @Test
  public void testCellToStringMultiple() {
    Cell[][] newCell = new Cell[5][5];
    for (int i=0; i < 5; i++){
      for (int k=0; k<5; k++){
        newCell[i][k]= new Cell();
        newCell[i][k].setText(" ");
      }
    }
    newCell[2][2].setText("X");
    assertEquals(newCell[2][2].toString(),"X");
    assertEquals(newCell[1][2].toString(), ".");
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
  
  //To test the refactor of convertToInt has no effects on getNumNeighbors
  //initialize the cell[][] manually as all dead
  //get the number of neighbors for position(3,4)
  //The result shoulb be 0
  @Test
  public void testGetNumNeighbor() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      Method method = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
      method.setAccessible(true);
      MainPanel panel = new MainPanel(20);
      int returnNum = (int) method.invoke(panel, 3, 4);
      assertEquals(0, returnNum);
  }
  
  //******************************
  //Tests for MainPanel.runContinuous() were performed manually
    
    
}
