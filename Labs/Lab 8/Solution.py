from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        array = [float('inf')] * (amount +1)
        array[0] = 0
        for i in range(1, amount+1):
            for coin in coins:
                if coin <= i:
                    array[i] = min(array[i], 1+array[i-coin])
        
        return array[amount] if array[amount] != float('inf') else -1   
    
solution = Solution()
coins1 = [1, 2, 5]
amount1 = 11
print("Test Case 1:")
print("Input: coins =", coins1, ", amount =", amount1)
print("Output:", solution.coinChange(coins1, amount1))

coins2 = [2]
amount2 = 3
print("\nTest Case 2:")
print("Input: coins =", coins2, ", amount =", amount2)
print("Output:", solution.coinChange(coins2, amount2))