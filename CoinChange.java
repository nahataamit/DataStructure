package otherProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount+1]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem] != 0) return count[rem];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }
//    public int coinChange(int[] coins, int amount) {
//        if(amount<0 || coins.length == 0)
//            return -1;
//
//        Arrays.sort(coins);
//
//        int len = coins.length;
//        int total = 0;
//        int coin = 0;
//        while(len>0) {
//            coin=0;
//            int amt = amount;
//            total = 0;
//            for (int i = len - 1; i >= 0; i--) {
//                int reminder = amt % coins[i];
//                int count = amt / coins[i];
//                if (reminder >= 0 && count > 0) {
//                    coin += count;
//                    total += coins[i] * count;
//                    amt = reminder;
//                }
//                if (amt == 0)
//                    break;
//            }
//
//            if(amt!=0)
//                len--;
//        }
//
//        return total == amount?coin:-1;
//    }
//public int coinChange(int[] coins, int amount) {
//    if(amount<1) return 0;
//    int[] count = new int[amount];
//    int coin = helper(coins, amount, count);
//    return coin;
//}
//
//    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
//        if(rem<0) return -1; // not valid
//        if(rem==0) return 0; // completed
//        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
//        int min = Integer.MAX_VALUE;
//        for(int coin : coins) {
//            int res = helper(coins, rem-coin, count);
//            if(res>=0 && res < min)
//                min = 1+res;
//        }
//        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
//        return count[rem-1];
//    }

    public static void main(String[] args){
        CoinChange coinChange= new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2}, 2));
        String test = "test";
        Character.isDigit('1');
        HashSet<String> set = new HashSet<>();
        HashMap<Character,String> map  = new HashMap<>();
        Set<Map.Entry<Character,String>> entrySet = map.entrySet();

        for(Map.Entry<Character,String> entry : entrySet){

        }
    }
}
