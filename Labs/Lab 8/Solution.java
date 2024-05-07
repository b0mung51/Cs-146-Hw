import java.util.Arrays;

public class Solution{
    public int coinChange(int[] coins, int amount) {
        int [] array = new int[amount+1];
        Arrays.fill(array, amount+1);
        array[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int coin:coins){
                if(coin <= i){
                    array[i]=Math.min(array[i],1+array[i-coin]);
                }
            }
        }
        if(array[amount]<=amount) return array[amount];
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Test Case 1:");
        System.out.println("Input: coins = " + Arrays.toString(coins1) + ", amount = " + amount1);
        System.out.println("Output: " + solution.coinChange(coins1, amount1));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: coins = " + Arrays.toString(coins2) + ", amount = " + amount2);
        System.out.println("Output: " + solution.coinChange(coins2, amount2));
    }
}