 import java.lang.Math.*;
 import java.util.Scanner;
 public class TicTacToe
 {
 	public static void main(String [] args)
 	{
    Scanner in = new Scanner(System.in);
 		char [] grid = new char [9];

    for (int i = 0; i < 9; i++) // maximum 9 turns total
    {
      int win = 0; // initalize win to 0, no win/lose
      int choice = 1; // 1. player, 2. computer
      // when second if statement ends, choice reverts to 1
      if (win != 1 && win != 2)
      {
      if (choice == 1) // player's turn
      {
        System.out.print("Select space: ");
        int position = in.nextInt();

        if (grid[position - 1] == 'O')
        {
          grid[position - 1] = 'O';
        }
        else
        {
          grid[position - 1] = 'X';
        }
        printgrid(grid);
        choice = 2; // pass to computer

        System.out.println("----------");
      }

      if (choice == 2) // computer's turn
      {
        int position = (int)(Math.random() * 8) + 1;

        if (grid[position - 1] == 'X')
        {
          while(grid[position - 1] == 'X')
          {
            position = (int)(Math.random() * 8) + 1;
            if (grid[position - 1] != 'X')
            {
              grid[position - 1] = 'O';
            }
          }
        }
        else
        {
          grid[position - 1] = 'O';
        }

        printgrid(grid);

        System.out.println("----------");
      }
      }


      if (grid[0] == 'X' && grid[3] == 'X' && grid[6] == 'X')
      {
        win = 1;
      }

      else if (grid[0] == 'X' && grid[1] == 'X' && grid[2] == 'X')
      {
        win = 1;
      }

      else if (grid[3] == 'X' && grid[4] == 'X' && grid[5] == 'X')
      {
        win = 1;
      }

      else if (grid[6] == 'X' && grid[7] == 'X' && grid[8] == 'X')
      {
        win = 1;
      }

      else if (grid[1] == 'X' && grid[4] == 'X' && grid[7] == 'X')
      {
        win = 1;
      }

      else if (grid[2] == 'X' && grid[5] == 'X' && grid[8] == 'X')
      {
        win = 1;
      }

      else if (grid[0] == 'X' && grid[4] == 'X' && grid[8] == 'X')
      {
        win = 1;
      }

      else if (grid[2] == 'X' && grid[4] == 'X' && grid[6] == 'X')
      {
        win = 1;
      }

      else if (grid[0] == 'O' && grid[3] == 'O' && grid[6] == 'O')
      {
        win = 2;
      }

      else if (grid[0] == 'O' && grid[1] == 'O' && grid[2] == 'O')
      {
        win = 2;
      }

      else if (grid[3] == 'O' && grid[4] == 'O' && grid[5] == 'O')
      {
        win = 2;
      }

      else if (grid[6] == 'O' && grid[7] == 'O' && grid[8] == 'O')
      {
        win = 2;
      }

      else if (grid[1] == 'O' && grid[4] == 'O' && grid[7] == 'O')
      {
        win = 2;
      }

      else if (grid[2] == 'O' && grid[5] == 'O' && grid[8] == 'O')
      {
        win = 2;
      }

      else if (grid[0] == 'O' && grid[4] == 'O' && grid[8] == 'O')
      {
        win = 2;
      }

      else if (grid[2] == 'O' && grid[4] == 'O' && grid[6] == 'O')
      {
        win = 2;
      }

      if (win == 1)
      {
        System.out.println("You win.");
        break;
      }
      else if (win == 2)
      {
        System.out.println("You lose.");
        break;
      }
    }
 	}

  public static void printgrid(char [] grid)
  {
    System.out.println(grid[0] + " | " + grid[1] + " | " + grid[2]);
    System.out.println(grid[3] + " | " + grid[4] + " | " + grid[5]);
    System.out.println(grid[6] + " | " + grid[7] + " | " + grid[8]);
  }
}
