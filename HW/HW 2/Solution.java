public class Solution{
    public boolean isBadVersion(int n){ // created my own method for testing purposes based on the leet code problem
        return n>=4;
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left<right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String Args[]){
        Solution solution = new Solution();
        int n = 10;
        System.out.println(solution.firstBadVersion(n));
    }
}