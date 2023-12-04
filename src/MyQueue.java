public class MyQueue<T> {

    private MyLinkedList<T> linkedList;

    public MyQueue() {
        this.linkedList = new MyLinkedList<>();
    }

    public void offer(T data) {
        linkedList.addLast(data);
    }

    public T poll() {

        if (linkedList.getSize() == 0) {
            throw new IllegalStateException("Очередь пуста");
        }
        return linkedList.remove(0);
    }
}
