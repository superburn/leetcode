package easy;

//反转一个单链表。
//        示例:
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL

public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


//    时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
//    空间复杂度：O(1)。
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

//    时间复杂度：O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
//    空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
