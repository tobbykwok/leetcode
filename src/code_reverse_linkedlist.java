/**
 * Created by tobby on 16/2/25.
 */
public class code_reverse_linkedlist<Value> {
    public class Node {
        public Node next;
        public Value val;

        public Node(Value val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // 链表类
    public class LinkedList {
        // 链表基本操作
        // 1. 插入
        // 2. 查找
        // 3. 删除
        // 4. 输出
        // 5. 逆序
        private Node first;
        private Node current;
        private int N;  //计数

        public LinkedList(Node first) {
            if (first != null) {
                this.first = first;
                this.current = first;
                this.N = 1;
            } else {
                throw new NullPointerException("first node can not be null");
            }
        }

        public void Insert(Node node) {
            if (node != null) {
                this.current.next = node;
                this.current = this.current.next;
                this.N++;
            } else {
                return;
            }
        }

        public Node Find(Value val) {
            Node p = this.first;
            while (p != null) {
                if (p.val.equals(val)) {
                    return p;
                } else {
                    p = p.next;
                }
            }
            return null;
        }

        public Node Delete(Value val) {
            Node p = this.first;
            while (p != null) {
                if(p.val.equals(val)){
                    if(p == this.first){
                        this.first = p.next;
                    }
                }
            }
            return p;
        }

    }
}
