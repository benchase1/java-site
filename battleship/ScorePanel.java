 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

 public class ScorePanel extends JPanel
 {
 	//array of ship buttons for placement
 	ShipButton [] button;
 	int sender;
  //counters
  int attempts = 0;
  int hits = 0;
  int misses = 0;
  int spacesLeft = 100;
  public int score = 0;
  //counter labels
  JLabel attemptsLbl = new JLabel("Attempts: " + attempts);
  JLabel hitsLbl = new JLabel("Hits: " + hits);
  JLabel missesLbl = new JLabel("Misses: " + misses);
  JLabel spacesLeftLbl = new JLabel("Spaces Left: " + spacesLeft);
  JLabel scoreLbl = new JLabel("Score: " + score);
 	//creates score panel
 	public ScorePanel()
  {
  	add(attemptsLbl);
  	add(hitsLbl);
  	add(missesLbl);
  	add(spacesLeftLbl);
    add(scoreLbl);
 		setLayout(new GridLayout(3,2));
 	}
 	public int getSender()
  {
 		return sender;
 	}
  // when click detected, add to attempts counter and remove from spaces left
  public void setAttempts()
  {
    attempts++;
    attemptsLbl.setText("Attempts: " + attempts);
    spacesLeft--;
    spacesLeftLbl.setText("Spaces Left: " + spacesLeft);
  }
  // when hit detected, add 1 hit and points depending on current attempt number
  public void setHits()
  {
    hits++;
    if (attempts <= 5)
    {
      score = score + 20;
      if (hits >= 2)
      {
        score = score + 3;
      }
      else if (hits >= 4)
      {
        score = score + 7;
      }
    }
    else if (attempts > 5 && attempts <= 10)
    {
      score = score + 17;
      if (hits >= 3)
      {
        score = score + 3;
      }
      else if (hits >= 5)
      {
        score = score + 7;
      }
    }
    else if (attempts > 10 && attempts <= 15)
    {
      score = score + 15;
      if (hits >= 6)
      {
        score = score + 3;
      }
      else if (hits >= 9)
      {
        score = score + 7;
      }
    }
    else if (attempts > 15 && attempts <= 20)
    {
      score = score + 12;
      if (hits >= 10)
      {
        score = score + 3;
      }
      else if (hits >= 13)
      {
        score = score + 7;
      }
    }
    else if (attempts > 20 && attempts <= 30)
    {
      score = score + 10;
    }
    else if (attempts > 30 && attempts <= 40)
    {
      score = score + 8;
    }
    else if (attempts > 40 && attempts <= 50)
    {
      score = score + 6;
    }
    else if (attempts > 50 && attempts <= 65)
    {
      score = score + 4;
    }
    else if (attempts > 65 && attempts <= 80)
    {
      score = score + 3;
    }
    else if (attempts > 80)
    {
      score = score + 1;
    }
    hitsLbl.setText("Hits: " + hits);
    scoreLbl.setText("Score: " + score);
  }
  // when miss detected, add 1 miss
  public void setMisses()
  {
    misses++;
    missesLbl.setText("Misses: " + misses);
  }
 }//end class
