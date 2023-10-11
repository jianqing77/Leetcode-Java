package Refresh_Data_Structure.Lists;

public class ListNode {

  // Declaration of an integer variable named 'val'
  public int val;
  // Declaration of a reference variable named 'next' of type 'ListNode'
  public ListNode next;
  // Default constructor with no parameters
  ListNode() {}
  // Constructor with one parameter 'val' of type 'int'
  // Assign the value passed to 'val' attribute
  ListNode(int val) {
      this.val = val;
    }
  // Constructor with two parameters: 'val' and 'next'
  ListNode(int val, ListNode next) {
      this.val = val;                 // Assign 'val' parameter to 'val' attribute
      this.next = next;               // Assign 'next' parameter to 'next' attribute
  }

  public static void main(String[] args) {
    // Create nodes
    ListNode node1 = new ListNode(10);
    ListNode node2 = new ListNode(20);
    ListNode node3 = new ListNode(30);
    ListNode node4 = new ListNode(40);

    // Build the linked list: node1 -> node2 -> node3 -> node4
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    // Traverse and print the linked list
    ListNode head = node1;
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }

  }

}
