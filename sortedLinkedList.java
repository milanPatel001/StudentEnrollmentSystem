import java.util.LinkedList;

public class sortedLinkedList {

    public LLNode head;

    public sortedLinkedList(){
        head = new LLNode();
    }

    public boolean isEmpty(LLNode root){
        return head.next==null;
    }

    public void insert(Comparable n){
       LLNode prev = head;
       LLNode curr = head.next;

       LLNode new_node = new LLNode(n);

       while(curr!=null){
           if(curr.data.compareTo(new_node.data)>0){ // !!!check condition
               prev.next = new_node;
               new_node.next = curr;
               break;
           }
           prev = curr;
           curr = curr.next;
       }

       if(prev.next==null){
           prev.next = new_node;
       }

    }

    public void delete(Comparable n){
        LLNode prev = head;
        LLNode curr = head.next;

        while(curr!=null){
            if(curr.getData().compareTo(n)==0){
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean search(Comparable x){
        LLNode curr = head.next;
        while (curr!=null){
            if(curr.getData().compareTo(x)==0) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        LLNode curr = head.next;
        if(curr==null) return "[]";

        StringBuilder sr = new StringBuilder();

        sr.append("[");
        while(curr!=null){
            sr.append(curr.data);
            curr = curr.next;
        }
        sr.append("]");

        return sr.toString();
    }

}
