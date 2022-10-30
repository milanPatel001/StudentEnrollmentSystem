public class LLNode {
    public Comparable data;
    public LLNode next;

    public LLNode() {}

    public LLNode(Comparable data) {
        this.data = data;
    }

    public Comparable getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
