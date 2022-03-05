package BinaryTrees;

public class Binary_trees {
    Node root;

    public void addNode(int key, String name){
        Node newNode = new Node(key, name);
        if(root == null){
            root = newNode;
        }

        else {
            Node focusNode = root;
            Node parent;
            while (true){
                // Iterates through the nodes by only comparing the key of the focus node AND key passed in
                parent = focusNode;
                if(key < focusNode.key){ // If new node is < root to start with, it then switches focus to 1st left child
                    focusNode = focusNode.leftChild;
                    if (focusNode == null){ // If that new left child doesnt exist, re write the node in this position
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public boolean remove (int key){
        Node focusNode = root;
        Node parentNode = root;
        //Start search for key on the left child
        boolean isItALeftChild = true;
        //Keep looking for the search node
        while(focusNode.key != key){
            parentNode = focusNode;
            //Search left?
            if (key < focusNode.key){
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            }
            else{
                //Searching to the right
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }
            //Node not found
            if (focusNode == null){
                return false;
            }
        }
        //Node with no children DELETE IT!
        if (focusNode.leftChild == null && focusNode.rightChild == null){

            //If the root has no children delete it
            if (focusNode == root){
                root = null;
            }
            //If it is marked as a Left child of the parent
            //Then delete it in the parent
            else if (isItALeftChild){
                parentNode.leftChild = null;
            }
            //If it is marked as a right child node
            else {
                parentNode.rightChild = null;
            }
        }

        //If Node has no Right child
        else if (focusNode.rightChild == null){
            if (focusNode == root){
                root = focusNode.leftChild;
            }
            //If focus node was on the left of the parent
            //move the focus node left child up to the parent node
            else if (isItALeftChild){
                parentNode.leftChild = focusNode.leftChild;
            }
            else {
                parentNode.rightChild = focusNode.leftChild;
            }
        }

        //if no left child
        else if (focusNode.leftChild ==null){
            if (focusNode == root){
                root = focusNode.rightChild;
            }

            // If focus node was on the left of parent
            // move the focus nodes right child up to the parent node
            else if (isItALeftChild){
                parentNode.leftChild = focusNode.rightChild;
            }
            else {
                parentNode.rightChild = focusNode.rightChild;
            }
        }

        //2 children so need to find the deleted nodes replacement
        else{
            Node replacement = getReplacementNode(focusNode);
            // If the focusNode is root replace root with the replacement
            if (focusNode == null){
                root = replacement;
            }
            // If the deleted node was a left child
            // make the replacement the left child
            else if (isItALeftChild){
                parentNode.leftChild = replacement;
            }
            else {
                parentNode.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.rightChild;
        while (focusNode!=null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        //If the replacement isn't the right child
        //move the replacement into the parents
        //leftChild slot and move the replaced nodes
        //right child into the replacements rightChild
        if (replacement != replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }

    public static void main(String[] args){
        Binary_trees binaryTree = new Binary_trees();
        binaryTree.addNode(50, "Vice Chancellor");
        binaryTree.addNode(25, "Dean of Faculty");
        binaryTree.addNode(15, "Faculty Manager");
        binaryTree.addNode(30, "Faculty Secretary");
        binaryTree.addNode(18, "Another Faculty Manager");
        binaryTree.addNode(75, "Head of School");
        binaryTree.addNode(80, "Senior Lecturer");
        binaryTree.addNode(2, "Building Manager");
        binaryTree.addNode(16, "Library manager");

        binaryTree.inOrderTraverseTree(binaryTree.root);
        System.out.println("====================================================");
        binaryTree.preOrderTraverseTree(binaryTree.root);
        System.out.println("====================================================");
        binaryTree.postOrderTraverseTree(binaryTree.root);

        binaryTree.remove(15);

        System.out.println("\nBinary tree in order traversal\n");
        binaryTree.inOrderTraverseTree(binaryTree.root);

    }
}
