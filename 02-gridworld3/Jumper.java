import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;

public class Jumper extends Actor{

    public Jumper(){
	super();
    }

    public boolean canMove(){
	Grid<Actor> grid  = getGrid();
	if (grid == null){
	    return false;
	}
	int dir = getDirection();
	Location place = ((getLocation()).getAdjacentLocation(dir)).getAdjacentLocation(dir);
	if (!grid.isValid(place)){
	    return false;
	}
	return grid.get(place) == null;
    }
    public void move(){
	Grid<Actor> grid = getGrid();
	int dir = getDirection();
	Location place = ((getLocation()).getAdjacentLocation(dir)).getAdjacentLocation(dir);
	moveTo(place);
    }
    public void turn(){
	setDirection(getDirection() + 90);
    }
    public void act(){
	if (canMove()){
	    move();
	}
	else{
	    turn();
	}
    }
}
