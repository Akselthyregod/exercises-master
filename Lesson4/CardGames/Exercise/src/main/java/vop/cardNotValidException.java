package vop;

public class cardNotValidException extends Exception {
    int face;
    int suit;
    public cardNotValidException(int face, int suit){
        this.face=face;
        this.suit=suit;
    }

    public String toString(){
        return "cardNotValidException"+"["+ face+" "+suit+"]";
    }
}
