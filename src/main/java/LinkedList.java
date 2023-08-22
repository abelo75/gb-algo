public class LinkedList<T> {
    Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }

    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void reverse() {
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            out.append("[").append(current.data).append("]\n");
            current = current.next;
        }
        return out.toString();
    }
}
