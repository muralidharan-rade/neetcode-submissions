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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addOn = 0;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            int n1 = l1.val;
            int n2 = l2.val;
            int sum = n1 + n2 + addOn;
            if(sum > 9) {
                addOn = sum / 10;
                sum = sum % 10;
            } else {
                addOn = 0;
            }
            ListNode nn = new ListNode(sum);
            tail.next = nn;
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val + addOn;
            if(sum > 9) {
                addOn = sum / 10;
                sum = sum % 10;
            } else {
                addOn = 0;
            }
            ListNode nn = new ListNode(sum);
            tail.next = nn;
            tail = tail.next;

            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + addOn;
            if(sum > 9) {
                addOn = sum / 10;
                sum = sum % 10;
            } else {
                addOn = 0;
            }
            ListNode nn = new ListNode(sum);
            tail.next = nn;
            tail = tail.next;

            l2 = l2.next;
        }

        if(addOn > 0) {
            ListNode n = new ListNode(addOn);
            tail.next = n;
        }

        //return reverse(dummy.next);

        return dummy.next;
    }

    private ListNode reverse(ListNode root) {
        ListNode curr = root;
        ListNode prev = null;
        ListNode temp = null; 

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
