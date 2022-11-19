import implementations.DoublyLinkedList;
import implementations.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

//        queue.offer("12");
//        queue.offer("13");
//        queue.offer("14");
//
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.size());


        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);

        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());


        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);

        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());

    }
}
