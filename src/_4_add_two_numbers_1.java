/**
 * Created by tobby on 16/2/18.
 */
public class _4_add_two_numbers_1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode my_addTwoNumbers(ListNode l1, ListNode l2) {
        // 判断next是否为空
        // 相加+进位位
        // 重复, 直到其中一个next为null, 复制剩余位到结果(加进位)
        // 或双方同时为null, 判断进位
        // 返回
        boolean carry = false;
        ListNode result = new ListNode(0);
        result.val = l1.val + l2.val;
        if (result.val >= 10) {
            result.val = result.val - 10;
            carry = true;
        }
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;
        ListNode last = result;
        while (l1next != null) {
            if (l2next != null) {
                int nextval = l1next.val + l2next.val + (carry ? 1 : 0);
                if (nextval >= 10) {
                    nextval = nextval - 10;
                    carry = true;
                } else {
                    carry = false;
                }
                last.next = new ListNode(nextval);
                last = last.next;
                l2next = l2next.next;
            } else {
                int nextval = l1next.val + (carry ? 1 : 0);
                if (nextval >= 10) {
                    nextval = nextval - 10;
                    carry = true;
                } else {
                    carry = false;
                }
                last.next = new ListNode(nextval);
                last = last.next;
            }
            l1next = l1next.next;
        }
        if (l2next != null) {
            while (l2next != null) {
                int nextval = l2next.val + (carry ? 1 : 0);
                if (nextval >= 10) {
                    nextval = nextval - 10;
                    carry = true;
                } else {
                    carry = false;
                }
                last.next = new ListNode(nextval);
                last = last.next;
                l2next = l2next.next;
            }
        }
        if (carry) {
            last.next = new ListNode(1);
        }
        return result;
    }

    //ok
    public static ListNode my_addTwoNumbers_short(ListNode l1, ListNode l2) {
        // 判断next是否为空
        // 相加+进位位
        // 重复, 直到其中一个next为null, 复制剩余位到结果(加进位)
        // 或双方同时为null, 判断进位
        // 返回
        ListNode result = new ListNode(0);
        ListNode p = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            p.val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = p.val/10;
            p.val = p.val%10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            if(l1!=null || l2 != null|| carry > 0){
                p.next = new ListNode(0);
            }
            p = p.next;
        }
        return result;
    }


    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(8);
//        l1.next.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(7);
//        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(0);
//        l2.next.next.next = new ListNode(4);
//        l2.next.next.next.next = new ListNode(9);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode result = my_addTwoNumbers(l1, l2);
    }
}

