 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;

 public class BoardSpace extends JButton
 {
   private JLabel test = new JLabel();
  // name of button
 	private String buttonName;
  private int nameNum;
  private char nameChar;
  // images for hit, miss, and water
 	private ImageIcon water = new ImageIcon("images/water-scaled.jpg");
 	private ImageIcon explosion = new ImageIcon("images/boom-scaled.jpg");
 	private ImageIcon miss = new ImageIcon("images/x-scaled.jpg");
  // ship space
 	private boolean ship = false;
  private ImageIcon placedShip = new ImageIcon("images/placedship.jpg");
 	private boolean hit = false;

 	public BoardSpace()
  {
    add(test);
 		setIcon(water);
 	}
 	public boolean testShip()
  {
 		return ship;
 	}
  // letter-number code for button
 	public void setTest(int a)
  {
 		int b = a % 10 + 1;
 		nameNum = b;
 		char c = (char)((a / 10) + 65);
 		nameChar = c;
 		String d = "" + c + b;
 		test.setText(d);
 		buttonName = d;
 	}
  // ship placement
	public void setShipPlacement()
	{
		setIcon(placedShip);
	}
  // when click detected, set to either hit or miss
  public boolean anotherTurn;
 	public void setWaterFalse(ScorePanel score)
  {
 		hit = true;
 		if(ship)
    {
 			setIcon(explosion);
      score.setHits(); // add to hit counter
      anotherTurn = true;
 		}
 		else
    {
 			setIcon(miss);
 			anotherTurn = false;
      score.setMisses(); // add to miss counter
 		}
 	}
 	public boolean sunk()
  {
 		return ship;
 	}
 	//sets it to be a ship
 	public void iAmShip()
  {
 		ship = true;
 	}
 	// sets it to not be a ship
 	public void iAmNotShip()
  {
 		ship = true;
 	}
 	//checks if its a ship
 	public boolean checkIfShip()
  {
 		return ship;
 	}
 	public boolean testStringName(String name)
  {
 		if(buttonName.equals(name))
    {
 			return true;
 		}
 		else
    {
      return false;
    }
 	}
 	public int newNameNum(int changeMag)
  {
 		return nameNum + changeMag;
 	}
 	public char newNameChar(int changeMag)
  {
 		return (char)(nameChar + changeMag);
 	}
 	public boolean checkHit()
  {
 		return hit;
 	}
}
