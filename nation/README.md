# Nation Simulator
Nation Simulator is a command line simulation game focused on building a fictional nation. Starting with just one town, you can expand and gain more towns, eventually unifying the towns into states and districts within each state.

## Latest Release Information
**Current Version:** 1.4.4

**Release Date:** 22 February 2021

## Pre-requisites
- Latest Java Development Kit (JDK)
- Latest GitHub CLI

## Installation
**Step 1:** Clone repository to your computer with `gh repo clone benchase1/nation`

**Step 2:** `cd nation`

**Step 3:** `java nation`

If all goes well, you should see a screen looking like this:
```
Nation Simulator
Version 1.4.4
-----------------------------------------------------------------------
Saves:
Enter 1 to start a new game, or enter save code:
```
Note that a fresh installation has no games saved.

## Gameplay
Press `1` to start a brand new game. If you have a saved game, enter the save code of your game. Save codes are listed below `Saves:`. Press `enter`.

It is the year 2010, and you have been assigned one town, which is a real place, with the real 2010 population. You are given a low amount of options.
```
1. Go to 2011
2. Add town
3. Split town
```
As well as some miscellaneous options.
```
97. View changelog
98. Save and quit
99. Quit without saving
```
Enter your choice after `Choice:` and press `enter`.
More options appear as you progress throughout the game.

I was given Hardwick as my starting town, and will write this guide on that game. The game will list your current towns, as well as the current year.
```
Current Year: 2010
Your Towns:
Name: Hardwick | State: no state | District: no district | Population: 2990
```
None of your towns start in a state or district.

By pressing 1, the year will move forward, and population increases randomly each year.
### Splitting Towns
Press `3` to split a town.
```
Select town to split from
1. Hardwick
Choice:
```
If you have multiple towns, all towns will appear in the list. The only option I can pick is `1`, so I'll enter `1`.

You will be prompted to enter a new town name, I chose New Hardwick.

`Enter new town name:`

You will be prompted to enter a new town population. This subtracts from the current town population, `2990` for me. I entered `400` to start off with.

`Enter new town population:`

Your new town will pop up in your town list. My current list:
```
Current Year: 2010
Your Towns:
Name: Hardwick | State: no state | District: no district | Population: 2590
Name: New Hardwick | State: no state | District: no district | Population: 400
-----------------------------------------------------------------------
```
### Merging Towns
When you have two or more towns a new option shows up.

`4. Merge towns`

I created a new town out of Hardwick named Old Hardwick, with population 400, and I'll merge that with New Hardwick.

You will be prompted to choose a town to merge into. This is the town that remains after the merge. For me, this is 2.
```
Select town to merge to
1. Hardwick
2. New Hardwick
3. Old Hardwick
Choice:
```
You will be prompted to choose the town that goes away after the merge. For me, this is 3.
```
Select town to add
1. Hardwick
2. New Hardwick
3. Old Hardwick
Choice:
```
Old Hardwick has been removed, and the entry for New Hardwick is this:

`Name: New Hardwick | State: no state | District: no district | Population: 800`
### States
When the year reaches 2015, you are able to create a state, with this new option:

`5. Create state`

You will be prompted to name the state. I chose to name mine Massachusetts.

`Enter state name: `

You will be prompted to enter a state abbreviation. Mine will be MA.

`Enter state abbreviation: `

You will be prompted to enter the amount of towns in the state. Any number greater than the current town amount will result in an error. Since I want Hardwick and New Hardwick both in Massachusetts, I entered 2.

`Enter amount of towns: `

You will be prompted to choose the towns. You must enter the number next to the town. No order is necessary.
```
1. Hardwick
2. New Hardwick
Town 1: 1
Town 2: 2
```
A new list will appear for states.
```
Your States:
Name: Massachusetts | Abbreviation: MA | Population: 3145
```
State abbreviations have been added in the town list for affected towns.

Towns can also be added to states in a similar way by choosing option 6, and selecting the intended state and town.

When states are created, you get an info page to go along with it. Here is my current info page:
```
State: Massachusetts
Population: 3145
Towns in State:
Name: Hardwick | District: no district | Population: 2298
Name: New Hardwick | District: no district | Population: 847
Governor: Ben Chase
Votes: 1433 - 772
Election Year: 2015
Turnout: 70.11%
```
### Districts
When the year reaches 2020, you can add districts, by selecting option 9. Districts are very similar to states, but have a uniform naming scheme, being `<state abbreviation>-<number>`. `<number>` counts up from 1 for each state.

I will not cover the district creation tool in depth, since it is similar to the new state creation. `home state` is the state for the district to be in.

I now have a new list after adding Hardwick to a new district in Massachusetts.
```
Your Districts:
Name: MA-1 | State: MA | Population: 2406
```
District names have been added in the town list for affected towns.
### Elections
States may elect governors, districts may elect representatives, and towns may elect mayors after the state, district or town has been created. I chose to elect a governor to Massachusetts by chossing option 8 and selecting Massachusetts.

States, districts and towns automatically elect when they are initally created. District elections can be held every 2 years, and state and town elections can be held every 4 years. Results can be found on the state, district or town info page.

### Changelog
Choosing option 97 will load up the game's changelog, where you can view how the game progressed since version 0.1 released on 30 October 2020. Dates are not included.

For instance, GitHub support was added in version 1.4.2. This is the entry for version 1.4.2:
```
Version 1.4.2
- GitHub release!
```
### Saving
You can save your game by choosing option 98. After a short wait, you will recieve a 4 digit save code, such as `1259`. This code, along with your system date and time will appear in the start menu next time you start up the game.

Option 99 will exit the game without saving.
