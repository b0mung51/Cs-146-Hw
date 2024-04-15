class Solution:
    @staticmethod
    def canFinish(numCourses, prerequisites):
        adjList = [[] for _ in range (numCourses)]
        for prereq in prerequisites:
            adjList[prereq[1]].append(prereq[0])

        visited = [0] * numCourses
        def dfs(course): #put it inside, so less parameters
            visited[course] = 1
            for nextCourse in adjList[course]:
                if visited[nextCourse] == 1: return False
                if visited[nextCourse] == 0 and not dfs(nextCourse):
                    return False # cycle in subtree
            visited[course]=2
            return True

        for i in range(numCourses):
            if visited[i] == 0 and not dfs(i): 
                return False #cycle
            
        return True
    
schedule = Solution()
print(schedule.canFinish(2, [[1,0]]))
print(schedule.canFinish(2,[[1,0], [0,1]]))
        