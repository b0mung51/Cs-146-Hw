from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue  # Skip duplicates
            
            left, right = i + 1, len(nums) - 1
            while left < right:
                s = nums[i] + nums[left] + nums[right]
                if s == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1 
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1 
                    left += 1
                    right -= 1
                elif s < 0:
                    left += 1
                else:
                    right -= 1
        
        return result

solution = Solution()
nums1 = [-1, 0, 1, 2, -1, -4]
print(solution.threeSum(nums1)) 

nums2 = [0, 1, 1]
print(solution.threeSum(nums2))  

nums3 = [0, 0, 0]
print(solution.threeSum(nums3))  
