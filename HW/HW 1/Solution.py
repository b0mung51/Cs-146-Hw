class Solution:
    def isPalindrome(self, s: str)->bool:
        s = ''.join(char.lower() for char in s if char.isalnum())
        left, right = 0, len(s)-1
        while left<right:
            if s[left] != s[right]: return False
            right -=1
            left +=1
        return True
    
solution = Solution()
s1 = "A man, nama"
s2 = "runner is a rennur"
print(solution.isPalindrome(s1))
print(solution.isPalindrome(s2))