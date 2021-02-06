package vop;

public class CaesarCipher extends AbstractCipher {
    private int rotFactor;
    public CaesarCipher(int rotFactor){
        if(rotFactor<0){
            this.rotFactor=0;
        }
        this.rotFactor=rotFactor%ALPHABETH.length;
    }


    @Override
    public String encrypt(String original) {
        String returnString="";
        for(int i=0; i<original.length(); i++) {
            char c = original.charAt(i);
            if(contains(c)) {
                char c2 = ALPHABETH[(findCharIndex(c) + rotFactor) % ALPHABETH.length];
                returnString += c2;
            }
            else returnString+=c;
        }
       return returnString;
    }

    @Override
    public String decrypt(String encrypted) {
        String returnString="";
        for(int i=0; i<encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            if(contains(c)) {
                char c2 = ALPHABETH[(findCharIndex(c) - rotFactor+ALPHABETH.length) % ALPHABETH.length];
                returnString += c2;
            }
            else returnString+=c;
        }
        return returnString;
    }


}
