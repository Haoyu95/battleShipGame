import java.util.ArrayList;
/**
 * A simple modle of a list of ships.The ShipList class will specify the attributes and behaviours 
 * of all the ships within the game.
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class ShipList
{
    //An arraylist to store a list of ships.
    private ArrayList<Ship>ships;

    /**
     * Create a ShipList with default constructor.
     */
    public ShipList()
    {
        ships = new ArrayList<Ship>();
    }

    /**
     * Create a ShipList with non-default constructor.
     * @param ships A list of ships.
     */
    public ShipList(ArrayList<Ship>ships)
    {
        this.ships = ships;
    }

    /**
     * Set the list of ships.
     * @param ships A list of ships.
     */
    public void setShipList(ArrayList<Ship>ships)
    {
        this.ships = ships;
    }

    /**
     * Get a list of ships.
     * @return A list of ships it's store.
     */
    public ArrayList<Ship> getShipList()
    {
        return ships;
    }

    /**
     * Add a new Ship object to the ShipList.
     * 
     * @param shipName The name of the ship.
     * @param xPos The x coordinate of the ship,which indicate which line the ship is in the grid.
     * @param yPos The y coordinate of the ship,which indicate which row the ship is in the grid.
     * @param noOfHitsMade The number of hits the ship takes.
     * @param noOfHitsNeeded The number of hits needed to destory the ship.
     */
    public void addShip(String shipName,int xPos,int yPos,int noOfHitsMade,int noOfHitsNeeded)
    {
        Ship ship = new Ship(shipName,xPos,yPos,noOfHitsMade,noOfHitsNeeded);
        ships.add(ship);
    }

    /**
     * Get a ship object using its index.
     * @return A ship object.
     */
    public Ship getShipByIndex(int index)
    {
        return ships.get(index);
    }

    /**
     * Display all ship on a grid."O" means ship is undamaged,"D" means ship is damaged,"X" means ship 
     * is destroyed.
     */
    public void displayGrid(int gridSize,ArrayList<Ship>ships)
    {

        for(int i = 0; i < gridSize ;i++)
        {
            for(int j = 0; j < gridSize; j++)
            {
                for(Ship ship:ships)
                {
                    if(ship.getxPos() == j && ship.getyPos() == i)
                    {
                        if(ship.getnoOfHitsMade() == 0)
                        {
                            System.out.print("O");
                            j++;
                        }
                        else
                        {
                            if(ship.getnoOfHitsMade() < ship.getnoOfHitsNeeded())
                            {
                                System.out.print("D");
                                j++;
                            }
                            else
                            {
                                System.out.print("X");
                                j++;
                            }
                        }
                    }                
                }
                if(j < gridSize)
                {
                    System.out.print("~");
                }
            }
            System.out.println();
        }
    }

    /**
     * Check the state of the shiplist, and therefore to tell the result if the player or the computer
     * is win this game.
     * @param ships The shiplist you want to know whether all ships in this shiplist has been destroyed.
     * @return True if all ships in this shiplist has been destroyed,which means another side wins.
     */
    public boolean ifWin(ArrayList<Ship>ships)
    {
        boolean state = false;
        for(Ship ship:ships)
        {
            if(ship.getnoOfHitsMade() < ship.getnoOfHitsNeeded())
            {
                state = false;
                break;
            }
            else
            {
                state = true;
            }
        }
        return state;
    }

    /**
     * Get the number of ships stored in this shiplist.
     * @return The x coordinate of the ship.
     */
    public int getNumberOfShips()
    {
        return ships.size();
    }
}
