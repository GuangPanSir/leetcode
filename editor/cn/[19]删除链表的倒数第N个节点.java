package cn;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1160 👎 0

public class 删除链表的倒数第N个节点 {
	public static void main ( String[] args ) {
		Solution solution = new 删除链表的倒数第N个节点 ( ).new Solution ( );
	}

//leetcode submit region begin(Prohibit modification and deletion)
	
	
	//  Definition for singly-linked list.
	 /*class ListNode {
		int val;
		ListNode next;
		
		ListNode ( ) {
		}
		
		ListNode ( int val ) {
			this.val = val;
		}
		
		ListNode ( int val , ListNode next ) {
			this.val = val;
			this.next = next;
		}
	}*/
	
	class Solution {
		public ListNode removeNthFromEnd ( ListNode head , int n ) {
			ListNode dummy = new ListNode ( 0 , head );
			int length = getLength ( head );
			ListNode cur = dummy;
			for ( int i = 1 ; i < length - n + 1 ; ++i ) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
			ListNode ans = dummy.next;
			return ans;
		}
		
		public int getLength ( ListNode head ) {
			int length = 0;
			while ( head != null ) {
				++length;
				head = head.next;
			}
			return length;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}