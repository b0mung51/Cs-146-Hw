class Solution:
    def floodFill(self, image, sr, sc, color):
        if image[sr][sc] == color: return image

        row = len(image)
        col = len(image[0])
        targetColor = image[sr][sc]
        directions = [(1,0), (-1,0), (0,1), (0,-1)]

        self.dfs(image, sr, sc, row, col, targetColor, color, directions)
        return image
    
    def dfs(self, image, x, y, row, col, targetColor, newColor, directions):
        if x<0 or x>=row or y<0 or y>=col or image[x][y] != targetColor: return
        image[x][y] = newColor

        for dx, dy in directions:
            a = x + dx
            b = y + dy
            self.dfs(image, a, b, row, col, targetColor, newColor, directions)

if __name__ == '__main__':
    solution = Solution()
    image = [[1, 1, 1],
            [1, 1, 0],
            [1, 0, 1]]
    sr = 1
    sc = 1 
    color = 2

    result = solution.floodFill(image, sr, sc, color)
    for row in result:
        for pixel in row:
            print(pixel, end = " ")
        print()
    
    solution1 = Solution()
    image1 = [[0, 0, 0],
            [0, 0, 0],
            [0, 0, 0]]
    sr1 = 0
    sc1 = 0 
    color1 = 0

    print()
    result1 = solution1.floodFill(image1, sr1, sc1, color1)
    for row in result1:
        for pixel in row:
            print(pixel, end = " ")
        print()