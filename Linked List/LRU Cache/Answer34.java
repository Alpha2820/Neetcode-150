import java.util.*;

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache{
    HashMap<Integer,Node>map = new HashMap<>();
    int capacity;
    Node left;
    Node right;

    public LRUCache(int cap)
    {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    public void insert(Node node)
    {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if (map.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }   
    }
}
public class Answer34{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        while (true) {

            System.out.println("\n--- LRU Cache ---");
            System.out.println("1. Put");
            System.out.println("2. Get");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter key: ");
                int key = sc.nextInt();

                System.out.print("Enter value: ");
                int value = sc.nextInt();

                cache.put(key, value);

                System.out.println("Inserted (" + key + ", " + value + ")");

            } 
            else if (choice == 2) {

                System.out.print("Enter key: ");
                int key = sc.nextInt();

                int result = cache.get(key);

                System.out.println("Result: " + result);

            } 
            else if (choice == 3) {

                System.out.println("Exiting...");
                break;

            } 
            else {

                System.out.println("Invalid choice!");

            }
        }

        sc.close();
    }
}

