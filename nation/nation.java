import java.text.*;
import java.util.*;
import java.io.*;
public class nation
{

  public static void infoString(String n, String s, String d, int p)
  {
    System.out.println("Name: " + n + " | State: " + s + " | District: " + d + " | Population: " + p);
  }

  public static void stateInfoString(String n, String a, int p)
  {
    System.out.println("Name: " + n + " | Abbreviation: " + a + " | Population: " + p);
  }

  public static void districtInfoString(String n, String s, int p)
  {
    System.out.println("Name: " + n + " | State: " + s + " | Population: " + p);
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    ArrayList<Integer> saveCodes = new ArrayList<Integer>();
    ArrayList<String> saveLastModified = new ArrayList<String>();

    try
    {
      Scanner s = new Scanner(new File("saveCodes.chase"));

      while (s.hasNext())
      {
        saveCodes.add(Integer.parseInt(s.next()));
      }
      s.close();
    }
    catch (FileNotFoundException e)
    {
    }

    try
    {
      Scanner s = new Scanner(new File("saveLastModified.chase"));

      while (s.hasNextLine())
      {
        saveLastModified.add(s.nextLine());
      }
      s.close();
    }
    catch (FileNotFoundException e)
    {
    }

    System.out.println("Nation Simulator");
    System.out.println("Version 1.4.2");
    System.out.println("-----------------------------------------------------------------------");

    System.out.println("Saves:");
    for (int i = 0; i < saveCodes.size(); i++)
    {
      System.out.println(saveCodes.get(i) + " - " + saveLastModified.get(i));
    }

    System.out.print("Enter 1 to start a new game, or enter save code: ");
    int save = in.nextInt();

    System.out.println("-----------------------------------------------------------------------");

    ArrayList<String> townList = new ArrayList<String>();
    ArrayList<Integer> popTownList = new ArrayList<Integer>();

    ArrayList<String> playerTowns = new ArrayList<String>();
    ArrayList<Integer> playerTownsPop = new ArrayList<Integer>();
    ArrayList<String> playerTownsStates = new ArrayList<String>();
    ArrayList<String> playerTownsDistricts = new ArrayList<String>();
    ArrayList<String> playerStates = new ArrayList<String>();
    ArrayList<String> playerStatesAbb = new ArrayList<String>();
    ArrayList<Integer> playerStatesPop = new ArrayList<Integer>();
    ArrayList<String> playerDistricts = new ArrayList<String>();
    ArrayList<String> playerDistrictsStates = new ArrayList<String>();
    ArrayList<Integer> playerDistrictsPop = new ArrayList<Integer>();
    ArrayList<Integer> districtInState = new ArrayList<Integer>();

    ArrayList<String> electionPlace = new ArrayList<String>();
    ArrayList<String> electionWin = new ArrayList<String>();
    ArrayList<Integer> winVotes = new ArrayList<Integer>();
    ArrayList<Integer> loseVotes = new ArrayList<Integer>();
    ArrayList<Integer> electionYear = new ArrayList<Integer>();

    ArrayList<String> firstName = new ArrayList<String>();
    ArrayList<String> lastName = new ArrayList<String>();

    int choice = 0;
    int ogChoice = 0;
    int year = 2010;

    try
    {
      Scanner s = new Scanner(new File("towns.chase"));

      while (s.hasNextLine())
      {
        townList.add(s.nextLine());
      }
      s.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error.");
    }

    try
    {
      Scanner s = new Scanner(new File("popTowns.chase"));

      while (s.hasNext())
      {
        popTownList.add(Integer.parseInt(s.next()));
      }
      s.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error.");
    }

    try
    {
      Scanner s = new Scanner(new File("firstName.chase"));

      while (s.hasNextLine())
      {
        firstName.add(s.nextLine());
      }
      s.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error.");
    }

    try
    {
      Scanner s = new Scanner(new File("lastName.chase"));

      while (s.hasNextLine())
      {
        lastName.add(s.nextLine());
      }
      s.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error.");
    }

    if (save == 1)
    {
      year = 2010;

      int startTown = (int)(Math.random() * townList.size());

      playerTowns.add(townList.get(startTown));
      playerTownsPop.add(popTownList.get(startTown));
      playerTownsStates.add("no state");
      playerTownsDistricts.add("no district");

      townList.remove(startTown);
      popTownList.remove(startTown);
    }
    else
    {
      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/towns.chase"));

        while (s.hasNextLine())
        {
          playerTowns.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/popTowns.chase"));

        while (s.hasNext())
        {
          playerTownsPop.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/states.chase"));

        while (s.hasNextLine())
        {
          playerStates.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/popStates.chase"));

        while (s.hasNext())
        {
          playerStatesPop.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/districts.chase"));

        while (s.hasNextLine())
        {
          playerDistricts.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/popDistricts.chase"));

        while (s.hasNext())
        {
          playerDistrictsPop.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/playerTownsStates.chase"));

        while (s.hasNextLine())
        {
          playerTownsStates.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/playerTownsDistricts.chase"));

        while (s.hasNextLine())
        {
          playerTownsDistricts.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/playerStatesAbb.chase"));

        while (s.hasNextLine())
        {
          playerStatesAbb.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/playerDistrictsStates.chase"));

        while (s.hasNextLine())
        {
          playerDistrictsStates.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/districtInState.chase"));

        while (s.hasNext())
        {
          districtInState.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/electionPlace.chase"));

        while (s.hasNextLine())
        {
          electionPlace.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/electionWin.chase"));

        while (s.hasNextLine())
        {
          electionWin.add(s.nextLine());
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/winVotes.chase"));

        while (s.hasNext())
        {
          winVotes.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/loseVotes.chase"));

        while (s.hasNext())
        {
          loseVotes.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/currentYear.chase"));
        year = Integer.parseInt(s.next());
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }

      try
      {
        Scanner s = new Scanner(new File("nation-" + save + "/electionYear.chase"));

        while (s.hasNext())
        {
          electionYear.add(Integer.parseInt(s.next()));
        }
        s.close();
      }
      catch (FileNotFoundException e)
      {
      }
    }

    int currentStatePop = 0;
    int currentDistrictPop = 0;
    int statePopChange = 0;
    int districtPopChange = 0;
    int townNum = 0;

    while (choice != 99)
    {

      System.out.println("Current Year: " + year);
      if (playerStates.size() != 0)
      {
        System.out.println("Your States:");
        for (int a = 0; a < playerStates.size(); a++)
        {
          playerStatesPop.set(a, playerStatesPop.get(a) + statePopChange);
          stateInfoString(playerStates.get(a), playerStatesAbb.get(a), playerStatesPop.get(a));
        }

        if (playerDistricts.size() != 0)
        {
          System.out.println("Your Districts: ");
          for (int a = 0; a < playerDistricts.size(); a++)
          {
            playerDistrictsPop.set(a, playerDistrictsPop.get(a) + districtPopChange);
            districtInfoString(playerDistricts.get(a), playerDistrictsStates.get(a), playerDistrictsPop.get(a));
          }
        }
      }
      System.out.println("Your Towns:");
      for (int a = 0; a < playerTowns.size(); a++)
      {
        infoString(playerTowns.get(a),
        playerTownsStates.get(a),
        playerTownsDistricts.get(a),
        playerTownsPop.get(a));
      }

      System.out.println("-----------------------------------------------------------------------");

      System.out.println("Options:");
      System.out.println("1. Go to " + (year + 1));
      System.out.println("2. Add town");
      System.out.println("3. Split town");

      if (playerTowns.size() >= 2)
      {
        System.out.println("4. Merge towns");
      }

      if (year >= 2015)
      {
        System.out.println("5. Create state");
      }

      if (playerStates.size() != 0)
      {
        System.out.println("6. Add town to state");
        System.out.println("7. View state info");
        System.out.println("8. Elect state office");

        if (year >= 2020)
        {
          System.out.println("9. Create district");
        }
      }

      if (playerDistricts.size() != 0)
      {
        System.out.println("10. Add town to district");
        System.out.println("11. View district info");
        System.out.println("12. Elect district office");
      }
      System.out.println("97. View changelog");
      System.out.println("98. Save and quit");
      System.out.println("99. Quit without saving");

      System.out.print("Choice: ");
      choice = in.nextInt();
      ogChoice = choice;

      int [] townPopChange = new int [playerTowns.size() + 1];

      if (choice == 2)
      {
        int nextTown = (int)(Math.random() * townList.size());
        playerTowns.add(townList.get(nextTown));
        playerTownsPop.add(popTownList.get(nextTown));

        for (int b = 0; b < (year - 2010); b++)
        {
          int oldTownPop = popTownList.get(nextTown);
          if (playerTownsPop.get(playerTowns.size() - 1) <= 200)
          {
            double deltaPop = (Math.random() * 2);
            playerTownsPop.set(playerTowns.size() - 1, (int)(playerTownsPop.get(b) * (1 + deltaPop)));
            townPopChange[playerTowns.size() - 1] = playerTownsPop.get(playerTowns.size() - 1) - oldTownPop;
          }
          else
          {
            double deltaPop = ((Math.random() + 0.5) / 100);
            playerTownsPop.set(playerTowns.size() - 1, (int)(playerTownsPop.get(playerTowns.size() - 1) * (1 + deltaPop)));
            townPopChange[playerTowns.size() - 1] = playerTownsPop.get(playerTowns.size() - 1) - oldTownPop;
          }
        }

        playerTownsStates.add("no state");
        playerTownsDistricts.add("no district");

        townList.remove(nextTown);
        popTownList.remove(nextTown);
      }

      if (choice == 3)
      {
        in.nextLine(); // absorb enter key
        System.out.println("Select town to split from");
        for (int d = 0; d < playerTowns.size(); d++)
        {
          System.out.println((d + 1) + ". " + playerTowns.get(d));
        }
        System.out.print("Choice: ");
        int townFrom = in.nextInt() - 1;

        in.nextLine(); // absorb enter key
        System.out.print("Enter new town name: ");
        String townNew = in.nextLine();
        System.out.print("Enter new town population: ");
        int townNewPop = in.nextInt();

        playerTownsPop.set(townFrom, playerTownsPop.get(townFrom) - townNewPop);
        playerTowns.add(townNew);
        playerTownsPop.add(townNewPop);
        playerTownsStates.add("no state");
        playerTownsDistricts.add("no district");
      }

      if (choice == 4)
      {
        System.out.println("Select town to merge to");
        for (int d = 0; d < playerTowns.size(); d++)
        {
          System.out.println((d + 1) + ". " + playerTowns.get(d));
        }
        System.out.print("Choice: ");
        int townInto = in.nextInt() - 1;

        System.out.println("Select town to add");
        for (int d = 0; d < playerTowns.size(); d++)
        {
          System.out.println((d + 1) + ". " + playerTowns.get(d));
        }
        System.out.print("Choice: ");
        int townAdd = in.nextInt() - 1;

        playerTownsPop.set(townInto, playerTownsPop.get(townInto) + playerTownsPop.get(townAdd));
        playerTowns.remove(townAdd);
        playerTownsPop.remove(townAdd);
        playerTownsStates.remove(townAdd);
        playerTownsDistricts.remove(townAdd);
      }

      if (choice == 5)
      {
        in.nextLine(); // absorb enter key
        int stateNum = playerStates.size();
        System.out.print("Enter state name: ");
        String stateName = in.nextLine();
        playerStates.add(stateName);
        System.out.print("Enter state abbreviation: ");
        String stateAbb = in.nextLine();
        playerStatesAbb.add(stateAbb);
        System.out.print("Enter amount of towns: ");
        int townsInState = in.nextInt();
        currentStatePop = 0;
        districtInState.add(0);

        if (townsInState != 0)
        {
          for(int e = 0; e < playerTowns.size(); e++)
          {
            System.out.println((e + 1) + ". " + playerTowns.get(e));
          }
        }
        for(int f = 0; f < townsInState; f++)
        {
          System.out.print("Town " + (f + 1) + ": ");
          townNum = in.nextInt() - 1;
          playerTownsStates.set(townNum, stateAbb);
          currentStatePop = currentStatePop + playerTownsPop.get(townNum);
        }
        playerStatesPop.add(currentStatePop);

        choice = 8;
      }

      if (choice == 6)
      {
        System.out.println("Select town to add");
        for (int g = 0; g < playerTowns.size(); g++)
        {
          System.out.println((g + 1) + ". " + playerTowns.get(g));
        }
        System.out.print("Choice: ");
        int town = in.nextInt() - 1;

        System.out.println("Select state to add to");
        for(int h = 0; h < playerStates.size(); h++)
        {
          System.out.println((h + 1) + ". " + playerStates.get(h));
        }
        System.out.print("Choice: ");
        int stateAdd = in.nextInt() - 1;
        playerTownsStates.set(town, playerStatesAbb.get(stateAdd));
        playerStatesPop.set(stateAdd, playerStatesPop.get(stateAdd) + playerTownsPop.get(town));
      }

      if (choice == 7)
      {
        System.out.println("Select state to view");
        for(int h = 0; h < playerStates.size(); h++)
        {
          System.out.println((h + 1) + ". " + playerStates.get(h));
        }
        System.out.print("Choice: ");
        int stateView = in.nextInt() - 1;

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("State: " + playerStates.get(stateView));
        System.out.println("Population: " + playerStatesPop.get(stateView));
        System.out.println("Towns in State:");

        for (int b = 0; b < playerTowns.size(); b++)
        {
          if (playerTownsStates.get(b).equals(playerStatesAbb.get(stateView)))
          {
            System.out.println("Name: " + playerTowns.get(b) + " | District: " + playerTownsDistricts.get(b) + " | Population: " + playerTownsPop.get(b));
          }
        }

        if (districtInState.get(stateView) != 0)
        {
          System.out.println("Districts in State:");
        }

        int c = 1;
        for (int b = 0; b < playerDistricts.size(); b++)
        {
          String currentDistrict = playerStatesAbb.get(stateView) + "-" + c;
          if (playerDistricts.get(b).equals(currentDistrict))
          {
            System.out.println("Name: " + playerDistricts.get(b) + " | Population: " + playerDistrictsPop.get(b));
            c++;
          }
        }

        for (int i = 0; i < electionWin.size(); i++)
        {
          if (playerStates.get(stateView).equals(electionPlace.get(i)))
          {
            System.out.println("Governor: " + electionWin.get(i));
            System.out.println("Votes: " + winVotes.get(i) + " - " + loseVotes.get(i));
            System.out.println("Election Year: " + electionYear.get(i));
          }
        }

        in.nextLine(); // absorb enter key
        in.nextLine();
      }

      if (choice == 8)
      {
        int electState = 0;
        int lastElection = 0;
        int reElection = 4; // 4 year for gov term

        if (ogChoice == 5)
        {
          electState = playerStates.size() - 1;
        }
        else
        {
          System.out.println("Select state to elect to");
          for(int h = 0; h < playerStates.size(); h++)
          {
            System.out.println((h + 1) + ". " + playerStates.get(h));
          }
          System.out.print("Choice: ");
          electState = in.nextInt() - 1;

          for (int i = 0; i < electionPlace.size(); i++)
          {
            if (electionPlace.get(i).equals(playerStates.get(electState)))
            {
              lastElection = electionYear.get(i);
            }
          }
        }

        reElection = lastElection + 4;
        if (year < reElection)
        {
          System.out.println("State not eligible for election. Next election in " + reElection + ".");
          in.nextLine(); // absorb enter key
          in.nextLine();
        }
        else
        {
          for (int i = 0; i < electionPlace.size(); i++)
          {
            if (electionPlace.get(i).equals(playerStates.get(electState)))
            {
              electionYear.remove(i);
              electionWin.remove(i);
              electionPlace.remove(i);
            }
          }

          electionPlace.add(playerStates.get(electState));

          String [] candidates = new String[2];

          int rand1 = (int)(Math.random() * firstName.size());
          int rand2 = (int)(Math.random() * lastName.size());
          candidates[0] = firstName.get(rand1) + " " + lastName.get(rand2);

          int rand3 = (int)(Math.random() * firstName.size());
          int rand4 = (int)(Math.random() * lastName.size());
          candidates[1] = firstName.get(rand3) + " " + lastName.get(rand4);

          int winner = (int)(Math.random() * 2);
          electionWin.add(candidates[winner]);

          double winPct = 0.01 * ((Math.random() * 50) + 50);
          int turnout = (int)(playerStatesPop.get(electState) * Math.random());
          int win = (int)(turnout * winPct);
          winVotes.add(win);
          int lose = (int)(turnout * (1 - winPct));
          loseVotes.add(lose);

          electionYear.add(year);
        }
      }

      if (choice == 9)
      {
        in.nextLine(); // absorb enter key
        int districtNum = 1;
        String districtCode = "no code";
        System.out.println("Select home state");

        for(int e = 0; e < playerStates.size(); e++)
        {
          System.out.println((e + 1) + ". " + playerStates.get(e));
        }
        System.out.print("Choice: ");
        int stateNum = in.nextInt() - 1;
        playerDistrictsStates.add(playerStatesAbb.get(stateNum));

        districtCode = playerStatesAbb.get(stateNum) + "-" + (districtInState.get(stateNum) + 1);
        playerDistricts.add(districtCode);
        System.out.print("Enter amount of towns: ");
        int townsInDistrict = in.nextInt();
        currentDistrictPop = 0;

        districtInState.set(stateNum, districtInState.get(stateNum) + 1);

        if (townsInDistrict != 0)
        {
          for(int e = 0; e < playerTowns.size(); e++)
          {
            System.out.println((e + 1) + ". " + playerTowns.get(e));
          }
        }

        for(int f = 0; f < townsInDistrict; f++)
        {
          System.out.print("Town " + (f + 1) + ": ");
          townNum = in.nextInt() - 1;
          playerTownsDistricts.set(townNum, districtCode);
          currentDistrictPop = currentDistrictPop + playerTownsPop.get(townNum);
        }
        playerDistrictsPop.add(currentDistrictPop);

        choice = 12;
      }

      if (choice == 10)
      {
        System.out.println("Select town to add");
        for (int g = 0; g < playerTowns.size(); g++)
        {
          System.out.println((g + 1) + ". " + playerTowns.get(g));
        }
        System.out.print("Choice: ");
        int town2 = in.nextInt() - 1;

        System.out.println("Select district to add to");
        for(int h = 0; h < playerDistricts.size(); h++)
        {
          System.out.println((h + 1) + ". " + playerDistricts.get(h));
        }
        System.out.print("Choice: ");
        int districtAdd = in.nextInt() - 1;
        playerTownsDistricts.set(town2, playerDistricts.get(districtAdd));
        playerDistrictsPop.set(districtAdd, playerDistrictsPop.get(districtAdd) + playerTownsPop.get(town2));
      }

      if (choice == 11)
      {
        System.out.println("Select district to view");
        for(int h = 0; h < playerDistricts.size(); h++)
        {
          System.out.println((h + 1) + ". " + playerDistricts.get(h));
        }
        System.out.print("Choice: ");
        int districtView = in.nextInt() - 1;

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("District: " + playerDistricts.get(districtView));

        for (int a = 0; a < playerStates.size(); a++)
        {
          if (playerStatesAbb.get(a).equals(playerDistrictsStates.get(districtView)))
          {
            System.out.println("Home State: " + playerStates.get(a));
          }
        }

        System.out.println("Population: " + playerDistrictsPop.get(districtView));
        System.out.println("Towns in District:");

        for (int b = 0; b < playerTowns.size(); b++)
        {
          if (playerTownsDistricts.get(b).equals(playerDistricts.get(districtView)))
          {
            System.out.println("Name: " + playerTowns.get(b) + " | Population: " + playerTownsPop.get(b));
          }
        }

        for (int i = 0; i < electionWin.size(); i++)
        {
          if (playerDistricts.get(districtView).equals(electionPlace.get(i)))
          {
            System.out.println("Representative: " + electionWin.get(i));
            System.out.println("Votes: " + winVotes.get(i) + " - " + loseVotes.get(i));
            System.out.println("Election Year: " + electionYear.get(i));
          }
        }

        in.nextLine(); // absorb enter key
        in.nextLine();
      }

      if (choice == 12)
      {
        int electDistrict = 0;
        int lastElection = 0;
        int reElection = 2; // 2 year for rep term

        if (ogChoice == 9)
        {
          electDistrict = playerDistricts.size() - 1;
        }
        else
        {
          System.out.println("Select district to elect to");
          for(int h = 0; h < playerDistricts.size(); h++)
          {
            System.out.println((h + 1) + ". " + playerDistricts.get(h));
          }
          System.out.print("Choice: ");
          electDistrict = in.nextInt() - 1;

          for (int i = 0; i < electionPlace.size(); i++)
          {
            if (electionPlace.get(i).equals(playerDistricts.get(electDistrict)))
            {
              lastElection = electionYear.get(i);
            }
          }
        }

        reElection = lastElection + 2;
        if (year < reElection)
        {
          System.out.println("District not eligible for election. Next election in " + reElection + ".");
          in.nextLine(); // absorb enter key
          in.nextLine();
        }
        else
        {
          for (int i = 0; i < electionPlace.size(); i++)
          {
            if (electionPlace.get(i).equals(playerDistricts.get(electDistrict)))
            {
              electionYear.remove(i);
              electionWin.remove(i);
              electionPlace.remove(i);
            }
          }

          electionPlace.add(playerDistricts.get(electDistrict));

          String [] candidates = new String[2];

          int rand1 = (int)(Math.random() * firstName.size());
          int rand2 = (int)(Math.random() * lastName.size());
          candidates[0] = firstName.get(rand1) + " " + lastName.get(rand2);

          int rand3 = (int)(Math.random() * firstName.size());
          int rand4 = (int)(Math.random() * lastName.size());
          candidates[1] = firstName.get(rand3) + " " + lastName.get(rand4);

          int winner = (int)(Math.random() * 2);
          electionWin.add(candidates[winner]);

          double winPct = 0.01 * ((Math.random() * 50) + 50);
          int turnout = (int)(playerDistrictsPop.get(electDistrict) * Math.random());
          int win = (int)(turnout * winPct);
          winVotes.add(win);
          int lose = (int)(turnout * (1 - winPct));
          loseVotes.add(lose);

          electionYear.add(year);
        }
      }

      if (choice == 1)
      {
        for (int b = 0; b < playerTowns.size(); b++)
        {
          int oldTownPop = playerTownsPop.get(b);
          if (playerTownsPop.get(b) <= 200)
          {
            double deltaPop = (Math.random() * 2);
            playerTownsPop.set(b, (int)(playerTownsPop.get(b) * (1 + deltaPop)));
            townPopChange[b] = playerTownsPop.get(b) - oldTownPop;
          }
          else
          {
            double deltaPop = ((Math.random() + 0.5) / 100);
            playerTownsPop.set(b, (int)(playerTownsPop.get(b) * (1 + deltaPop)));
            townPopChange[b] = playerTownsPop.get(b) - oldTownPop;
          }
        }

        for (int a = 0; a < playerStates.size(); a++)
        {
          currentStatePop = 0;
          for (int b = 0; b < playerTowns.size(); b++)
          {
            if (playerTownsStates.get(b).equals(playerStatesAbb.get(a)))
            {
              currentStatePop = currentStatePop + playerTownsPop.get(b);
              playerStatesPop.set(a, currentStatePop);
            }
          }
        }

        for (int a = 0; a < playerDistricts.size(); a++)
        {
          currentDistrictPop = 0;
          for (int b = 0; b < playerTowns.size(); b++)
          {
            if (playerTownsDistricts.get(b).equals(playerDistricts.get(a)))
            {
              currentDistrictPop = currentDistrictPop + playerTownsPop.get(b);
              playerDistrictsPop.set(a, currentDistrictPop);
            }
          }
        }
        year++;
      }

      if (choice == 97)
      {
        System.out.println("-----------------------------------------------------------------------");

        try {
          File obj = new File("changelog.chase");
          Scanner read = new Scanner(obj);
          while (read.hasNextLine()) {
            String data = read.nextLine();
            System.out.println(data);
          }
          read.close();
        } catch (FileNotFoundException e) {
          System.out.println("Error.");
        }
        in.nextLine(); // absorb enter key
        in.nextLine();
      }

      if (choice == 98)
      {
        if (save == 1)
        {
          save = (int)(Math.random() * 9000) + 1000;
        }

        for (int i = 0; i < saveCodes.size(); i++)
        {
          if (saveCodes.get(i) == save)
          {
            saveCodes.remove(i);
            saveLastModified.remove(i);
          }
        }

        saveCodes.add(save);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date = new Date();
        saveLastModified.add(formatter.format(date));

        try
        {
          File saveFolder = new File("nation-" + save);
          saveFolder.mkdir();

          File newFile1 = new File("nation-" + save + "/towns.chase");
          FileWriter fileWriter1 = new FileWriter(newFile1);

          fileWriter1.write(playerTowns.get(0) + "\n");

          for (int i = 1; i < playerTowns.size(); i++)
          {
            fileWriter1.append(playerTowns.get(i) + "\n");
          }
          fileWriter1.close();
        }
        catch (IOException e)
        {
        }

        try
        {
          File newFile2 = new File("nation-" + save + "/popTowns.chase");
          FileWriter fileWriter2 = new FileWriter(newFile2);

          fileWriter2.write(playerTownsPop.get(0) + "\n");

          for (int i = 1; i < playerTownsPop.size(); i++)
          {
            fileWriter2.append(playerTownsPop.get(i) + "\n");
          }
          fileWriter2.close();
        }
        catch (IOException e)
        {
        }

        if (playerStates.size() != 0)
        {
          try
          {

            File newFile3 = new File("nation-" + save + "/states.chase");
            FileWriter fileWriter3 = new FileWriter(newFile3);

            fileWriter3.write(playerStates.get(0) + "\n");

            for (int i = 1; i < playerStates.size(); i++)
            {
              fileWriter3.append(playerStates.get(i) + "\n");
            }
            fileWriter3.close();
          }
          catch (IOException e)
          {
          }

          try
          {
            File newFile4 = new File("nation-" + save + "/popStates.chase");
            FileWriter fileWriter4 = new FileWriter(newFile4);

            fileWriter4.write(playerStatesPop.get(0) + "\n");

            for (int i = 1; i < playerStatesPop.size(); i++)
            {
              fileWriter4.append(playerStatesPop.get(i) + "\n");
            }
            fileWriter4.close();
          }
          catch (IOException e)
          {
          }
        }

        if (playerDistricts.size() != 0)
        {
          try
          {
            File newFile5 = new File("nation-" + save + "/districts.chase");
            FileWriter fileWriter5 = new FileWriter(newFile5);

            fileWriter5.write(playerDistricts.get(0) + "\n");

            for (int i = 1; i < playerDistricts.size(); i++)
            {
              fileWriter5.append(playerDistricts.get(i) + "\n");
            }
            fileWriter5.close();
          }
          catch (IOException e)
          {
          }

          try
          {
            File newFile6 = new File("nation-" + save + "/popDistricts.chase");
            FileWriter fileWriter6 = new FileWriter(newFile6);

            fileWriter6.write(playerDistrictsPop.get(0) + "\n");

            for (int i = 1; i < playerDistrictsPop.size(); i++)
            {
              fileWriter6.append(playerDistrictsPop.get(i) + "\n");
            }
            fileWriter6.close();
          }
          catch (IOException e)
          {
          }
        }

        if (playerTownsStates.size() != 0)
        {
          try
          {
            File newFile7 = new File("nation-" + save + "/playerTownsStates.chase");
            FileWriter fileWriter7 = new FileWriter(newFile7);

            fileWriter7.write(playerTownsStates.get(0) + "\n");

            for (int i = 1; i < playerTownsStates.size(); i++)
            {
              fileWriter7.append(playerTownsStates.get(i) + "\n");
            }
            fileWriter7.close();
          }
          catch (IOException e)
          {
          }
        }

        if (playerTownsDistricts.size() != 0)
        {
          try
          {
            File newFile8 = new File("nation-" + save + "/playerTownsDistricts.chase");
            FileWriter fileWriter8 = new FileWriter(newFile8);

            fileWriter8.write(playerTownsDistricts.get(0) + "\n");

            for (int i = 1; i < playerTownsDistricts.size(); i++)
            {
              fileWriter8.append(playerTownsDistricts.get(i) + "\n");
            }
            fileWriter8.close();
          }
          catch (IOException e)
          {
          }
        }

        if (playerStatesAbb.size() != 0)
        {
          try
          {
            File newFile9 = new File("nation-" + save + "/playerStatesAbb.chase");
            FileWriter fileWriter9 = new FileWriter(newFile9);

            fileWriter9.write(playerStatesAbb.get(0) + "\n");

            for (int i = 1; i < playerStatesAbb.size(); i++)
            {
              fileWriter9.append(playerStatesAbb.get(i) + "\n");
            }
            fileWriter9.close();
          }
          catch (IOException e)
          {
          }
        }

        if (playerDistrictsStates.size() != 0)
        {
          try
          {
            File newFile10 = new File("nation-" + save + "/playerDistrictsStates.chase");
            FileWriter fileWriter10 = new FileWriter(newFile10);

            fileWriter10.write(playerDistrictsStates.get(0) + "\n");

            for (int i = 1; i < playerDistrictsStates.size(); i++)
            {
              fileWriter10.append(playerDistrictsStates.get(i) + "\n");
            }
            fileWriter10.close();
          }
          catch (IOException e)
          {
          }
        }

        if (districtInState.size() != 0)
        {
          try
          {
            File newFile11 = new File("nation-" + save + "/districtInState.chase");
            FileWriter fileWriter11 = new FileWriter(newFile11);

            fileWriter11.write(districtInState.get(0) + "\n");

            for (int i = 1; i < districtInState.size(); i++)
            {
              fileWriter11.append(districtInState.get(i) + "\n");
            }
            fileWriter11.close();
          }
          catch (IOException e)
          {
          }
        }

        try
        {
          File newFile12 = new File("nation-" + save + "/currentYear.chase");
          FileWriter fileWriter12 = new FileWriter(newFile12);

          fileWriter12.write(year + "");
          fileWriter12.close();
        }
        catch (IOException e)
        {
        }

        try
        {
          File newFile13 = new File("saveCodes.chase");
          FileWriter fileWriter13 = new FileWriter(newFile13);

          fileWriter13.write(saveCodes.get(0) + "\n");

          for (int i = 1; i < saveCodes.size(); i++)
          {
            fileWriter13.append(saveCodes.get(i) + "\n");
          }
          fileWriter13.close();
        }
        catch (IOException e)
        {
        }

        try
        {
          File newFile14 = new File("saveLastModified.chase");
          FileWriter fileWriter14 = new FileWriter(newFile14);

          fileWriter14.write(saveLastModified.get(0) + "\n");

          for (int i = 1; i < saveLastModified.size(); i++)
          {
            fileWriter14.append(saveLastModified.get(i) + "\n");
          }
          fileWriter14.close();
        }
        catch (IOException e)
        {
        }

        if (electionWin.size() != 0)
        {
          try
          {
            File newFile15 = new File("nation-" + save + "/electionPlace.chase");
            FileWriter fileWriter15 = new FileWriter(newFile15);

            fileWriter15.write(electionPlace.get(0) + "\n");

            for (int i = 1; i < electionPlace.size(); i++)
            {
              fileWriter15.append(electionPlace.get(i) + "\n");
            }
            fileWriter15.close();
          }
          catch (IOException e)
          {
          }

          try
          {
            File newFile16 = new File("nation-" + save + "/electionWin.chase");
            FileWriter fileWriter16 = new FileWriter(newFile16);

            fileWriter16.write(electionWin.get(0) + "\n");

            for (int i = 1; i < electionWin.size(); i++)
            {
              fileWriter16.append(electionWin.get(i) + "\n");
            }
            fileWriter16.close();
          }
          catch (IOException e)
          {
          }

          try
          {
            File newFile17 = new File("nation-" + save + "/winVotes.chase");
            FileWriter fileWriter17 = new FileWriter(newFile17);

            fileWriter17.write(winVotes.get(0) + "\n");

            for (int i = 1; i < winVotes.size(); i++)
            {
              fileWriter17.append(winVotes.get(i) + "\n");
            }
            fileWriter17.close();
          }
          catch (IOException e)
          {
          }

          try
          {
            File newFile18 = new File("nation-" + save + "/loseVotes.chase");
            FileWriter fileWriter18 = new FileWriter(newFile18);

            fileWriter18.write(loseVotes.get(0) + "\n");

            for (int i = 1; i < loseVotes.size(); i++)
            {
              fileWriter18.append(loseVotes.get(i) + "\n");
            }
            fileWriter18.close();
          }
          catch (IOException e)
          {
          }

          try
          {
            File newFile19 = new File("nation-" + save + "/electionYear.chase");
            FileWriter fileWriter19 = new FileWriter(newFile19);

            fileWriter19.write(electionYear.get(0) + "\n");

            for (int i = 1; i < electionYear.size(); i++)
            {
              fileWriter19.append(electionYear.get(i) + "\n");
            }
            fileWriter19.close();
          }
          catch (IOException e)
          {

        }

        System.out.println("Your save code: " + save);
        break;
      }

      System.out.println("-----------------------------------------------------------------------");
    }
    }
  }
}
