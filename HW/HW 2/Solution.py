class Solution:
    def __init__(self):
        pass

    def isBadVersion(self, version):
        # Assuming version 4 is the first bad version
        return version >= 4

    def firstBadVersion(self, n):
        left, right = 1, n
        while left < right:
            mid = left + (right - left) // 2
            if self.isBadVersion(mid):
                right = mid
            else:
                left = mid + 1
        return left

if __name__ == "__main__":
    solution = Solution()
    n = 10
    print(solution.firstBadVersion(n))
