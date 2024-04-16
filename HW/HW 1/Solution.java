public class Solution{
    public boolean isPalindrome(String s){
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        String s1 = "A man, nama";
        String s2 = "runner is a rennur";
        System.out.println(solution.isPalindrome(s1));
        System.out.println(solution.isPalindrome(s2));
    }
}