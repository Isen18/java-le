package test;

/**
 * @author Isen
 * @date 2019/3/6 21:10
 * @since 1.0
 */
public class P1 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Plus {
        public ListNode plusAB(ListNode a, ListNode b) {
            // write code here
            if(a == null){
                return b;
            }

            if(b == null){
                return a;
            }

            ListNode p = a;
            ListNode p2 = b;
            //进位
            int tmp = 0;
            int ten = 10;

            ListNode result = new ListNode(0);
            ListNode p3 = result;
            while(p != null && p2 != null){
                p3.next = new ListNode(0);
                p3 = p3.next;
                p3.val = p.val + p2.val + tmp;
                if(p3.val > ten){
                    p3.val -= ten;
                    tmp = 1;
                }else {
                    tmp = 0;
                }

                p = p.next;
                p2 = p2.next;
            }

            while(p != null){
                p3.next = new ListNode(0);
                p3 = p3.next;
                p3.val = p.val + tmp;
                if(p3.val > ten){
                    p3.val -= ten;
                    tmp = 1;
                }else {
                    tmp = 0;
                }

                p = p.next;
            }

            while(p2 != null){
                p3.next = new ListNode(0);
                p3 = p3.next;
                p3.val = p2.val + tmp;
                if(p3.val > ten){
                    p3.val -= ten;
                    tmp = 1;
                }else {
                    tmp = 0;
                }

                p2 = p2.next;
            }

            if(tmp == 1){
                p3.next = new ListNode(1);
            }

            p3 = result.next;
            result.next = null;
            return p3;
        }
    }

}
