package vop;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PrimaryController implements Initializable {

    public AnchorPane anchorPane;
    public TextField søgField;
    public TextField erstatField;
    public Button replaceAllButton;
    public static Button openFileButton;
    public Button saveButton;
    public TextArea textArea;
    public static FileChooser fc;



    public void replaceAll(ActionEvent actionEvent) {
        String[] input = SearchAndReplace.toStringArray(textArea.getText());
        String[] output = SearchAndReplace.searchAndReplace(input, søgField.getText(), erstatField.getText());
        textArea.setText(SearchAndReplace.toString(output));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         fc = new FileChooser();
         fc.setInitialDirectory(new File("."));

    }

    public void openFile(ActionEvent actionEvent) throws FileNotFoundException {
            Window stage = anchorPane.getScene().getWindow();
            File selectedFile = fc.showOpenDialog(stage);

            textArea.setText(SearchAndReplace.toString(SearchAndReplace.toStringArray(selectedFile)));

    }

    public void saveFile(ActionEvent actionEvent) throws FileNotFoundException {
        Window stage = anchorPane.getScene().getWindow();
        File selectedFile = fc.showSaveDialog(stage);
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fc.getExtensionFilters().add(extFilter);

        PrintWriter pw = new PrintWriter(selectedFile);
        String[] stringArr = SearchAndReplace.toStringArray(textArea.getText());
        pw.print(SearchAndReplace.toString(stringArr));
        pw.close();
    }
}
