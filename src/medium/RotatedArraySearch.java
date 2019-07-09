package medium;

//         假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//        搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//        你可以假设数组中不存在重复的元素。
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        示例 1:
//        输入: nums = [4,5,6,7,0,1,2], target = 0
//        输出: 4

//        示例 2:
//        输入: nums = [4,5,6,7,0,1,2], target = 3
//        输出: -1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class RotatedArraySearch {

//    整体思路：先用二分法找出最小值，也是那个分割点,例如 [4,5,6,7,0,1,2]，我们找出数字 0；
//    接下来判断 target 是在分割点的左边还是右边;
//    最后再使用一次二分法找出 target 的位置. 所以时间复杂度为：O(logn)

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int split_t = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[split_t] && target <= nums[right]) {
            left = split_t;
        } else {
            right = split_t;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
