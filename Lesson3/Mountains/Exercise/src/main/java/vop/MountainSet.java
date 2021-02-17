package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MountainSet {

    static Set<Mountain> mountains;

    public MountainSet(){
        mountains= new TreeSet<>();

    }

    public Set getMountainSet(){
        return this.mountains;
    }

    public static void main(String[] args) throws FileNotFoundException {
        MountainSet mountainSet=new MountainSet();

        File bjerge= new File("C:\\GitHub\\exercises-master\\Lesson3\\Mountains\\Exercise\\src\\main\\resources\\vop\\FranskeBjerge.csv");
        Scanner scanner= new Scanner(bjerge);
        while(scanner.hasNextLine()){
            String line= scanner.nextLine();
            String [] words=line.split(";");
            mountains.add(new Mountain(words[0],words[1],words[2],words[3],words[4],words[5]));
        }
        mountains.forEach(e ->{
            System.out.println(e.toString());
        });
        System.out.println("------------------------------------------");
        Set<Mountain>rangeSet=new TreeSet<>(new MountainRangeComparator());
       mountains.forEach(e->{
            rangeSet.add((Mountain) e);
        });
        rangeSet.forEach(e->{
            System.out.println(e.toString());
        });
        //System.out.println(mountainSet.sortByRange(new MountainRangeComparator()));
    }


    public Set<Mountain> sortByRange(Comparator comp){
       return this.mountains=new TreeSet<Mountain>(comp);
    }
}
