import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;
import java.awt.*;

public class BlusterCritter extends Critter{
    private static int c;
    private static final double factor = 0.1;
    
    public BlusterCritter(int c){
	this.c = c;
    }
    
    public int getCourage(){
	return c;
    }

    public ArrayList<Actor> getActors(){
	ArrayList<Actor> roots = getGrid().getNeighbors(getLocation());
	ArrayList<Actor> actors = new ArrayList<Actor>();
	for (Actor a: roots){
	    for (Actor b: a.getGrid().getNeighbors(a.getLocation())){
		actors.add(b);
	    }
	}
	boolean truth = true;
	ArrayList<Actor> answer = new ArrayList<Actor>();
	for (Actor c: actors){
	    truth = true;
	    for (Actor d: answer){
		if (c.equals(d)){
		    truth = false;
		}
	    }
	    if (truth){
		answer.add(c);
	    }
	}
	for (int i = 0; i < answer.size(); i++){
	    if (answer.get(i).getLocation() == this.getLocation()){
		answer.remove(i);
		break;
	    }
	}
	return answer;
    }

    public void processActors(ArrayList<Actor> actors){
	Color c = getColor();
	int red = (int) (c.getRed() * (1 - factor));
	int green = (int) (c.getGreen() * (1 - factor));
	int blue = (int) (c.getBlue() * (1 - factor));
	if (actors.size() < this.getCourage()){
	    red = (int) (c.getRed() * (1 + factor));
	    green = (int) (c.getGreen() * (1 + factor));
	    blue = (int) (c.getBlue() * (1 + factor));
	}
	setColor(new Color(red, green, blue));
    }



}
