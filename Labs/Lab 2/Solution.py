class Solution(object):
    def isAnagram(self, s, t):
        list1 = sorted(s)
        list2 = sorted(t)
        return list1==list2

solution = Solution()  
s = "listen"
t = "silent"
print(solution.isAnagram(s,t))
a = "isdff"
b = "bbbbb"
print(solution.isAnagram(a,b))