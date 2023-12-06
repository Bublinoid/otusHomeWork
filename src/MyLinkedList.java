public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T getFirst() {
        return head != null ? head.data : null;
    }

    public T getLast() {
        return tail != null ? tail.data : null;
    }

    public void add(int position, T data) {

        if (position < 0 || position > size) {
            throw new IllegalStateException("Недопустимая позиция");
        }

        if (position == 0) {
            addFirst(data);

        } else if (position == size) {
            addLast(data);

        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;

            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public T remove(int position) {

        if (position < 0 || position >= size) {
            return null;
        }
        T removedData;

        if (position == 0) {
            removedData = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }

        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;

            if (current.next == null) {
                tail = current;
            }
        }
        size--;
        return removedData;
    }

    public T get(int position) {
        if (position < 0 || position >= size) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }
}
