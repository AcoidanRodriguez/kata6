package software.ulpgc.kata6;

public class Board {
    public String state;

    public Board(String state){
        this.state = state;
    }

    public Board next(){
        if(state.equals(".")) return new Board(".");
        return new Board("");
    }

    public String state(){
        return state;
    }
}

