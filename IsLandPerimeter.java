package otherProblems;

import java.util.HashMap;
import java.util.LinkedList;

public class IsLandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int perimeter = 0;
        int count = 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
//                    System.out.println("Column :: "+j+" Row ::"+i);
                    // Boundary conditions
                    return calculatePerimeter1(i,j,grid);
//                    perimeter+=calculatePerimeter(i,j,grid);
//                    count++;
                }
            }
        }
        System.out.println("Total visited Nodes :: "+ count);

        return perimeter;
    }

    public int calculatePerimeter1(int r, int c, int[][] grid){
        LinkedList<Pointer> stack = new LinkedList<Pointer>();
        Pointer p = new Pointer(r,c);

        int rowLength = grid.length;
        int columnLength = grid[0].length;

        stack.push(p);
        int perimeter = 0;
        HashMap<String, Boolean> visited = new HashMap();

        while(stack.peek()!=null){
            Pointer cP = stack.pop();
            int cR = cP.row;
            int cC = cP.column;

            if(!visited.containsKey(cR+"-"+cC)) {
                System.out.println("Column :: "+cC+" Row ::"+cR);
                visited.put(cR + "-" + cC, true);
            }
            else {
                continue;
            }

            perimeter+= calculatePerimeter(cR,cC,grid);

            if(cR+1< rowLength && grid[cR+1][cC] == 1 && !visited.containsKey(cR+1+""+cC)){
                Pointer p1 = new Pointer(cR+1,cC);
                stack.push(p1);
            }

            if(cC+1< columnLength && grid[cR][cC+1] == 1 && !visited.containsKey(cR+""+cC+1)){
                Pointer p4 = new Pointer(cR,cC+1);
                stack.push(p4);
            }

            if(cR >=1 && grid[cR-1][cC] == 1 && !visited.containsKey(cR-1+""+cC)){
                Pointer p2 = new Pointer(cR-1,cC);
                stack.push(p2);
            }

            if(cC >=1 && grid[cR][cC-1] == 1 && !visited.containsKey(cR+""+(cC-1))){
                Pointer p3 = new Pointer(cR,cC-1);
                stack.push(p3);
            }

        }
        System.out.println(visited.size());
        return perimeter;
    }

    public int calculatePerimeter(int r, int c , int[][] grid){
        int perimeter = 0;

        if(!(r<grid.length || c< grid[0].length))
            return perimeter;

        if((r+1< grid.length && grid[r+1][c] == 0) || (r == grid.length -1)){
            perimeter+=1;
        }

        if((r-1>=0 && grid[r-1][c] == 0) || r == 0 )
        {
            perimeter+=1;
        }

        if((c-1>=0 && grid[r][c-1] == 0) || c== 0){

            perimeter+=1;

        }

        if(((c+1< grid[0].length && grid[r][c+1] == 0) || (c== grid[0].length-1)) ){
            perimeter+=1;
        }


        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid =
                //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
                {{0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0}, //0
                 {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},  //1
                 {0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,0,1,1,0},  //2
                 {0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0},  //3
                 {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,0},  //4
                 {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},  //5
                 {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},  //6
                 {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},  //7
                 {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},  //8
                 {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},  //9
                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},  // 10
                 {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},  //11
                 {0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},  //12
                 {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},  //13
                 {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},  //15
                 {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},  //16
                 {0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0}, // 17
                 {0,0,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,0,0,0},  // 18
                 {0,0,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0}, // 19
                 {0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0}}; //20

        IsLandPerimeter isLandPerimeter = new IsLandPerimeter();
        System.out.print(isLandPerimeter.islandPerimeter(grid));

    }
}

class Pointer{
    int row;
    int column;

    public Pointer(int row, int column){
        this.row = row;
        this.column = column;
    }
}
