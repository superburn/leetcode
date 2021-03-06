package easy;

//Description
//        Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//        Example 1:
//        Given nums = [1,1,2],
//        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//        It doesn't matter what you leave beyond the returned length.

//        Example 2:
//        Given nums = [0,0,1,1,1,2,2,3,3,4],
//        Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
//        It doesn't matter what values are set beyond the returned length.

//        Clarification:
//        Confused why the returned value is an integer but your answer is an array?
//        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
//
//        Internally you can think of this:
//        // nums is passed in by reference. (i.e., without making a copy)
//        int len = removeDuplicates(nums);
//
//       // any modification to nums in your function would be known by the caller.
//       // using the length returned by your function, it prints the first len elements.
//        for (int i = 0; i < len; i++) {
//        print(nums[i]);
//        }

//        Tags: Array, Two Pointers
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = removeDuplicates2(nums);
        System.out.println(count);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static Integer removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            } else {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
                i--;
            }
        }
        return count;
    }

//    题意是让你从一个有序的数组中移除重复的元素，并返回之后数组的长度。
//    我的思路是判断长度小于等于 1 的话直接返回原长度即可，否则的话遍历一遍数组，
//    用一个 tail 变量指向尾部，如果后面的元素和前面的元素不同，就让 tail 变量加一，最后返回 tail 即可。
    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int tail = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }
}
