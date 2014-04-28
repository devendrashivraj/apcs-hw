import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;

public class QuickCrab extends CrabCritter{

    public void makeMove(Location loc){
	Location right1, right2, left1, left2;
	right1 = loc.getAdjacentLocation(Location.RIGHT);
	right2 = right1.getAdjacentLocation(Location.RIGHT);
	left1 = loc.getAdjacentLocation(Location.LEFT);
	left2 = left1.getAdjacentLocation(Location.LEFT);
	double r = Math.random();
	if (r > 0.5){
	    if (right1.isEmpty() &&
		right2.isEmpty()){
		moveTo(right2);
		return;
	    }
	}
	else if (r <= 0.5){
	    if (left1.isEmpty() &&
		left2.isEmpty()){
		moveTo(left2);
		return;
	    }
	}
	super.makeMove(loc);
    }

}
