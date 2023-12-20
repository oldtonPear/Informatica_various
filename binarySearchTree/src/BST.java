public class BST<T extends Comparable<T>> extends BinaryTree<T>{

    BST(T root){
        setRoot(new Node<T>(root, null, null));
    }

    public boolean recursiveInsert(T val, Node<T> current){
        if (getRoot() == null) setRoot(new Node<T>(val, null, null));

        if(current != null){

            if(val.compareTo(current.getValue()) < 0){
                recursiveInsert(val, current.getLeft());
            } 
            if(val.compareTo(current.getValue()) > 0){
                recursiveInsert(val, current.getRight());
            } 
            if(val.compareTo(current.getValue()) < 0 && current.getLeft() == null){
                current.setLeft(new Node<T> (val, null, null));
                return true;
            } 
            if(val.compareTo(current.getValue()) >= 0 && current.getRight() == null){
                current.setRight(new Node<T> (val, null, null));
                return true;
            } 
        }
        return false;
    }

    public Node<T> binarySearch(T val, Node<T> current){
        if(val.equals(current.getValue())) return current;

        if(val.compareTo(current.getValue()) < 0 && current.getLeft() != null) return binarySearch(val, current.getLeft());
        if(val.compareTo(current.getValue()) >= 0 && current.getRight() != null) return binarySearch(val, current.getRight());
        return null;
    }
    
    public Node<T> getParent(T val, Node<T> current){

        if(current.getLeft() != null){
            if(val.equals(current.getLeft().getValue())) return current;
        }
        if(current.getRight() != null){
            if(val.equals(current.getRight().getValue())) return current;
        }

        if(val.compareTo(current.getValue()) < 0 && current.getLeft() != null) return getParent(val, current.getLeft());
        if(val.compareTo(current.getValue()) >= 0 && current.getRight() != null) return getParent(val, current.getRight());
        return null;
    }

    public void recursivedDelete(T val, Node<T> current){
        Node<T> removed = binarySearch(val, getRoot());
        Node<T> parent = getParent(val, current);
        if(isFoglia(removed)){
            if(parent.getLeft() == removed){
                if(val.compareTo(parent.getValue()) < 0) parent.setLeft(null);
            }
            else parent.setRight(null);
        }
        else if(removed.getLeft() != null ^ removed.getRight() != null){
            if(removed.getLeft() != null){
                if(parent.getValue().compareTo(val) < 0){
                    Node<T> support = removed;
                    parent.setLeft(removed.getLeft());
                    parent.getLeft().setLeft(support);
                    support.setLeft(null);
                    recursivedDelete(val, support);
                }
                if(parent.getValue().compareTo(val) >= 0){
                    Node<T> support = removed;
                    parent.setLeft(removed.getRight());
                    parent.getLeft().setLeft(support);
                    support.setRight(null);
                    recursivedDelete(val, support);
                }
            }
            else{
                if(parent.getValue().compareTo(val) < 0){
                    Node<T> support = removed;
                    parent.setLeft(removed.getLeft());
                    parent.getLeft().setLeft(support);
                    support.setLeft(null);
                    recursivedDelete(val, support);
                }
                if(parent.getValue().compareTo(val) >= 0){
                    Node<T> support = removed;
                    parent.setLeft(removed.getRight());
                    parent.getLeft().setLeft(support);
                    support.setRight(null);
                    recursivedDelete(val, support);
                }
                
            }

        }
        else if(removed.getLeft() != null && removed.getRight() != null){
            System.out.println(getSuccessor(removed).getValue());   
                recursivedDelete(val, removed);
        }
    }

    public Node<T> getSuccessor(Node<T> current){
        if(isFoglia(current)) return current;

        if(current.getValue().compareTo(current.getValue()) < 0 && current.getLeft() != null) return getSuccessor(current);
        else if(current.getValue().compareTo(current.getValue()) >= 0 && current.getRight() != null) return getSuccessor(current);
        return null;
    }
    
    public void iterativeInsert(T val){

    }

    public void iterativeDelete(T val){

    }
    
}