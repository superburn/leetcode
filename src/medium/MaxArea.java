package medium;

//11题

//双指针法
//        算法
//
//        这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。
//        此外，两线段距离越远，得到的面积就越大。
//        我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
//        此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
//        在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，
//        并将指向较短线段的指针向较长线段那端移动一步。
public class MaxArea {

//    时间复杂度：O(n)，一次扫描。
//    空间复杂度：O(1)，使用恒定的空间。
    public int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        int i = 0, j = len - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
