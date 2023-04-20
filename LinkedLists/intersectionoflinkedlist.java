package LinkedLists;
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
//https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34
public class intersectionoflinkedlist {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // OPTIMAL APPROACH 1-> DIFFERENCE METHOD
        // int len1=0;
        // int len2=0;
        // ListNode temp1= headA;
        // while(temp1!=null){
        // temp1 = temp1.next;
        // len1++;
        // }
        // ListNode temp2= headB;
        // while(temp2!=null){
        // temp2 = temp2.next;
        // len2++;
        // }
        // int diff = len1 - len2;
        // if(diff < 0){
        // while(diff++ !=0){
        // headB= headB.next;
        // }
        // }
        // else {
        // while(diff-- !=0){
        // headA = headA.next;
        // }
        // }
        // while(headA!= null){
        // if(headA == headB){
        // return headA;
        // }
        // headA= headA.next;
        // headB= headB.next;
        // }
        // return null;

        // Better Appraoch = using Hashing
        // HashSet<ListNode> set= new HashSet<>();
        // while(headA!= null){
        // set.add(headA);
        // headA= headA.next;
        // }
        // while(headB!=null){
        // if(set.contains(headB)){
        // return headB;
        // }
        // headB= headB.next;
        // }

        // return null;

        // OPTIMAL APPROACH 2
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;

    }
}
