 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.ArrayList;

 public class GameFrame extends JFrame
 {
 	JPanel background = new JPanel();
 	//the two playing grids
 	Board pBoard = new Board(true);
 	Board cBoard = new Board(false);
  ImageIcon ttlImage = new ImageIcon("images/bstitle.jpg");
  ScorePanel scoreBoard = new ScorePanel();
 	//labels
 	JLabel title = new JLabel();
 	JPanel north = new JPanel();
 	JLabel sunkenShip = new JLabel();
	//tester
 	private int storage = 0;
 	//constantly updating loop
 	boolean loop = true;
	//generates our main game
 	public GameFrame()
  {
 		super("Battleship 1.0.4");
 		setSize(1500, 1000);
 		add(background);
  	background.setLayout(new BorderLayout());
  	background.add(pBoard, BorderLayout.WEST);
  	background.add(cBoard, BorderLayout.EAST);
  	north.setBackground(Color.GRAY);
  	title.setIcon(ttlImage);
  	north.add(title, BorderLayout.CENTER);
  	north.add(sunkenShip);
  	background.add(north, BorderLayout.NORTH);
  	cBoard.fillBoardRandom(5);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	pBoard.fillBoardRandom(5);
  	setVisible(true);
 	} //end constructor
 	// players turn then calls computer after player picks.
 	public void sendNum()
  {
 		int tempStore = -1;
 		boolean checker = true;
 		while(checker)
    {
 			if(pBoard.sender != scoreBoard.sender)
      {
 				pBoard.setSender(scoreBoard.sender);
 			}
 			if(pBoard.compChoice != tempStore && !cBoard.anotherTurn)
      {
 				pBoard.computerPick();
 				tempStore = pBoard.compChoice;
 			}
 		}
 	}
  // ship sunk message
 	public void sunkenShip(boolean s)
  {
 		if(s = true)
 		{
 			sunkenShip.setText("Computer sunk a ship.");
 		}
 		else
 		{
 			sunkenShip.setText("Player sunk a ship.");
 		}
 	}
 }
