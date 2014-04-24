import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;
import java.awt.*;

public class ChameleonCritter extends Critter{
    private static final double DARKENING_FACTOR = 0.1;

    public void processActors(ArrayList<Actor> actors){
	if (actors.size() == 0){
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    setColor(new Color(red, green, blue));
	    return;
	}
        int r = (int) (Math.random() * actors.size());
        Actor a = actors.get(r);
        setColor(a.getColor());
    }

    public void makeMove(Location loc){
        setDirection(getLocation().getDirectionToward(loc));
	super.makeMove(loc);
    }
}
