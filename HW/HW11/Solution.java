public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        
        int row = image.length; 
        int col = image[0].length; 
        int targetColor = image[sr][sc];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        dfs(image, sr, sc, row, col, targetColor, color, directions);
        return image;
    } 
    
    private void dfs(int[][] image, int x, int y, int row, int col, int targetColor, int newColor, int[][] directions) {
        if (x < 0 || x >= row || y < 0 || y >= col || image[x][y] != targetColor) {
            return; 
        }
        
        image[x][y] = newColor; 
        
        
        for (int[] dir : directions) { //other option is to explicitly call dfs 4 times with dif directions
            int a = x + dir[0];
            int b = y + dir[1];
            dfs(image, a, b, row, col, targetColor, newColor, directions);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = solution.floodFill(image, sr, sc, color);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }

        System.out.println();
        Solution solution1 = new Solution();
        int[][] image1 = {{0, 0, 0},
                         {0, 0, 0},
                         {0, 0, 0}};
        int sr1 = 0;
        int sc1 = 0;
        int color1 = 0;
        int[][] result1 = solution1.floodFill(image1, sr1, sc1, color1);
        for (int[] row : result1) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
