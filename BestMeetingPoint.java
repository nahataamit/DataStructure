package otherProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 Example:

 Input:

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 6

 Explanation: Given three people living at (0,0), (0,4), and (2,2):
 The point (0,2) is an ideal meeting point, as the total travel distance
 of 2+2+2=6 is minimal. So return 6.
 Time Complexity o(mnlog(mn)) because of sorting
 Space Complexity O(mn)
 */
public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        List<Point> list = new ArrayList();
        int distance  = Integer.MAX_VALUE ;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    list.add(new Point(i,j));
            }
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y-o1.x;
            }
        });


        Collections.sort(list, new Comparator<Point>(){
            @Override
            public int compare(Point p1,Point p2){
                return p1.x-p2.x;
            }
        });

        Point midx = list.get(list.size()/2);
        int x = midx.x;

        Collections.sort(list, new Comparator<Point>(){
            @Override
            public int compare(Point p1,Point p2){
                return p1.y-p2.y;
            }
        });

        Point midy = list.get(list.size()/2);
        int y = midy.y;

        Point mid = new Point(x,y);
        distance = findDistance(list,mid);

        return distance;
    }

    public int findDistance(List<Point> points, Point midPoint){
        int dist = 0;

        for(Point point : points){

            dist += Math.abs((point.y-midPoint.y))+ Math.abs(point.x-midPoint.x);
        }

        return dist;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y =y;
        }
    }

    public static void main(String[] args){
        BestMeetingPoint bestMeetingPoint = new BestMeetingPoint();
        int[][] grid =  new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};

        System.out.println(bestMeetingPoint.minTotalDistance(grid));
    }
}
