package otherProblems.MergeInetrvals;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2 ){
                return i1.start-i2.start;
            }
        });

        List<Interval> result = new ArrayList();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        for(Interval interval : intervals)
        {

            if(interval.start <= end){ // Overlapping interval move the end if needed
                end = Math.max(end, interval.end);
            }else { // Disjoint intervals, add the previous and reset the bounds
                result.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }

        }

        // add the last interval
        result.add(new Interval(start,end));

        return result;
    }

    public static void main(String[] args){
        //[[1,3],[2,6],[4,10],[5,18]]
//        MergeIntervals mergeIntervals = new MergeIntervals();
//        List<Interval> list =  new ArrayList<>();
//        Interval i =  new Interval(5,18);
//
//        list.add(i);
//        i= new Interval(2,6);
//        list.add(i);
//        i = new Interval(4,10);
//        list.add(i);
//         i =  new Interval(1,3);
//        list.add(i);
//
//        mergeIntervals.merge(list);

        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
        simpleDateFormat.format(now, stringBuffer, new FieldPosition(0));
        String startTime =  stringBuffer.toString();
        System.out.println(startTime);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);


    }


}


   class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
