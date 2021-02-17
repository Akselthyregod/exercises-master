package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MountainSet  {

    private Set<Mountain> mountains;

    public MountainSet(){
        mountains= new TreeSet<>();

    }

    public Set<Mountain> getMountainSet(){
        return this.mountains;
    }

    public void setMountains(Set<Mountain> in){
        this.mountains = in;
    }

    public static void main(String[] args) throws FileNotFoundException {
        MountainSet mountainSet=new MountainSet();
        Set<Mountain> ms = mountainSet.getMountainSet();


        // C:\Users\Aksel\GitHub\exercises-master\Lesson3\Mountains\Exercise\src\main\resources\vop\FranskeBjerge.csv
        File bjerge= new File("C:\\Users\\Aksel\\GitHub\\exercises-master\\Lesson3\\Mountains\\Exercise\\src\\main\\resources\\vop\\FranskeBjerge.csv");

        Scanner scanner= new Scanner(bjerge);

        while(scanner.hasNextLine()){
            String line= scanner.nextLine();
            String [] words=line.split(";");
            ms.add(new Mountain(words[0],words[1],words[2],words[3],words[4],words[5]));
        }

        ms.forEach(e ->{
            System.out.println(e.toString() + " Range:" + e.getRange());
        });

        mountainSet.setMountains(ms);

        System.out.println("------------------------------------------");
       /* Set<Mountain> rangeSet = new TreeSet<>(new MountainRangeComparator());

        rangeSet.addAll(ms);


        System.out.println(rangeSet.size());

        rangeSet.forEach(e->{
            System.out.println(e.toString());

        });*/

        System.out.println(mountainSet.getMountainSet().size());

        System.out.println(mountainSet.sortByRange(new MountainRangeComparator()));

    }


    public Set<Mountain> sortByRange(Comparator comp) {

        Set<Mountain> sorted = new TreeSet<>(comp);
        sorted.addAll(mountains);
        return sorted;
    }

    /*public Set<Mountain> idiotSort(Set<Mountain> in){
        int alps = 0;
        int pyrenees = 0;
        int jura = 0;
        int vosges = 0;
        int massifCentral = 0;

        for ( Mountain m :
                in ) {
            if(m.getRange() == 1){
                alps++;
            }else if (m.getRange() == 2){
                pyrenees++;
            }else if (m.getRange() == 3){
                jura++;
            }else if (m.getRange() == 4){
                vosges++;
            }else if (m.getRange() == 5){
                massifCentral++;
            }
        }

        Set<Mountain> sortedByRange = new TreeSet<>();

    }*/
}
