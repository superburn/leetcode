package medium;

//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//        判断你是否能够到达最后一个位置。
//
//        示例 1:
//
//        输入: [2,3,1,1,4]
//        输出: true
//        解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
//        示例 2:
//
//        输入: [3,2,1,0,4]
//        输出: false
//        解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

public class CanJump {

//    这个题我们可以从后往前分析，首先判断倒数第二个元素能否到达最后一个元素，如果可以，
//    我们将不再考虑最后一个元素， 因为根据刚才的分析如果可以到达倒数第二个，那么也可以到达最后一个元素。
//    然后依次往前递推，如果都能跳到的话，我们最后应该分析的就是第一个元素能否跳到第二个元素上。
//    这个比较符合动态规划的思想，我们先用动态规划解下这道题。

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

//    分析上面的代码，可以看出使用动态规划的时间复杂度是O(n^2)，空间复杂度是O(n)。
//
//    下面我们使用贪心的思路看下这个问题，我们记录一个的坐标代表当前可达的最后节点，
//    这个坐标初始等于nums.length-1， 然后我们每判断完是否可达，都向前移动这个坐标，直到遍历结束。
//
//    如果这个坐标等于0，那么认为可达，否则不可达。

    public boolean canJump2(int[] nums) {
        if (nums == null) {
            return false;
        }

        int lastPosition = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

//    这段代码的时间复杂度是O(n)，空间复杂度是O(1)，可以看出比动态规划解法有了明显的性能提升。
}
