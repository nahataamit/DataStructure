package otherProblems;

/**
 * A.length >= 3
 There exists some i with 0 < i < A.length - 1 such that:
 A[0] < A[1] < ... A[i-1] < A[i]
 A[i] > A[i+1] > ... > A[B.length - 1]
 */

public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if(A.length<3)
            return false;

        if(A.length > 10000)
            return false;

        boolean hasSlop = false;
        boolean hasPeak = false;
        int previous = -1;

        for(int i=0;i<A.length;i++){

            if(!(i+1 < A.length))
                break;

            if(previous < A[i] &&  A[i] > A[i+1] && previous != -1){
                hasPeak = true;
                hasSlop = true;
            }else if(!hasPeak && A[i] < A[i+1]  ){
                hasSlop = true;
            }else if(hasPeak && A[i] > A[i+1] ){
                hasSlop = true;
            }else {
                hasSlop = false;
            }

            previous = A[i];

            if(!hasSlop)
                break;


        }
        return hasSlop && hasPeak;
    }


    public static void main(String[] args){
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] A = {9,8,7,6,5,4,3,2,1,0};
        System.out.print(validMountainArray.validMountainArray(A));


    }
}
