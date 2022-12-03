public class BSTNode {
    private Comparable data;
    public BSTNode leftChild;
    public BSTNode rightChild;

    public BSTNode(Comparable data) {
        this.data = data;
    }

    public BSTNode() {}

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
