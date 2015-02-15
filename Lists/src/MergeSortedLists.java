public class MergeSortedLists {

	/**
	 * Complexity O(total length of both lists)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// create a new list
		ListNode list = new ListNode(0);
		ListNode p = list;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;

			} else {

				p.next = l2;
				l2 = l2.next;

			}

			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
		}
		return list.next;

	}

}
