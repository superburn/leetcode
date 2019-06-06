package easy;

//Description
//        Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//        You may assume no duplicates in the array.
//
//        Example 1:
//        Input: [1,3,5,6], 5
//        Output: 2

//        Example 2:
//        Input: [1,3,5,6], 2
//        Output: 1

//        Example 3:
//        Input: [1,3,5,6], 7
//        Output: 4

//        Example 1:
//        Input: [1,3,5,6], 0
//        Output: 0

//        Tags: Array, Binary Search
public class SearchInsertPosition {
    public static int searchInsertPosition(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return len;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        int mid = (left + right) >> 1;
        while(left < right){
            if(target <= nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            mid = (left + right) >> 1;
        }
        return left;
    }
}
