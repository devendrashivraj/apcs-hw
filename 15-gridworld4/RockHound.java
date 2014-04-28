import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;

public class RockHound extends Critter{
    
    public void processActors(ArrayList<Actor> actors){
	for (Actor a: actors){
	    if (a instanceof Rock){
		a.removeSelfFromGrid();
	    }
	}
    }
}
