/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Node curr = head;

        while(curr != null) {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        curr = head;
        Node nHead = head.next;

        while(curr != null) {
            Node copy = curr.next;
            if(curr.random != null) {
                copy.random = curr.random.next;
            }
            curr = copy.next;
        }

        curr = head;
        
        while(curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if(curr.next != null) {
                copy.next = curr.next.next;
            }
            curr = curr.next;
        }

        return nHead;
    }
}
