import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Memory extends JFrame implements ActionListener
{
  JPanel backgroundPnl = new JPanel(); // background
  JPanel titlePnl = new JPanel();
  JPanel msgPnl = new JPanel();
  JPanel gamePnl = new JPanel();
  JPanel scorePnl = new JPanel();

  JLabel clickLbl = new JLabel("Attempts: 0");
  JLabel titleLbl = new JLabel("Memory Game");
  JLabel msgLbl = new JLabel("Dr. Jiang does not like tic-tac-toe");
  JLabel roundLbl = new JLabel("Round: 0");
  JLabel matchLbl = new JLabel("Matches: 0");

  JButton[] buttons = new JButton[16];
  JButton startBtn = new JButton("start");

  ImageIcon original = new ImageIcon("images/imageOriginal.gif");

  ArrayList<String> images = new ArrayList<String>();
  ArrayList<ImageIcon> gameImages = new ArrayList<ImageIcon>();

  boolean[] revealed = new boolean[16];
  boolean[] matched = new boolean[16];
  int[] order = new int[16];

  int round = 0;
  int matches = 0;
  int attempts = 0;
  int previousIndex = -1;
  String filePath = "no-file";
  boolean startGame = false;

  public Memory()
  {
    makeImages();
    startGame = false;
    backgroundPnl.setBackground(Color.DARK_GRAY);
    backgroundPnl.setLayout(new BorderLayout());
    add(backgroundPnl);

    titlePnl.setBackground(new Color(0, 255, 0));
    titlePnl.add(titleLbl);
    backgroundPnl.add(titlePnl, BorderLayout.NORTH);

    msgPnl.setBackground(new Color(0, 255, 0));
    msgPnl.add(msgLbl);
    backgroundPnl.add(msgPnl, BorderLayout.SOUTH);

    gamePnl.setBackground(Color.white);
    gamePnl.setLayout(new GridLayout(4, 4, 2, 2));
    makeButtons();
    backgroundPnl.add(gamePnl, BorderLayout.CENTER);
    gamePnl.setVisible(false);
    scorePnl.setBackground(Color.WHITE);
    scorePnl.setLayout(new GridLayout(5, 1, 2, 2));
    backgroundPnl.add(scorePnl, BorderLayout.EAST);
    startBtn.addActionListener(this);
    scorePnl.add(startBtn);
    scorePnl.add(roundLbl);
    scorePnl.add(matchLbl);
    scorePnl.add(clickLbl);

    setTitle("Memory");
    setSize(520, 410);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void makeButtons()
  {
    for (int i = 0; i < buttons.length; i++)
    {
      buttons[i] = new JButton(original);
      buttons[i].addActionListener(this);
      gamePnl.add(buttons[i]);
    }
  }

  public void makeImages()
  {
    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 2; j++)
      {
        images.add("images/image" + i + ".gif");
      }
    }

    while (images.size() > 0)
    {
      int index = (int) (Math.random() * images.size());
      gameImages.add(new ImageIcon(images.remove(index)));
    }
  }

  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();
    if (source == startBtn)
    {
      if (!startGame)
      {
        titlePnl.setBackground(new Color(0, 255, 0));
        msgPnl.setBackground(new Color(0, 255, 0));
        msgLbl.setText("Dr. Jiang does not like tic-tac-toe");
        round++;
        startGame = true;
        roundLbl.setText("Round: " + round);
        gamePnl.setVisible(true);
      }
    }
    if (startGame)
    {
      for (int i = 0; i < buttons.length; i++)
      {
        if (source == buttons[i] && i != previousIndex)
        {
          if (numRevealed() == 2)
          {
            concealAll();
          }
          if (numRevealed() == 0)
          {
            revealed[i] = true;
            buttons[i].setIcon(gameImages.get(i));
            filePath = gameImages.get(i).getDescription();
            previousIndex = i;
          }
          else if (numRevealed() == 1)
          {
            attempts++;

            if (attempts >= 15)
            {
              titlePnl.setBackground(new Color(255, 255, 0));
              msgPnl.setBackground(new Color(255, 255, 0));
            }
            if (attempts >= 30)
            {
              titlePnl.setBackground(new Color(255, 0, 0));
              msgPnl.setBackground(new Color(255, 0, 0));
            }

            clickLbl.setText("Attempts: " + attempts);
            buttons[i].setIcon(gameImages.get(i));
            revealed[i] = true;

            if (filePath.equals(gameImages.get(i).getDescription()))
            {
              matches++;
              matchLbl.setText("Matches: " + matches);
              msgLbl.setText("Congrats! You found a match.");
              matched[i] = true;
              matched[previousIndex] = true;
              buttons[previousIndex].setEnabled(false);
              buttons[i].setEnabled(false);
            }

            else
            {
              msgLbl.setText("No match, try again!");
            }
          }
        }
      }
    }

    if (matchTrue())
    {
      resetGame();
    }
  }

  public static void main(String[] args)
  {
    Memory panel = new Memory();
  }

  public int numRevealed()
  {
    int sum = 0;
    for (int i = 0; i < revealed.length; i++) {
      if (revealed[i])
        sum++;
    }
    return sum;
  }

  private void concealAll()
  {
    for (int i = 0; i < revealed.length; i++)
    {
      if (revealed[i])
      {
        if (!matched[i])
        {
          buttons[i].setIcon(original);
        }
        revealed[i] = false;
      }
    }
  }

  public boolean matchTrue()
  {
    boolean b = false;
    for (int i = 0; i < matched.length; i++)
    {
      if (matched[i] == true)
      {
        b = true;
      }
      else
      {
        b = false;
        return b;
      }
    }
    return b;
  }

  public void resetGame()
  {
    startGame = false;
    // Easter Eggs
    if (attempts < 15)
    {
      msgLbl.setText("You are better than the game's developers! " + attempts + " attempts.");
    }
    else if (attempts >= 30)
    {
      msgLbl.setText("You have a bad memory, go play something else! " + attempts + " attempts.");
    }
    else
    {
      msgLbl.setText("Congrats! You finished the game in " + attempts + " attempts.");
    }
    matches = 0;
    attempts = 0;
    matchLbl.setText("Matches: " + matches);
    clickLbl.setText("Attempts: " + attempts);
    revealed = revealed = new boolean[16];
    matched = new boolean[16];
    makeImages();

    for (int i = 0; i < 16; i++)
    {
      buttons[i].setIcon(original);
      buttons[i].setEnabled(true);
    }
    gamePnl.setVisible(false);
  }
} // end class
