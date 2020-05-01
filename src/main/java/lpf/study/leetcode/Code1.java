package lpf.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code1 {
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    //示例:
    //给定 nums = [2, 7, 11, 15], target = 9
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    public static void main(String[] args) {
        int[] nums = {2, 71, 7, 15};
        int target = 9;
        int[] ints = twoSum2(nums, target);
        for (int i:ints) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //{2, 7, 11, 15};   9
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target-nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
