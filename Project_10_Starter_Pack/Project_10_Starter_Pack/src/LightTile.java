import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

public class LightTile extends JButton {
    public static Color litColor = Color.RED;
    public static Color darkColor = Color.GRAY;
    public static String litUpText = "On";
    public static String turnedOffText = "";
    private boolean isLitUp;//set to true if tile should be lit up, false otherwise
    private ArrayList<LightTile> neighbors;//keeps track of all neighboring tiles on the board, including diagonal neighbors.  Ranges in size from 4 to 8 depending on the tile.
  /**
   * A Constructor
   * @param lightStatus 
   */
    public LightTile(boolean lightStatus)
    {
        isLitUp = lightStatus;
        neighbors = new ArrayList<LightTile>();
        updateAppearance();
          
    }
   
    /**
     * updates the visual appearance of the button
     */
    public void updateAppearance()
    {
    
       
       if(isLitUp==true)
       {
        this.setText(litUpText);
     this.setBackground(litColor);

       }
       else 
       {
          this.setText(turnedOffText);
          this.setBackground(darkColor);
       }


        
    }
    
    /**
     * Toggles this switch on to off or off to on, and updates appearance
     */
    public void toggle()
    {
       //you supply code here
       if (isLitUp==true)
       {
        setTile(false);
       }
       else 
       {
          setTile(true);
       }


    }
    
/**
 * Your PressListener should class this method, which
 * ought to toggle this button AND all its neighbors.
 */
    public void press()
     {
        for (LightTile neighborTile :neighbors){
            neighborTile.toggle();
            
           // neighborTile.updateAppearance();

        }
       this.toggle();
       //this.updateAppearance();
        

    }
    
    public void addNeighbor(LightTile newNeighbor)
    {
        neighbors.add(newNeighbor);
    }
    
    public ArrayList<LightTile> getNeighbors()
    {
        return neighbors;
    }
    
    /**
     * Provides a means of re-setting a button to a specific value,
     * not just toggling from one to another.  Also should update its 
     * appearance.
     * 
     * This will be useful for the newGameButton and the turnAllOffButton.
     * @param value 
     */
    
    public void setTile(boolean value)
    {
       //you supply code here
       isLitUp= value;
       updateAppearance();
    }

            
}
