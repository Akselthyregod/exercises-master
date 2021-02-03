/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double p1, double p2) {
       // throw new UnsupportedOperationException("Not supported yet.");
        AbstractShape obj = null;

        if(shape == SHAPES.CIRCLE){
            obj = new Circle(p1);
        }else if(shape == SHAPES.SQUARE){
            obj = new Square(p1);
        }else if(shape == SHAPES.ELLIPSE){
            obj = new Ellipse(p1, p2);
        }else if(shape == SHAPES.RECTANGLE){
            obj = new Rectangle(p1, p2);
        }

        return obj.toString();
    }

}
