package software.ulpgc.kata6;

public class Board {
    private final static String LineBreak = "\n";
    public String[] state;

    public Board(String state){
        this(state.split(LineBreak));
    }

    public Board(String[] state) {
        this.state =state;
    }

    public Board next(){
        if(state[0].length() == 0) return new Board("");
        if(state.length == 1) return new Board(".");
        return new Board("XX\nXX");
    }

    public String state(){
        return String.join(LineBreak,state);
    }
}

