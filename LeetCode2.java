import java.math.BigInteger;

public class LeetCode2 {

    public static void main(String[] args) {

        ListNode l = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode k = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        LeetCode2.addTwoNumbers(l,k);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodeToReturn = new ListNode();
        ListNode listNode = new ListNode();

        String l1Value = "", l2Value = "";

        do {
            l1Value = l1.val + l1Value;
            l1 = l1.next;
        } while (l1 != null);

        do {
            l2Value = l2.val + l2Value;
            l2 = l2.next;
        } while (l2 != null);

        BigInteger sum = new BigInteger(l1Value).add( new BigInteger(l2Value));
        String sumAsString =  String.valueOf(sum);
        int sumLength = sumAsString.length();

        for(int i = sumLength - 1; i >=0; i--){
            if(i == sumLength - 1) nodeToReturn = listNode;
            listNode.val = sumAsString.charAt(i) - '0';
            System.out.println(listNode.val + " i: " + i);
            if(i == 0) break;
            listNode.next = new ListNode();
            listNode = listNode.next;
        }
        System.out.println(nodeToReturn.stringify());
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
