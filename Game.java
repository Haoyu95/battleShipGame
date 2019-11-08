import java.io.*;
import java.util.Scanner;

/**
 * The main class to execute the game named Battleship with a Twist.The aim of 
 * Battleship with a Twist is for a player to try and destroy all of the computer 
 * opponents ships before the computer destroys all of the players ships placed 
 * on the playing grid.
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class Game
{
    //The ships of player
    private ShipList playerShips;
    //The ships of computer
    private ShipList computerShips;

    /**
     * Create a ShipList with default constructor for both player and computer.
     */
    public Game()
    {
        playerShips = new ShipList();
        computerShips = new ShipList();
    }

    /**
     * Create a ShipList with given shiplist objects for both player and computer.
     */
    public Game(ShipList playerShips, ShipList computerShips)
    {
        this.playerShips = playerShips;
        playerShips.addShip("",1,1,1,1);
        this.computerShips = computerShips;
    }

    /**
     * Set the shiplist of player.
     * @param playerShips The shiplist of player.
     */
    private void setPlayerShips (ShipList playerShips)
    {
        this.playerShips = playerShips;
    }

    /**
     * Get the shiplist of player.
     * @return playerShips The shiplist of player.
     */
    private ShipList getPlayerShips()
    {
        return playerShips;
    }

    /**
     * Set the shiplist of computer.
     * @param playerShips The shiplist of computer.
     */
    private void setComputerShips(ShipList computerShips)
    {
        this.computerShips = computerShips;
    }

    /**
     * Get the shiplist of computer.
     * @return playerShips The shiplist of computer.
     */
    private ShipList getComputerShips()
    {
        return computerShips;
    }

    /**
     * The main method to start the game.It would display the settings in the "gamesettings.txt" file.
     * User and computer then set their ships and game begins.
     */
    public void start()
    {
        String fileName = "gamesettings.txt";
        FileIO fileToRead = new FileIO();
        String[] settings = fileToRead.readFile(fileName);
        
        int wide = Integer.parseInt(settings[0]);
        boolean multiHit = Boolean.valueOf(settings[1]);
        boolean visibility = Boolean.valueOf(settings[2]);
        int noOfShip = Integer.parseInt(settings[3]);
        int gridSize = wide;
        displaySetting(gridSize, noOfShip, multiHit, visibility);
        System.out.println('\u000c');
        setShip("player",gridSize, noOfShip, multiHit);
        setShip("computer",gridSize, noOfShip, multiHit);

        play(gridSize, noOfShip, visibility);
    }

    /**
     * Display the settings in the "gamesettings.txt" file.And ask user to enter any key to continue.
     * 
     * @param gridSize The width and height of the grid.
     * @param noOfShip The number of the ships the shiplist contains.
     * @param multiHit Whether it needed mutiple hits to destory a ship. 
     * @param visibility Whether the computer ships are visible.
     */
    private void displaySetting(int gridSize, int noOfShip, boolean multiHit, boolean visibility)
    {
        System.out.println('\u000c');
        System.out.println("+==========================================================+");
        System.out.println("|                                                          |");
        System.out.println("|     Welcome to the BattleShip Game -- With a Twist!!     |");
        System.out.println("|                                                          |");
        System.out.println("+==========================================================+");
        System.out.println("The game will use the grid size defined in the setting file");
        System.out.println("Playing grid size set as ("+ gridSize + "X" + gridSize + ")");
        System.out.println("Maximum number of ships allowed as "+ noOfShip);
        System.out.println("Multiple hits allowed per ships set as " + multiHit);
        if (visibility)
        {
            System.out.println("Computer Ships Visible : ON" );
        }
        else
        {
            System.out.println("Computer Ships Visible : OFF" );
        }
        Input input = new Input();
        input.acceptInput("Press any key to continue...");
    }

    /**
     * Set the values for the ships.And use these values to create new ships then add then to the shiplist.
     * 
     * @param gridSize The width and height of the grid.
     * @param noOfShip The number of the ships the shiplist contains.
     * @param multiHit Whether it needed mutiple hits to destory a ship. 
     * @param user Whether the computer or player.
     */
    private void setShip(String user, int gridSize, int noOfShip, boolean multiHit)
    {
        System.out.println("Loading " + user + " settings:");
        String shipName = "";
        int xPos = 0;
        int yPos = 0;
        int noOfHitsMade = 0;
        int noOfHitsNeeded = 0;
        Input input = new Input();
        Validation validate = new Validation();
        for(int i = 0; i < noOfShip; i++)
        {
            if(user.equals("player"))
            {
                System.out.println("Please enter the details for the " + (i+1) + " ship");
                shipName = input.acceptInput("ShipName:");
                while(!validate.stringsLengthWithinRange(shipName, 3, 15))
                {
                    System.out.println("Ship name must between 3-15 characters.");
                    shipName = input.acceptInput("ShipName:");
                }

                xPos = setPos("x",gridSize);
                yPos = setPos("y",gridSize);

                if(i > 0)
                {
                    for(int x = 0; x < i; x++)
                    {
                        int existPlayerxPos = playerShips.getShipByIndex(x).getxPos();
                        int existPlayeryPos = playerShips.getShipByIndex(x).getyPos();
                        while(existPlayerxPos == xPos && existPlayeryPos == yPos)
                        {
                            System.out.println("There is already a ship existed,please use other x/y positions to place your ship");
                            xPos = setPos("x",gridSize);
                            yPos = setPos("y",gridSize);
                        }
                    }
                }
            }
            else
            {

                shipName = "ship " + i;
                int max = gridSize - 1;
                CoordinateGenerator number = new CoordinateGenerator(0,max);
                xPos = number.getRandomNumber();
                yPos = number.getRandomNumber();
                if(i > 0)
                {
                    for(int x = 0; x < i; x++)
                    {
                        int existComputerxPos = computerShips.getShipByIndex(x).getxPos();
                        int existComputeryPos = computerShips.getShipByIndex(x).getyPos();
                        while(existComputerxPos == xPos && existComputeryPos == yPos)
                        {

                            xPos = number.getRandomNumber();
                            yPos = number.getRandomNumber();
                        }
                    }
                }

            }
            if(multiHit)
            {
                CoordinateGenerator number = new CoordinateGenerator(1,5);
                noOfHitsNeeded = number.getRandomNumber();
            }
            else
            {
                noOfHitsNeeded = 1;
            }
            if(user.equals("player"))
            {
                playerShips.addShip(shipName,xPos,yPos,noOfHitsMade,noOfHitsNeeded);
            }
            else
            {
                computerShips.addShip(shipName,xPos,yPos,noOfHitsMade,noOfHitsNeeded);
            }
        }
        if(user.equals("computer"))
        {
            System.out.println("Computer settings generated!");
            input.acceptInput("Press any key to continue...");
        }
    }

     /**
     * Set the values for the ship's x/y position.And there are some validations implemented.
     * 
     * @param s Clarify to set x or y position.
     * @param gridSize The width and height of the grid.
     * @return The x or y position user wish to assign to the ship.
     * @throws Exception If user's input isn't numberic.
     */
    private int setPos(String s,int gridSize)
    {
        int pos = 0;
        boolean endPoint = true;
        int max = gridSize - 1;
        Input input = new Input();
        Validation validate = new Validation();
        while(endPoint)
        {
            try
            {
                pos = Integer.parseInt(input.acceptInput("Ship "+ s +" Position (0 - " + max + "):"));
                while(!validate.WithinRange(pos, 0, max))
                {
                    System.out.println("Ship "+ s +" Position Must Be between 0 and " + max);  
                    pos = Integer.parseInt(input.acceptInput("Ship "+ s +" Position (0 - " + max + "):"));
                }
                endPoint = false;
            }
            catch(Exception e)
            {
                System.out.println("Ship "+ s +" Position Must Be Numberic");
            }
        }
        return pos;
    }

    /**
     * The method to continue play game,first player make a guess, then computer make a guess,if the ship are hit,there would be
     * score awarded.And when all ships of one side are destoryed, another side wins.Finally the result of this game would be print
     * to the file named "gameoutcome.txt".
     * 
     * @param gridSize The width and height of the grid.
     * @param noOfShip The number of the ships the shiplist contains.
     * @param visibility Whether the computer ships are visible.
     */
    private void play(int gridSize, int noOfShip, boolean visibility)
    {
        FileIO writeFile = new FileIO();
        Input input = new Input();
        boolean endPoint = true;
        int round = 1;
        int playerScore = 0;
        int computerScore = 0;
        String winner = "";

        while(endPoint)
        {
            
            if(playerShips.ifWin(playerShips.getShipList()))
            {
                System.out.println("Congragulation! Computer Wins");
                winner = "Computer";
                break;
            }

            if(computerShips.ifWin(computerShips.getShipList()))
            {
                System.out.println("Congragulation! Player Wins");
                winner = "Player";
                break;
            }
            System.out.println('\u000c');
            System.out.println("Beginning Round "+ round);
            System.out.println("Player Score: "+ playerScore);
            System.out.println("Computer Score: "+ computerScore);
            if(visibility == true)
            {
                System.out.println("ENEMY SHIPS ONLY SHOWN WHEN DEMO MODE IS ON!!");
            }
            System.out.println("Displaying the Player Grid");
            playerShips.displayGrid(gridSize,playerShips.getShipList());
            System.out.println("\n");
            System.out.println("--------------------------------------------");
            System.out.println("\n");
            System.out.println("Displaying the Computer Grid");
            if(visibility == false)
            {
                for(int i = 0; i < gridSize; i++)
                {
                    for(int j = 0; j < gridSize; j++)
                    {
                        System.out.print("~");
                    }
                    System.out.println("");
                }
            }else{
                computerShips.displayGrid(gridSize,computerShips.getShipList());
            }
            System.out.println("\n");

            System.out.println("Player to make a guess");
            int guessX = playerGuess("x",gridSize);
            int guessY = playerGuess("y",gridSize);
            System.out.println();
            playerScore = playerHit(guessX, guessY, playerScore, gridSize, noOfShip);
            System.out.println("Computer to make a guess");
            System.out.println();
            int guessx = computerGuess("x",gridSize);
            int guessy = computerGuess("y",gridSize);
            System.out.println();
            computerScore = computerHit(guessx, guessy, computerScore, gridSize, noOfShip);

            round++;
            input.acceptInput("Press any key to continue..."); 

        }
        String fileName = "gameoutcome.txt";
        writeFile.WriteFile(fileName,winner,playerScore,computerScore);
    }

    /**
     * The method to ask the player to make a guess to attack the ships of computer using the coordinate given by player, and there
     * are some validations implemented.
     * 
     * @param s Clarify to guess x or y position.
     * @param gridSize The width and height of the grid.
     * @return The x or y position player wish to attack.
     * @throws Exception If player's input isn't numberic.
     */
    private int playerGuess(String s,int gridSize)
    {
        int guess = 0;
        boolean endPoint = true;
        int max = gridSize - 1;
        Input input = new Input();
        Validation validate = new Validation();

        while(endPoint)
        {
            try
            {
                guess = Integer.parseInt(input.acceptInput("Ship "+ s +" Position (0 - " + max + "):"));
                while(!validate.WithinRange(guess, 0, max))
                {
                    System.out.println("Ship "+ s +" Position Must Be between 0 and " + max);  
                    guess = Integer.parseInt(input.acceptInput("Ship "+ s +" Position (0 - " + max + "):"));
                }
                endPoint = false;
            }
            catch(Exception e)
            {
                System.out.println("Ship "+s+" Position Must Be Numberic");
            }
        }
        return guess;
    }

    /**
     * The method to ask the computer to make a guess to attack the ships of player using the coordinate randomly generatred.
     * 
     * @param s Clarify to guess x or y position.
     * @param gridSize The width and height of the grid.
     * @return The x or y position computer wish to attack.
     */
    private int computerGuess(String s, int gridSize)
    {
        int guess = 0;
        int max = gridSize - 1;
        CoordinateGenerator number = new CoordinateGenerator(0,max);
        guess = number.getRandomNumber();
        System.out.println("Computer "+ s +" guess :" + guess);
        return guess;
    }

    /**
     * The method to change state of computer ships if player make a correct guess, then print out message if any ship of computer
     * is destroyed by this attack.
     * 
     * @param guessX The x position player want to attack.
     * @param guessY The y position player want to attack.
     * @param gridSize The width and height of the grid.
     * @param noOfShip The number of the ships the shiplist contains.
     * @param playerScore The current score of player.
     * @return playerScore The score after player make a guess.
     */
    private int playerHit(int guessX,int guessY,int playerScore,int gridSize,int noOfShip)
    {
        boolean playerHit = false;
        Input input = new Input();

        for(int i = 0; i < computerShips.getNumberOfShips();i++)
        {
            if(guessX == computerShips.getShipByIndex(i).getxPos() && guessY == computerShips.getShipByIndex(i).getyPos() )
            {
                int noOfHitsMade = computerShips.getShipByIndex(i).getnoOfHitsMade();
                noOfHitsMade++;
                computerShips.getShipByIndex(i).setnoOfHitsMade(noOfHitsMade);
                if(computerShips.getShipByIndex(i).getnoOfHitsNeeded() == computerShips.getShipByIndex(i).getnoOfHitsMade())
                {
                    System.out.println("Congratulations,comp Ship "+ (i+1) + " has been destroyed");
                }else if(computerShips.getShipByIndex(i).getnoOfHitsNeeded() < computerShips.getShipByIndex(i).getnoOfHitsMade())
                {
                    System.out.println("The ship "+ (i+1) + " has already been destroyed before!! No score!!");
                    playerScore -= 10;
                }
                playerHit = true;
                break;
            }
        }
        if(playerHit)
        {
            System.out.println("Player HITTTTTTTTTT!");
            playerScore += 10;
        }else
        {
            System.out.println("Player MISSSSSSSSSS!");
        }
        return playerScore;
    }

    /**
     * The method to change state of player ships if computer make a correct guess, then print out message if any ship of player
     * is destroyed by this attack.
     * 
     * @param guessX The x position computer want to attack.
     * @param guessY The y position computer want to attack.
     * @param gridSize The width and height of the grid.
     * @param noOfShip The number of the ships the shiplist contains.
     * @param computerScore The current score of computer.
     * @return computerScore The score after computer make a guess.
     */
    private int computerHit(int guessx,int guessy,int  computerScore,int gridSize,int noOfShip)
    {
        boolean computerHit = false;
        Input input = new Input();

        for(int i = 0; i < playerShips.getNumberOfShips();i++)
        {
            if(guessx == playerShips.getShipByIndex(i).getxPos() && guessy == playerShips.getShipByIndex(i).getyPos() )
            {
                int noOfHitsMade = playerShips.getShipByIndex(i).getnoOfHitsMade();
                noOfHitsMade++;
                playerShips.getShipByIndex(i).setnoOfHitsMade(noOfHitsMade);
                if(playerShips.getShipByIndex(i).getnoOfHitsNeeded() <= playerShips.getShipByIndex(i).getnoOfHitsMade())
                {
                    System.out.println("Congratulations,player Ship "+ (i+1) + " has been destroyed");
                }
                computerHit = true;
                break;
            }
        }
        if(computerHit)
        {
            System.out.println("Computer HITTTTTTTTTT!");
            computerScore += 10;
        }else
        {
            System.out.println("Computer MISSSSSSSSSS!");
        }
        return computerScore;
    }
}
