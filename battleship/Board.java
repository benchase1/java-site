import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

 public class Board extends JPanel implements ActionListener
 {
  // creates board spaces
  JPanel boardSpaces = new JPanel();
  ArrayList<BoardSpace> spaces = new ArrayList<BoardSpace>();
  //creates the score panel
  ScorePanel score = new ScorePanel();
 	int sender;
 	boolean player;
 	static int compChoice = -1;
  // ships
 	Ship[] ships = new Ship[5];
 	int shipSpot = 0;

 	public Board(boolean amIPlayer)
  {
 		player = amIPlayer;
 		boardSpaces.setLayout(new GridLayout(10,9)); // grid layout for board
    setLayout(new BorderLayout()); // ability to put score under board
 		makeButtons();
 		for(int i = 0; i < 100; i++)
    {
 			boardSpaces.add(spaces.get(i));
 		}
    add(boardSpaces, BorderLayout.CENTER);
    add(score, BorderLayout.SOUTH);
 		setBackground(Color.WHITE);
 	}
	//creates the buttons for our grids
 	private void makeButtons()
  {
 		for(int i = 0; i < 100; i++)
    {
 			spaces.add(new BoardSpace());
 			spaces.get(i).setTest(i);
 			spaces.get(i).addActionListener(this);
 		}
 	}
 	//this is the computer guessing method
 	public void computerPick()
  {
 		boolean loopBreaker = true;
 		while(loopBreaker)
    {
 	   if(false)
     {
 		     int compChoice = (int)(Math.random()*spaces.size());
 		  }
 			compChoice = (int)(Math.random()*spaces.size());
 			spaces.get(compChoice).setWaterFalse(score);
 			spaces.get(compChoice).removeActionListener(this);
 			loopBreaker = spaces.get(compChoice).anotherTurn;
 			spaces.remove(compChoice);
 		}
 	}
 	//sends results if a ship is sunk
 	public boolean sunkShip()
  {
 		for(int i = 0; i<ships.length; i++)
    {
 			if(ships[i].checkSunk() && ships[i].sunkYet())
      {
 				return true;
 			}
 		}
 		return false;
 	}
 	public boolean anotherTurn;
 	//actioned performed for the grid buttons
 	public void actionPerformed(ActionEvent e)
  {
		Object source = e.getSource();
    score.setAttempts();
  	if(!player)
    {
		  for(int i = 0; i < spaces.size(); i++)
      {
			  if(spaces.get(i) == source)
        {
				  spaces.get(i).setWaterFalse(score);
				  anotherTurn = spaces.get(i).anotherTurn;
		  	}
		  }
		  compChoice = (int)(Math.random()*spaces.size());
	   }
     if (score.hits == 17)
     {
       win();
     }
  }
 	//sets the button sender
  public void setSender(int newSender)
  {
  	sender = newSender;
  }
  //original test does not work
  public void fillBoardPlayer(BoardSpace startSpace)
  {
  		boolean endCheck = true;
  		BoardSpace[] tempShip = new BoardSpace[sender];
  		while(endCheck)
      {
    		int space = (int)(Math.random() * spaces.size());
    		int vertOrHori = (int)(Math.random() * 2);
    		tempShip[0] = startSpace;
    		int testBreak = 0;
	    	for(int x = 1; x < sender; x++)
        {
    			String newName;
    			if(vertOrHori == 1)
          {
    				char a = spaces.get(space).newNameChar(x);
    				int b = spaces.get(space).newNameNum(0);
    				newName = "" + a + b;
    			}
    			else
          {
    				char a = spaces.get(space).newNameChar(0);
    				int b = spaces.get(space).newNameNum(x);
    				newName = "" + a + b;
    			}
    			for(int y = 0; y < spaces.size(); y++)
          {
    				if(spaces.get(y).testStringName(newName) && !spaces.get(y).testShip())
            {
    					tempShip[x] = spaces.get(y);
    					testBreak++;
	    			}
	    		 }
	    	  }
	    		if(testBreak == sender)
          {
    				endCheck = false;
    			}

    		if(sender == 0)
        {
    			String newName;
    			for(int temp = 1; temp < 3; temp++)
          {
	    			if(vertOrHori == 1)
            {
	    				char a = spaces.get(space).newNameChar(temp);
	    				int b = spaces.get(space).newNameNum(0);
	    				newName = "" + a + b;
	    			}
	    			else
            {
	    				char a = spaces.get(space).newNameChar(0);
	    				int b = spaces.get(space).newNameNum(temp);
	    				newName = "" + a + b;
	    			}
	    			for(int y = 0; y < spaces.size(); y++)
            {
	    				if(spaces.get(y).testStringName(newName) && !spaces.get(y).testShip()){
	    					tempShip[temp] = spaces.get(y);
	    					testBreak++;
	    				}
	    			}
    			}
    			if(testBreak == 2)
          {
    				endCheck = false;
    			}
    		}
    	}
    	ships[shipSpot] = new Ship(tempShip);
    	for(int i=0; i<tempShip.length; i++)
      {
    		tempShip[i].setShipPlacement();
    	}
    	shipSpot++;
  }
 	//places the ships in the boards
  public void fillBoardRandom(int shipCount)
  {
  	for(int i = 0; i < shipCount; i++)
    {
  		BoardSpace [] tempShip = new BoardSpace[i + 1];
  		if(i != 0)
      {
  			tempShip = new BoardSpace[i + 1];
  		}
  		else{
  			tempShip = new BoardSpace[3];
  		}
  		boolean endCheck = true;
  		while(endCheck)
      {
    		int space = (int)(Math.random() * spaces.size());
    		int vertOrHori = (int)(Math.random() * 2);
    		BoardSpace startSpace = spaces.get(space);

    		tempShip[0] = startSpace;
    		int testBreak = 0;
    		if(i != 0)
        {
	    		for(int x = 1; x <= i; x++)
          {
	    			String newName;
	    			if(vertOrHori == 1){
	    				char a = spaces.get(space).newNameChar(x);
	    				int b = spaces.get(space).newNameNum(0);
	    				newName = "" + a + b;
	    			}
	    			else
            {
	    				char a = spaces.get(space).newNameChar(0);
	    				int b = spaces.get(space).newNameNum(x);
	    				newName = "" + a + b;
	    			}
	    			for(int y = 0; y < spaces.size(); y++){
	    				if(spaces.get(y).testStringName(newName) && !spaces.get(y).testShip())
              {
	    					tempShip[x] = spaces.get(y);
	    					testBreak++;
	    				}
	    			}
	    		}
	    		if(testBreak == i)
          {
    				endCheck = false;
    			}
    		}
    		if(i == 0)
        {
    			String newName;
    			for(int temp = 1; temp < 3; temp++)
          {
	    			if(vertOrHori == 1)
            {
	    				char a = spaces.get(space).newNameChar(temp);
	    				int b = spaces.get(space).newNameNum(0);
	    				newName = "" + a + b;
	    			}
	    			else{
	    				char a = spaces.get(space).newNameChar(0);
	    				int b = spaces.get(space).newNameNum(temp);
	    				newName = "" + a + b;
	    			}
	    			for(int y = 0; y < spaces.size(); y++)
            {
	    				if(spaces.get(y).testStringName(newName) && !spaces.get(y).testShip())
              {
	    					tempShip[temp] = spaces.get(y);
	    					testBreak++;
	    				}
	    			}
    			}
    			if(testBreak == 2)
          {
    				endCheck = false;
    			}
    		}
    	}
    	if(player)
      {
    		for(int o = 0; o < tempShip.length; o++)
        {
    			tempShip[o].setShipPlacement();
    		}
    	}
    	ships[i] = new Ship(tempShip);
  	}
  }
  // checks each time if the game is over
  public boolean checkGameOver()
  {
    int counter = 0;
    for(int i = 0; i < ships.length; i++)
    {
  	   if(ships[i].checkSunk())
       {
  		   counter++;
  	   }
    }
    if(counter == 5)
    {
    	return true;
    }
    else
    {
      return false;
    }
	}

  public int sendScore;
  public void updateSender()
  {
  	sendScore = score.score;
  }
  // prints the winner gui if there is a winner
  public void win()
  {
    System.out.println("Win.");
    System.out.println("Attempts: " + score.attempts);
    System.out.println("Hits: " + score.hits);
    System.out.println("Misses: " + score.misses);
    System.out.println("Score: " + score.score);
  }
 }
