package easy;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//        示例:
//        输入: [-2,1,-3,4,-1,2,1,-5,4],
//        输出: 6
//        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/maximum-subarray
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

//    public static int maxSubArray(int[] nums) {
//        int len = nums.length;
//        if (len == 1) return nums[0];
//        int max = nums[0];
//        for (int i = 0; i < len; i++) {
//            int currSum = 0;
//            for (int j = i; j < len; j++) {
//                currSum += nums[j];
//                max = Math.max(currSum, max);
//            }
//        }
//        return max;
//    }


//    思路
//    这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
//    动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
//    如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
//    如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
//    每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
//    时间复杂度：O(n)O(n)
//
//    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

//    分治法： 通过递归分治不断的缩小规模，问题结果就有三种，左边的解，右边的解，
//    以及中间的解（有位置要求，从中介mid向两边延伸寻求最优解），得到三个解通过比较大小，等到最优解。
//
//    作者：fu-shi-san-qian
//    链接：https://leetcode-cn.com/problems/two-sum/solution/dong-tai-di-gui-fa-he-fen-zhi-jie-jue-by-fu-shi-sa/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int maxSubArray2(int[] nums) {
        return maxSubArrayPart(nums, 0, nums.length - 1);
    }

    private int maxSubArrayPart(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        return Math.max(
                maxSubArrayPart(nums, left, mid),
                Math.max(
                        maxSubArrayPart(nums, mid + 1, right),
                        maxSubArrayAll(nums, left, mid, right)
                )
        );
    }

    //左右两边合起来求解
    private int maxSubArrayAll(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
}
