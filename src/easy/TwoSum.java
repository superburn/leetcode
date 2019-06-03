package easy;

//Description
//        Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

//        Tags: Array, Hash Table

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    //利用 HashMap 作为存储，键为目标值减去当前元素值，索引为值，比如 i = 0 时，
    // 此时首先要判断 nums[0] = 2 是否在 map 中，如果不存在，那么插入键值对 key = 9 - 2 = 7,
    // value = 0，之后当 i = 1 时，此时判断 nums[1] = 7 已存在于 map 中，那么取出该 value = 0 作为第一个返回值，
    // 当前 i 作为第二个返回值，具体代码如下所示。

    public static int[] twoSum(int[] nums, int target) {
            int length = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                final Integer value = map.get(nums[i]);
                if (value != null) {
                    return new int[]{value, i};
                }
                map.put(target - nums[i], i);
            }
        return null;
    }
}
