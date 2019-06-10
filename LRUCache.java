package otherProblems;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer,Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity){
        this.capacity =  capacity;
    }

    public void put(int key, int value){
        if(cache.size()<capacity){
            Node node = new Node(key,value);
            addToHead(node);
            cache.put(key, node);
        }else{
            deleteNode(tail);
            cache.remove(tail.key);
            Node node = new Node(key,value);
            addToHead(node);
            cache.put(key, node);

        }
    }

    private void deleteNode(Node node) {

        if(node ==null)
            return;

        if(node.pre!=null)
            node.pre.next = node.next;
        if(node.next !=null)
            node.next.pre = node.pre;

        tail = node.pre;

    }

    private void addToHead(Node node) {
        if(head == null){
            head = node;
            return;
        }

        if(tail ==null){
            node.next = head;
            head.pre = node;
            tail = head;
            head = node;
        }else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    public Node get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            addToHead(node);
            return node;
        }
        return null;
    }

    public static void main(String args[]){
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1 );
//        lruCache.put(2,2 );
//        System.out.println(lruCache.get(1).val);
//        lruCache.put(3,3);
//        System.out.println(lruCache.get(2)!=null ? lruCache.get(2).val :null);
//        lruCache.put(4,4 );
//        System.out.println(lruCache.get(1)!=null ? lruCache.get(1).val :null);
//        System.out.println(lruCache.get(3)!=null ? lruCache.get(3).val : null);
//        System.out.println(lruCache.get(4)!=null ? lruCache.get(4).val : null);

        String s =  "temp";
        System.out.print(s.substring(0,s.length()-1));

    }

}

class Node {
    Node next;
    Node pre;
    int val;
    int key;

    public Node(int key, int value){
        this.key = key;
        this.val = value;
    }

}