package software.ulpgc.kata6;

import java.util.List;

public class Board {
    private final static String LineBreak = "\n";
    public String[] state;
    private final static char DeadCell = '.';
    private final static char AliveCell ='X';

    public Board(String state){
        this(state.split(LineBreak));
    }

    public Board(String[] state) {
        this.state =state;
    }

    public Board next(){
        if(state[0].length() == 0) return new Board("");
        if(state.length == 1) return new Board(".");
        return new Board(calculate());
    }

    private String calculate() {
        String result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(shouldBeAlive(i,j)) result+= String.valueOf(AliveCell);
                else result+= String.valueOf(DeadCell);
            }
            result += LineBreak;
        }
        return result;
    }

    private boolean shouldBeAlive(int i, int j) {
        return isAlive(i,j) ?
                shouldKeepLiving(i,j) :
                shouldRevive(i,j);
    }

    private boolean shouldRevive(int i, int j) {
        return countAliveNeighbors(i,j) == 3;
    }

    private boolean shouldKeepLiving(int i, int j) {
        return countAliveNeighbors(i,j) == 2 || countAliveNeighbors(i,j) == 3;
    }

    private int countAliveNeighbors(int i, int j) {

        return (int) getNeighbors(i,j).stream().filter(integer -> integer==1).count();
    }

    private List<Integer> getNeighbors(int i, int j) {
        List<Integer> counter = List.of(
                isAlive(i -1, j -1) ? 1 : 0,
                isAlive(i -1, j) ? 1 : 0,
                isAlive(i -1, j +1) ? 1 : 0,
                isAlive(i, j -1) ? 1 : 0,
                isAlive(i, j +1) ? 1 : 0,
                isAlive(i +1, j -1) ? 1 : 0,
                isAlive(i +1, j) ? 1 : 0,
                isAlive(i +1, j +1) ? 1 : 0
        );
        return counter;
    }

    private boolean isAlive(int i, int j) {
        return isInBounds(i,j) && cellAt(i,j) == AliveCell;
    }

    private char cellAt(int i, int j) {
        return state[i].charAt(j);
    }

    private boolean isInBounds(int i, int j) {
        return i>= 0 && i < 2 && j >= 0 && j < 2;
    }

    public String state(){
        return String.join(LineBreak,state);
    }
}

