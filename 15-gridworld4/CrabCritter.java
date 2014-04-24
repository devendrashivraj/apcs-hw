import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class CrabCritter extends Critter{

    public CrabCritter(){
        setColor(Color.RED);
    }

    public ArrayList<Actor> getActors(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs = {Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT};
        for (Location loc : getLocationsInDirections(dirs)){
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
    }

    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs = {Location.LEFT, Location.RIGHT};
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
                locs.add(loc);
        return locs;
    }

    public void makeMove(Location loc){
        if (loc.equals(getLocation())){
            double r = Math.random();
	    if (r < 0.5)
		setDirection(getDirection() + Location.LEFT);
            else
		setDirection(getDirection() + Location.RIGHT);
	}
        else{
            super.makeMove(loc);
	}
    }
    
    public ArrayList<Location> getLocationsInDirections(int[] directions){
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
        for (int d : directions){
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }    
}
