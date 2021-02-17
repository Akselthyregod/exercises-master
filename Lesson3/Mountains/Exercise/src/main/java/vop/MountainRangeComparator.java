package vop;

import java.util.Comparator;

public class MountainRangeComparator implements Comparator<Mountain> {


    @Override
    public int compare(Mountain o1, Mountain o2) {
       if(o1.getRange()< o2.getRange()){
           return 1;
       }else if (o1.getRange()>o2.getRange()){
           return -1;
       }else return 0;
    }
}
