package vop;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class PrimaryController {


    public Button getInfo;
    public TextArea outputArea;
    public TextField input2;
    public TextField input1;
    public RadioButton square;
    public RadioButton circle;
    public RadioButton rectangle;
    public RadioButton ellipse;

    ToggleGroup tg = new ToggleGroup();


    public void initialize(){
        square.setToggleGroup(tg);
        circle.setToggleGroup(tg);
        rectangle.setToggleGroup(tg);
        ellipse.setToggleGroup(tg);

        square.setUserData(ShapeFacade.SHAPES.SQUARE);
        circle.setUserData(ShapeFacade.SHAPES.CIRCLE);
        rectangle.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        ellipse.setUserData(ShapeFacade.SHAPES.ELLIPSE);

    }

    public void print(MouseEvent event) {
        System.out.println("print");
    }

    private void checkButton(){

    }

    public void displayInfo(ActionEvent actionEvent){
        double p1 = Double.parseDouble(input1.getText());
        double p2 = 0;
        if(input2.isVisible()){
            p2 = Double.parseDouble(input2.getText());
        }else{
            p2 = p1;
        }

        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES)tg.getSelectedToggle().getUserData();

        outputArea.setText(ShapeFacade.getInstance().getShapeInfo(shape, p1, p2));

    }



    public void selected(ActionEvent actionEvent) {

        if(actionEvent.getSource() == square){
            input2.setVisible(false);
            input2.clear();
        }else if(actionEvent.getSource() == circle){
            input2.setVisible(false);
            input2.clear();
        }else{
            input2.setVisible(true);
        }

    }


}
