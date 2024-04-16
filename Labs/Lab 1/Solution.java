import java.util.*;

public class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                return new int[] {map.get(difference), i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }

    public static void main(String []args){
        Solution solution = new Solution();
        int[] nums = {3, 6, 2, 7};
        int target = 9;
        int [] index = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(index));
    }
}