from typing import List
class Solution:
    def minCostToSupplyWater(self, n:int, wells: List[int], pipes: List[List[int]]) -> int:
        edges = []
        for i in range(len(wells)):
            edges.append([0, i+1, wells[i]])

        for pipe in pipes:
            edges.append(pipe)
        
        edges.sort(key = lambda x: x[2])
        parent = [i for i in range(n+1)]

        cost = 0
        for edge in edges:
            u, v, weight = edge
            parentU = self.find(u,parent)
            parentV = self.find(v,parent)
            if parentU != parentV:
                cost += weight
                parent[parentU] = parentV
        
        return cost
    
    def find(self, x:int, parent: List[int]) -> int:
        if parent [x] != x:
            parent[x] = self.find(parent[x], parent)
        return parent[x]
    
solution = Solution()
# Test Case 1
n1 = 2
wells1 = [1, 1]
pipes1 = [[1, 2, 1], [1, 2, 2]]
output1 = solution.minCostToSupplyWater(n1, wells1, pipes1)
print("Test Case 1:", output1)  # should be 2

# Test Case 2
n2 = 3
wells2 = [1, 2, 2]
pipes2 = [[1, 2, 1], [2, 3, 1]]
output2 = solution.minCostToSupplyWater(n2, wells2, pipes2)
print("Test Case 2:", output2)  # should be 3