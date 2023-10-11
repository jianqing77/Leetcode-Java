package Sorting;

import Refresh_Data_Structure.Lists.ListNode;

public class Q147_Insertion_Sort_List {
  public ListNode insertionSortList(ListNode head) {
    // Checks if the input linked list is either empty or has only one element.
    // In such cases, the list is already sorted, so the method returns the input head.
    if (head == null || head.next == null) {
      return head;
    }

    // Declares a new ListNode called newHead,
    // which will serve as the head of the sorted portion of the list.
    ListNode newHead = null; // The head of the sorted portion

    // Initiates a loop to iterate through the original linked list.
    while (head != null) {
      //
      ListNode curr = head;
      head = head.next; // Move to the next element

      // Find the correct position to insert the current element in the sorted list
      if (newHead == null || curr.val < newHead.val) {
        curr.next = newHead;
        newHead = curr;
      } else {
        ListNode prev = newHead;
        while (prev.next != null && prev.next.val < curr.val) {
          prev = prev.next;
        }
        curr.next = prev.next;
        prev.next = curr;
      }
    }

    return newHead;
  }
}
