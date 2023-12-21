package software.ulpgc.kata6;

public class Board {
    public String state;

    public Board(String state){
        this.state = state;
    }

    public Board next(){
        return new Board("");
    }

    public String state(){
        return "";
    }
}

