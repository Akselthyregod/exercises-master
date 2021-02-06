package vop;

import java.util.Arrays;
import java.util.List;

public class AtBashCipher extends AbstractCipher {


    @Override
    public String encrypt(String original) {
        String returnString="";
        for(int i=0; i<original.length(); i++){
            char c=original.charAt(i);
            if(contains(c)) {
                int index = findCharIndex(c);
                char enChar = ALPHABETH[ALPHABETH.length - index - 1];
                returnString += enChar;
            }else returnString+=c;
        }
        return returnString;
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
