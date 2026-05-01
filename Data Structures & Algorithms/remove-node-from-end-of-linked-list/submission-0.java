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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int k = size - n;

        if(size == n) {
            return head.next; 
        }

        int count = 1; 
        ListNode temp = head; 

        while(temp != null) {
            if(count == k) {
                ListNode nn = temp.next.next;
                temp.next = nn;
                break;
            }
            count++;
            temp = temp.next;
        }

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;

        while(head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}
