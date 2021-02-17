package vop;

import java.util.Arrays;

/**
 * @author erso
 * Udleveret kode skelet med main()-metode til opgave 4, VOP eksamen 10 juni 2016
 */
public class Mountain implements Comparable<Mountain> {


    private String name, height,prominence,latitude,longitude,range;


    public Mountain(String name, String height, String prominence, String latitude, String longitude, String range){
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.latitude = latitude;
        this.longitude = longitude;
        this.range = range;
    }


    @Override
    public String toString() {
         return this.name+ " h="+this.height+", pro="+this.prominence+", lat="+this.latitude+", lon="+this.longitude+", ran="+this.range;
    }

    @Override
    public int compareTo(Mountain o) {
        if(Integer.parseInt(this.prominence) < Integer.parseInt(o.prominence)){
            return 1;
        }else if (Integer.parseInt(this.prominence) > Integer.parseInt(o.prominence)){
            return -1;
        }else if (Integer.parseInt(this.prominence) == Integer.parseInt(o.prominence)){
            if(Integer.parseInt(this.height) < Integer.parseInt(o.height)){
                return 1;
            }else if(Integer.parseInt(this.height) > Integer.parseInt(o.height)){
                return -1;
            }else return 0;
        }return 0;
    }

    public int getRange(){
        if (this.range.equals("Alps ")){
            return 1;
        }else if (this.range.equals("Pyrenees ")){
            return 2;
        }
        else if(this.range.equals("Jura ")){
            return 3;
        }
        else if (this.range.equals("Vosges ")){
            return 4;
        }
        else if (this.range.equals("Massif Central ")){
            return 5;
        }
        else return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Til test af Mountain-klassen

        //Opg a Test af constructor og toString()
        // NB: \u00B0 er unicode for grade-tegnet
        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");
        System.out.println(m);

        // Opg b Test af compareTo()
        Mountain[] testArray = new Mountain[4];
        testArray[1] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees");
       testArray[0] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps");
       testArray[3] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps");
       testArray[2] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees");

        System.out.println("Usorteret: ");
        System.out.println(Arrays.toString(testArray));

        System.out.println("Sorteret: ");
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));

    }


}
