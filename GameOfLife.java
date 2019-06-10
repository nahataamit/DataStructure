package otherProblems;

import java.util.HashMap;
import java.util.Map;

public class GameOfLife {
    public void gameOfLife(int[][] board) {

        Map<String, Integer> futureMap =  new HashMap<>();


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int futureState = futureState(board[i][j],i,j,board);
                //board[i][j] = futureState;
                if(board[i][j] != futureState){
                    futureMap.put(i+"-"+j,futureState);
                }
            }
        }

        for(Map.Entry entry : futureMap.entrySet()){
            String key = (String)entry.getKey();
            int val = (int)entry.getValue();
            board[Integer.valueOf(key.split("-")[0])][Integer.valueOf(key.split("-")[1])] = val;

        }
    }

    public int futureState(int currentState,int i, int j, int[][] board){
        boolean isLive = currentState == 0 ? false : true;
        int liveNeiCount = 0;
        int futureState = 0;

        int lines = board.length;
        int col = board[0].length;

        for(int k = Math.max(i-1,0);k<=Math.min(i+1,lines-1);k++){
            for(int l = Math.max(j-1,0);l<=Math.min(j+1,col-1);l++){
                if(board[k][l] == 1)
                    liveNeiCount +=1;
            }
        }
        liveNeiCount = liveNeiCount -board[i][j];


        if(isLive){
            if(liveNeiCount<2)
                futureState = 0;
            else if(2<=liveNeiCount && liveNeiCount<=3)
                futureState = 1;
            else if(futureState >3)
                futureState = 0;
        }else{
            if(liveNeiCount == 3)
                futureState =1 ;
        }


        return futureState;
    }

    public static void main(String[] args){
        GameOfLife gameOfLife = new GameOfLife();
        int [][] board =  {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife.gameOfLife(board);
        System.out.print(board);
    }
}
