/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }

        if(head == null || head.next == null) {
            return head;
        }

        ListNode headCopy = head;

        ListNode pPrev = null;
        ListNode nNext = null;

        for (int i=1; i<left; i++) {
            if(i == 1) {
                pPrev = headCopy;
            } else if (pPrev != null) {
                pPrev = pPrev.next;
            }
        }

        for (int i=0; i<right; i++) {
            if(i == 0) {
                nNext = headCopy;
            }
            if (nNext != null) {
                nNext = nNext.next;
            }
        }

        int pos = 1;
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        ListNode tail = null;

        while(curr != null) {
            if (pos>=left && pos<=right) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                
            } else {
                curr = curr.next;
                
            }

            if(pos == left) {
                tail = prev;
            }

            if(pos == right) {
                headCopy = prev;
            }

            pos++;
        }

        if(pPrev != null) {
            pPrev.next = prev;
        }
        
        tail.next = nNext;

        if(left == 1) {
            return headCopy;
        }

        return head;
    }
}