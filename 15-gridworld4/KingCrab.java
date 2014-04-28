import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;

public class KingCrab extends CrabCritter{
    
    public void processActors(ArrayList<Actor> actors){
	for (Actor a: actors){
	    int dir = getLocation().getDirectionToward(a.getLocation());
	    Location loc = this.getLocation().getAdjacentLocation(dir);
	    if (loc == null){
		this.removeSelfFromGrid();
		return;
	    }
	    a.setLocation(loc);
	}
    }

}
