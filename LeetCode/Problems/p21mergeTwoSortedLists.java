package Problems;


import java.util.List;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static void main(String args[]){
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(6);
        ListNode five = new ListNode(8);
        ListNode six = new ListNode(10);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        ListNode secondOne = new ListNode(1);
        ListNode secondTwo = new ListNode(3);
        ListNode secondThree = new ListNode(5);
        ListNode secondFour = new ListNode(7);
        ListNode secondFive = new ListNode(9);
        ListNode secondSix = new ListNode(11);
        secondOne.next = secondTwo;
        secondTwo.next = secondThree;
        secondThree.next = secondFour;
        secondFour.next = secondFive;
        secondFive.next = secondSix;

        ListNode result = mergeTwoLists(one, secondOne);

        while(result.next != null) {
            System.out.print(result.val + ", ");
        }
    }
}
