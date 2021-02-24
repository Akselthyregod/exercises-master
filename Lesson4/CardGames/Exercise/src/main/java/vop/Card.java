package vop;

/**
 * @author erso
 */
public class Card implements CardInterface {

    private int suit;
    private int face;

    public Card (int suit, int face)throws cardNotValidException{
        try{
           if(face<ACE||face>KING||suit<CLUBS||suit>SPADES){
               throw new cardNotValidException(face, suit);
           }
            this.suit=suit;
            this.face=face;
       }catch (cardNotValidException e){
           System.out.println(e);
       }
    }
    public String toString(){
        return"Face: "+ face+" Suit: "+suit;
    }

    public static void main(String[] args) throws cardNotValidException {
        System.out.println(new Card(1,3));
        System.out.println(new Card(3,1));
        System.out.println(new Card(13,4));
        System.out.println(new Card(12,3));
        System.out.println(new Card(17,5));

    }
}
