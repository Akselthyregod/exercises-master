package vop;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    public TextField besked;
    public RadioButton bash;
    public RadioButton caesar;
    public Spinner spinner;
    public Button krypter;
    public Button dekrypter;
    public TextField output1;
    public TextField output2;
    AtBashCipher atBashCipher= new AtBashCipher();
    CaesarCipher b=new CaesarCipher(0);

    public void initialize(){


        spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0,
                        CipherInterface.ALPHABETH.length - 1,
                        CipherInterface.ALPHABETH.length / 2
                )
        );

        ToggleGroup tg= new ToggleGroup();
        bash.setToggleGroup(tg);
        caesar.setToggleGroup(tg);

    }


    public void krypter(ActionEvent actionEvent) {
        if(bash.isSelected()){
            output1.setText(atBashCipher.encrypt(besked.getText()));
        }
        if(caesar.isSelected()){
            checkSpinner();
            output1.setText(b.encrypt(besked.getText()));
        }
    }



    private void checkSpinner(){
        b= new CaesarCipher((Integer)spinner.getValue());
    }

    public void dekrypter(ActionEvent actionEvent) {
        if(bash.isSelected()){
            output2.setText(atBashCipher.decrypt(output1.getText()));
        }
        if(caesar.isSelected()){
            checkSpinner();
            output2.setText(b.decrypt(output1.getText()));
        }

    }
}
