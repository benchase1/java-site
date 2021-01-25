import javax.swing.*;
import java.awt.*;

//a class that holds data for entire ships
 public class Ship
 {
 	 BoardSpace[] ship;
 	 boolean sunk;
 	 //sets ship arrays equal to eachother
 	 public Ship(BoardSpace[] passShip)
   {
 		ship = passShip;
 		for(int i = 0; i<ship.length; i++)
    {
 			ship[i].iAmShip();
 		}
 	}
 	public void checkShip()
  {
 		for(int i = 0; i < ship.length; i++)
    {
 			sunk = ship[i].sunk();
 		}
 	}
 	// returns boolean to check if the ship was sunk
 	public boolean checkSunk()
  {
 		int x = 0;
 		// runs through the ships at length checking for hit
 		for(int y = 0; y < ship.length;y++)
    {
 			if(ship[y].checkHit())
      {
 				x++;
 			}
 		}
 		//if it is a hit returns true
 		if(x == ship.length)
    {
 			return true;
 		}
 		else {
 			return false;
    }
 	}
 	boolean checkedSunk = false;
 	//checks whether or not ship is sunk
 	public boolean sunkYet()
  {
 		boolean temporary = checkedSunk;
 		checkedSunk = true;
 		return temporary;
 	}
 	public void hitSpace()
  {
 		for(int i = 0; i<ship.length; i++)
    {
 			ship[i].iAmShip();
 		}
 	}
 }
