import java.math.BigInteger;

public class LeetCode2 {

    public static void main(String[] args) {

        ListNode l = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9, null)))))));

// Lista k: [9, 9, 9, 9]
        ListNode k = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9, null))));
        LeetCode2.addTwoNumbers(l,k);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNodeTemp = new ListNode();
        ListNode nodeToReturn = listNodeTemp;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val1 =  (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            listNodeTemp.val = sum % 10;

            if( (sum / 10) != 0 ) carry = 1;
            else carry = 0;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            if(l1 != null || l2 != null || carry != 0){
                listNodeTemp.next = new ListNode();
                listNodeTemp = listNodeTemp.next;
            }

        }
//        System.out.println(nodeToReturn.stringify());
        return nodeToReturn;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public  String stringify(){
            String s = "";
            ListNode list = this;
            while(list != null){
                s += list.val;
                list = list.next;
            }
            return s;
        }

    }
}
