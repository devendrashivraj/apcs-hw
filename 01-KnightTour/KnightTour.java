public class KnightTour{   
    private boolean solved;
    private int[][] board;

    public KnightTour(int i, int j){
	solved = false;
	board = new int[i][j]; 
    }  

    public String toString(){
	String s = ""; 
	for(int i = 0; i < board.length; i++){ 
	    for(int j = 0; j < board[i].length; j++){ 
		s += board[i][j] + "   ";
	    }
	    s += "\n\n";
	}   
	return s;
    }

    private void delay(int i){ 
	try{ 
	    Thread.sleep(i); 
	} 
	catch(InterruptedException e){ 
	    System.exit(0); 
	} 
    }   

    private boolean isValidMove(int i, int j, int k, int l){ 
	try{
	    int test = board[i + k][j + l];
	} 
	catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
	return true;
    }

    public void solve(int i, int j, int k){ 
	if (k >= board.length * board[0].length + 1){ 
	    solved = true; 
	    System.out.println(this); 
	} 
	else if (board[i][j] == 0){ 
	    board[i][j] = k; 
	    if (isValidMove(i, j, 2, 1) && !solved) 
		solve(i + 2, j + 1, k + 1); 
	    if(isValidMove(i, j, -2, -1) && !solved) 
		solve(i - 2, j - 1, k + 1); 
	    if(isValidMove(i, j, 1, 2) && !solved) 
		solve(i + 1, j + 2, k + 1); 
	    if(isValidMove(i, j, -1, -2) && !solved) 
		solve(i - 1, j - 2, k + 1); 
	    if(isValidMove(i, j, 2, -1) && !solved) 
		solve(i + 2, j - 1, k + 1); 
	    if(isValidMove(i, j, -2, 1) && !solved) 
		solve(i - 2, j + 1, k + 1); 
	    if(isValidMove(i, j, 1, -2) && !solved) 
		solve(i + 1, j - 2, k + 1); 
	    if(isValidMove(i, j, -1, 2) && !solved) 
		solve(i - 1, j + 2, k + 1); 
	    board[i][j] = 0; 
	} 
    }   
    public static void main(String args[]){ 
	KnightTour board = new KnightTour(Integer.parseInt(args[0]), Integer.parseInt(args[1])); 
	System.out.println(board); 
	board.solve(0, 0, 1); 
    }
}


