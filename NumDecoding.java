package otherProblems;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class NumDecoding {
    public int numDecodings(String s) {
        if(s.length()==0 || s.startsWith("0"))return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1; i<dp.length; i++)
        {
            for(int j=i-1; j>=0&&j>i-3; j--)
            {
                String str = s.substring(j,i);
                if(Integer.valueOf(str)>=1&&Integer.valueOf(str)<=26&&!str.startsWith("0"))
                    dp[i]+=dp[j];
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        NumDecoding numDecoding = new NumDecoding();
        numDecoding.numDecodings("2216");
    }
}
