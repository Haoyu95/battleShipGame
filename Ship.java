
/**
 * A simple modle of a ship.The Ship class will specify the attributes and behaviours 
 * of all ships within the game. 
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class Ship
{
    //The name of the ship.
    private String shipName;
    //The x coodinate of the ship.
    private int xPos;
    //The y coodinate of the ship.
    private int yPos;
    //The number of hits taken by ship.
    private int noOfHitsMade;
    //The number of hits needed to destory the ship.
    private int noOfHitsNeeded;

    /**
     * Create a Ship with default constructor.
     */
    public Ship()
    {
        shipName = "";
        xPos = 0;
        yPos = 0;
        noOfHitsMade = 0;
        noOfHitsNeeded = 0;
    }

    /**
     * Create a Ship with non-default constructor.
     * 
     * @param shipName The name of the ship.
     * @param xPos The x coordinate of the ship,which indicate which column the ship is in the grid.
     * @param yPos The y coordinate of the ship,which indicate which row the ship is in the grid.
     * @param noOfHitsMade The number of hits the ship takes.
     * @param noOfHitsNeeded The number of hits needed to destory the ship.
     */
    public Ship(String shipName,int xPos,int yPos,int noOfHitsMade,int noOfHitsNeeded)
    {

        this.shipName = shipName;
        this.xPos = xPos;
        this.yPos = yPos; 
        this.noOfHitsMade = noOfHitsMade;
        this.noOfHitsNeeded = noOfHitsNeeded;

    }

    /**
     * Set the name of the ship.
     * @param shipName The name to rename the ship
     */
    public void setshipName(String shipName)
    {
        this.shipName = shipName;       
    }

    /**
     * Get the name of the ship.
     * @return The name of the ship.
     */
    public String getshipName()
    {
        return shipName;
    }

    /**
     * Set the x coodinate of the ship.
     * @param xPos The new x coordinate for the ship
     */
    public void setxPos(int xPos)
    {           
        this.xPos = xPos;
    }

    /**
     * Get the x coordinate of the ship.
     * @return The x coordinate of the ship.
     */
    public int getxPos()
    {   
        return xPos;
    }

    /**
     * Set the y coodinate of the ship.
     * @param yPos The new y coordinate for the ship.
     */
    public void setyPos(int yPos)
    {           
        this.yPos = yPos;
    }

    /**
     * Get the y coordinate of the ship.
     * @return The y coordinate of the ship.
     */
    public int getyPos()
    {   
        return yPos;
    }

    /**
     * Set the number of hits taken by ship.
     * @param noOfHitsMade The new number of hits taken by ship.
     */
    public void setnoOfHitsMade(int noOfHitsMade)
    {           
        this.noOfHitsMade = noOfHitsMade;
    }

    /**
     * Get the number of hits taken by ship.
     * @return The number of hits taken by ship.
     */
    public int getnoOfHitsMade()
    {   
        return noOfHitsMade;
    }

    /**
     * Set the number of hits needed to destory a ship.
     * @param noOfHitsNeeded The new number of hits needed to destory a ship.
     */
    public void setnoOfHitsNeeded(int noOfHitsNeeded)
    {           
        this.noOfHitsNeeded = noOfHitsNeeded;
    }

    /**
     * Get the number of hits needed to destory a ship.
     * @return The number of hits needed to destory a ship.
     */
    public int getnoOfHitsNeeded()
    {   
        return noOfHitsNeeded;
    }
    
    /**
     * Display values of attributes of a ship.
     */
    public void displayShip()
    {
      System.out.println("ship name: " + shipName);
      System.out.println("ship's x position: " + xPos);
      System.out.println("ship's y position: " + yPos);
      System.out.println("ship's noOfHitsMade: " + noOfHitsMade);
      System.out.println("ship's noOfHitsNeeded: " + noOfHitsNeeded);
    }
}
