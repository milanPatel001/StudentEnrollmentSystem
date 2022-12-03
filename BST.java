public class BST {
    public BSTNode root;

    public void insert(Comparable x){
        if(root==null){
            root = new BSTNode(x);
        }else{
            BSTNode parent = null;
            BSTNode current = root;
            while(current!=null){
                parent = current;
                if(current.getData().compareTo(x)<0) current = current.rightChild;
                else current = current.leftChild;
            }

            if(parent.getData().compareTo(x)<0){
                parent.rightChild = new BSTNode(x);
            }else{
                parent.leftChild = new BSTNode(x);
            }
        }
    }
    public void delete(Comparable x) {
        root = deleteRec(root, x);
    }

    BSTNode deleteRec(BSTNode root, Comparable x)
    {
        if (root == null)
            return root;

        if (x.compareTo(root.getData())<0)
            root.leftChild = deleteRec(root.leftChild, x);
        else if (x.compareTo(root.getData())>0)
            root.rightChild = deleteRec(root.rightChild, x);
        else {
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;

            root.setData(findMin(root.rightChild));

            root.rightChild = deleteRec(root.rightChild, root.getData());
        }

        return root;
    }

    public Comparable findMin(BSTNode root){
        if(root==null) return null;

        BSTNode current = root;
        Comparable d = current.getData();
        while(current.leftChild!=null){
           d = current.leftChild.getData();
           current = current.leftChild;
        }
        return d;
    }

    public boolean search(Comparable x){
        BSTNode current = root;
        while(current!=null){
            if(current.getData().compareTo(x)==0) return true;
            else if(current.getData().compareTo(x)<0) current = current.rightChild;
            else current = current.leftChild;
        }
        return false;
    }

    public void print(BSTNode root){
        if(root==null) return;
        print(root.leftChild);
        System.out.println(root.getData());
        print(root.rightChild);
    }

    private void createString(BSTNode root, StringBuilder sr){
        if(root==null) return;

        createString(root.leftChild, sr);
        sr.append(root.getData());
        createString(root.rightChild, sr);

    }

    @Override
    public String toString() {
        BSTNode curr = root;
        if(curr==null) return "[]";

        StringBuilder sr = new StringBuilder();

        sr.append("[");
        createString(root,sr);
        sr.append("]");

        return sr.toString();
    }
}
