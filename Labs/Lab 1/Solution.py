class Solution:
    def twoSum(self, nums, target):
        dictionary = {}
        for i,num in enumerate(nums):
            difference = target - num
            if difference in dictionary: 
                return [dictionary[difference],i]
            dictionary[num] = i

        return []
    
solution = Solution()
nums = [3, 6, 2, 7]
target = 9
index = solution.twoSum(nums,target)
print(index)