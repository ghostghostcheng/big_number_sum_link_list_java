package big_number_sum_link_list;

public class BigNumberSum {
	public static void main(String args[]) {
		String num1 = "12";
		String num2 = "1";
		
		LinkNode inputNode1 = new LinkNode(0);
		LinkNode tmpNode1 = inputNode1;
		for (int i = num1.length() - 1; i > -1; i--) {
			tmpNode1.next = new LinkNode(num1.charAt(i) - 48);
			tmpNode1 = tmpNode1.next;
		}
		
		LinkNode inputNode2 = new LinkNode(0);
		LinkNode tmpNode2 = inputNode2;
		for (int i = num2.length() - 1; i > -1; i--) {
			tmpNode2.next = new LinkNode(num2.charAt(i) - 48);	
			tmpNode2 = tmpNode2.next;
		}
		
		int carry = 0;
		tmpNode1 = inputNode1;
		tmpNode2 = inputNode2;
		while (tmpNode1.next != null && tmpNode2 != null) {
			int tmp = (tmpNode1.val + tmpNode2.val + carry);
			carry = tmp / 10;
			tmpNode1.val = tmp % 10;
			
			if (tmpNode1.next == null) {
				tmpNode1.next = new LinkNode(0);
			}
			
			tmpNode1 = tmpNode1.next;
			tmpNode2 = tmpNode2.next;
		}
		
		if (tmpNode1.next != null) {
			tmpNode1.val = tmpNode1.val + carry;
		} else if (tmpNode2 != null) {
			tmpNode1.val = tmpNode1.val +tmpNode2.val + carry;
			tmpNode1.next = tmpNode2.next;
		}
		
		tmpNode1 = inputNode1.next;
		while(tmpNode1 != null) {
			System.out.print(tmpNode1.val);
			tmpNode1 = tmpNode1.next;
		}
	}
}
