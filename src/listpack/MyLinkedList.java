package listpack;


import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E>{

    private int size = 0;
    public Node<E> terminator = new Node<>(null,null);
    public Node<E> firstItem;
    public Node<E> lastItem;

    public static class Node<E>{

        private E element;
        private Node<E> next;

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    Node<E> node(int index) {

        Node<E> x = firstItem;
        for (int i = 0; i < index; i++)
            x = x.next;
            return x;
    }


    @Override
    public void add(E element) {
        if (this.isEmpty()){

            lastItem = new Node<>(element, null);
            terminator.next = lastItem;
            firstItem = lastItem;
        }
        else {
            Node<E> l = lastItem;
            lastItem = new Node<>(element, null);
            l.next = lastItem;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {

        if (index == 0) {
            firstItem = new Node<>(element, firstItem);
        } else if (index == size)
            add(element);
        else{
            Node<E> prev = node(index-1);
            Node<E> next = node(index);
            Node<E> newOne = new Node<>(element, next);
            prev.next = newOne;
        }
            size++;
    }

    private boolean isEmpty(){
        return (terminator.next == null);
    }

    @Override
    public void clear() {
        for(Node<E> x = firstItem; x != null; ){
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x = next;
        }
        firstItem = lastItem = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        for (Node<E> x = firstItem; x != null; x = x.next) {

            if (element.equals(x.element))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node<E> old = node(index);
        if (size == 1) clear();
        if ((index == 0) && (size > 1))
            firstItem = old.next;
        else
            node(index -1).next = old.next;
        size--;
        return old.element;
    }

    @Override
    public E set(int index, E element) {

        Node<E> x = node(index);
        E old = x.element;
        x.element = element;
        return old;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        int i = 0;
        Object[] obj = new Object[size];
        for(Node<E> x = firstItem; x != null; x = x.next){
                obj[i] = x.element;
                i++;
        }
        return obj;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> Item = terminator;
            @Override
            public boolean hasNext() {
                return (Item.next != null);
            }

            @Override
            public E next() {
                    Item = Item.next;
                    return Item.element;

            }
        };
    }

    @Override
    public String toString() {
        String str = "[";
        for(Node<E> x = firstItem; x != null; ){

            str+= x.element.toString();
            x = x.next;
            if (!(x == null))
                str+=", ";
        }
        str+= ']';
        return str;
    }
}

