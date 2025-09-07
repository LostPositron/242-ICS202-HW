// Loay Shqair, 202365030
public class CDLList<T extends Comparable<T>> {

    private CDLListNode<T> tail;
    private int size = 0;

    // whether the CDLList should be processed in increasing or decreasing order. Initialized in increasing order by default.
    private boolean inc = true;

    private class CDLListNode<T> {
        private T value;
        private CDLListNode<T> prev;
        private CDLListNode<T> next;
        private CDLListNode(T value, CDLListNode<T> prev, CDLListNode<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        private CDLListNode(T value) {
            this(value, null, null);
            this.prev = this;
            this.next = this;
        }
    }

    public boolean add(T el) {
        if (inc)
            return addInc(el);
        return addDec(el);
    }

    public boolean addInc(T el) {
        // if CDLList is empty
        if (tail == null) {
            tail = new CDLListNode<T>(el);
            size++;
            return true;
        }
        boolean newTailFlag = false;
        CDLListNode<T> temp = tail.next;
        while (el.compareTo(temp.value) > 0 && temp != tail) {
            if (el.equals(temp.value)) {
                return false;
            }
            temp = temp.next;
        }
        // final check for when temp = tail
        if (el.compareTo(temp.value) >= 0) {
            if (el.equals(temp.value)) {
                return false;
            }
            newTailFlag = true;
            temp = tail.next;
        }
        //adding node
        temp.prev = new CDLListNode<T>(el, temp.prev, temp);
        temp.prev.prev.next = temp.prev;
        //re-assigning tail reference
        if (newTailFlag) {
            tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean addDec(T el) {
        // if CDLList is empty
        if (tail == null) {
            tail = new CDLListNode<T>(el);
            size++;
            return true;
        }
        boolean newTailFlag = false;
        CDLListNode<T> temp = tail.next;
        while (el.compareTo(temp.value) < 0 && temp != tail) {
            if (el.equals(temp.value)) {
                return false;
            }
            temp = temp.next;
        }
        // final check for when temp = tail
        if (el.compareTo(temp.value) <= 0) {
            if (el.equals(temp.value)) {
                return false;
            }
            newTailFlag = true;
            temp = tail.next;
        }
        //adding node
        temp.prev = new CDLListNode<T>(el, temp.prev, temp);
        temp.prev.prev.next = temp.prev;
        //re-assigning tail reference
        if (newTailFlag) {
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean delete(T el) {
        if (inc)
            return deleteInc(el);
        return deleteDec(el);
    }

    private boolean deleteInc(T el) {
        // if CDLList is empty
        if (tail == null) {
            return false;
        }
        CDLListNode<T> temp = tail.next;
        while (el.compareTo(temp.value) >= 0 && temp != tail) {
            if (el.equals(temp.value)) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                return true;
            }
            temp = temp.next;
        }
        // separate code for deletion if we reach end of CDLList, temp = tail
        if (el.equals(temp.value)) {
            if (size == 1) {
                tail = null;
            }
            else {
                tail = tail.prev;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            size--;
            return true;
        }
        // if we reach this point, nothing was removed
        return false;
    }

    private boolean deleteDec(T el) {
        // if CDLList is empty
        if (tail == null) {
            return false;
        }
        CDLListNode<T> temp = tail.next;
        while (el.compareTo(temp.value) <= 0 && temp != tail) {
            if (el.equals(temp.value)) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                return true;
            }
            temp = temp.next;
        }
        // separate code for deletion if we reach end of CDLList, temp = tail
        if (el.equals(temp.value)) {
            if (size == 1) {
                tail = null;
            }
            else {
                tail = tail.prev;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            size--;
            return true;
        }
        // if we reach this point, nothing was removed
        return false;
    }

    public T findMiddle() {
        if (tail == null) {
            return null;
        }
        CDLListNode<T> temp = tail.next;
        for (int i = 0; i < (size - 1)/2; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    private void reverse(CDLListNode<T> node) {
        CDLListNode<T> nextNode = node.next;
        node.next = node.prev;
        node.prev = nextNode;
        if (node != tail) {
            reverse(nextNode);
        }
    }
    public void reverse() {
        if (size == 0) {
            return;
        }
        reverse(tail.next);
        tail = tail.prev;
        inc = !inc;
    }

    public int size() {
        return size;
    }

    //helper method for display()
    private void display(CDLListNode<T> node) {
        if (node == tail) {
            System.out.print(node.value);
        }
        else {
            System.out.print(node.value + ", ");
            display(node.next);
        }
    }
    public void display() {
        if (tail == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        display(tail.next);
        System.out.println("]");
    }
}
