package easy;

//Description
//        Merge two sorted linked lists and return it as a new list.
//        The new list should be made by splicing together the nodes of the first two lists.
//
//        Example:
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4

//        Tags: Linked List
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode merge = mergeTwoLists(l1,l4);
        while(merge != null){
            System.out.print(merge.val);
            merge = merge.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    //题意是用一个新链表来合并两个已排序的链表，那我们只需要从头开始比较已排序的两个链表，
    //新链表指针每次指向值小的节点，依次比较下去，最后，当其中一个链表到达了末尾，
    //我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
            head.next = mergeTwoLists(l1,l2);
        }else{
            head = l2;
            l2 = l2.next;
            head.next = mergeTwoLists(l1,l2);
        }
        return head;
    }

}
