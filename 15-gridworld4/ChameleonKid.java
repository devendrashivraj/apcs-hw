import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;

public class ChameleonKid extends ChameleonCritter{
    
    public void processActors(ArrayList<Actor> actors){
	Actor front = null, back = null;
	for (Actor a: actors){
	    if (getLocation().getDirectionToward(a.getLocation()) == 0){
		front = a;
	    }
	    else if (getLocation().getDirectionToward(a.getLocation()) == 180){
		back = a;
	    }
	}
	if (front == null &&
	    back == null){
	    super.processActors(new ArrayList<Actor>());
	}
	else if (front == null){
	    setColor(back.getColor());
	}
	else if (back == null){
	    setColor(front.getColor());
	}
	else{
	    Double r = Math.random();
	    if (r > 0.5){
		setColor(back.getColor());
	    }
	    else{
		setColor(front.getColor());
	    }
	}
    }

    


}
