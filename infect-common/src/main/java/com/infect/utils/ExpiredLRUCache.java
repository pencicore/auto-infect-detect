package com.infect.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ExpiredLRUCache<K, V> {
  //移除最近找使用的
  private final int capacity;
  private final Map<K, Node<K, V>> cache = new HashMap<>();
  private Node<K, V> first;
  private Node<K, V> last;
  private final long expiredTimeMillis;
  private final ScheduledExecutorService scheduler;

  public static class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> prev;
    private Node<K, V> next;
    private long timestamp;
    //用于存储键值对以及时间戳
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.timestamp = System.currentTimeMillis();
    }
    //实现基本的LRU缓存逻辑
    public K getKey() {
      return key;
    }

    public V getContent() {
      return value;
    }
    //结合LRU缓存和过期时间检查。
    public void setContent(V value) {
      this.value = value;
    }

    public Node<K, V> getPrev() {
      return prev;
    }

    public void setPrev(Node<K, V> prev) {
      this.prev = prev;
    }

    public Node<K, V> getNext() {
      return next;
    }

    public void setNext(Node<K, V> next) {
      this.next = next;
    }

    public long getTimestamp() {
      return timestamp;
    }

    public boolean isExpired(long expiredTimeMillis) {
      return System.currentTimeMillis() - timestamp > expiredTimeMillis;
    }
  }

  public ExpiredLRUCache(int capacity, long expiredTimeMillis) {
    this.capacity = capacity;
    this.expiredTimeMillis = expiredTimeMillis;
    this.scheduler = Executors.newSingleThreadScheduledExecutor();

    // 定时检查过期项
    this.scheduler.scheduleAtFixedRate(this::cleanUpExpiredEntries, 0, 1, TimeUnit.SECONDS);
  }

  public V get(K key) {
    Node<K, V> node = cache.get(key);
    if (node != null && !node.isExpired(expiredTimeMillis)) {
      moveToHead(node);
      return node.getContent();
    } else {
      cache.remove(key);
      return null;
    }
  }

  public void put(K key, V value) {
    Node<K, V> node = cache.get(key);
    if (node != null) {
      node.setContent(value);
      moveToHead(node);
    } else {
      node = new Node<>(key, value);
      addToLinked(node);
      cache.put(key, node);
      if (cache.size() > capacity) {
        Node<K, V> removed = removeLast();
        cache.remove(removed.getKey());
      }
    }
  }

  private Node<K, V> removeLast() {
    Node<K, V> node = last;
    if (first == last) {
      first = null;
    }
    last = last.getPrev();
    if (last != null) {
      last.setNext(null);
    }
    node.setPrev(null);
    return node;
  }

  private void addToLinked(Node<K, V> node) {
    if (first == null) {
      first = last = node;
    } else {
      node.setNext(first);
      first.setPrev(node);
      first = node;
    }
  }

  private void moveToHead(Node<K, V> node) {
    if (node.getPrev() == null) return;
    if (node == last) {
      last = node.getPrev();
    }
    node.getPrev().setNext(node.getNext());
    if (node.getNext() != null) {
      node.getNext().setPrev(node.getPrev());
    }
    node.setPrev(null);
    node.setNext(first);
    first.setPrev(node);
    first = node;
  }

  private void cleanUpExpiredEntries() {
    cache.values().removeIf(node -> node.isExpired(expiredTimeMillis));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<K, V> node = first;
    while (node != null) {
      sb.append(node.getKey() + ":" + node.getContent() + " , ");
      node = node.getNext();
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ExpiredLRUCache<String, String> cache = new ExpiredLRUCache<>(3, 1000);
    cache.put("1", "you");
    System.out.println("cache.put(\"1\", \"you\") 此时链表为：" + cache.toString());
    cache.put("2", "ke");
    System.out.println("cache.put(\"2\", \"ke\") 此时链表为：" + cache.toString());
    cache.put("3", "da");
    System.out.println("cache.put(\"3\", \"da\") 此时链表为：" + cache.toString());
    cache.put("4", "hello");
    System.out.println("cache.put(\"4\", \"hello\") 此时链表为：" + cache.toString());
    System.out.println(cache.get("1")); // 应该为 null
    System.out.println("cache.get(\"1\") 此时链表为：" + cache.toString());
    System.out.println(cache.get("4")); // 应该为 hello
    System.out.println("cache.get(\"4\") 此时链表为：" + cache.toString());
    cache.get("2");
    System.out.println("cache.get(\"2\") 此时链表为：" + cache.toString());
    cache.get("3");
    System.out.println("cache.get(\"3\") 此时链表为：" + cache.toString());
    cache.put("5", "world");
    System.out.println("cache.put(\"5\", \"world\") 此时链表为：" + cache.toString());
    System.out.println(cache.get("4")); // 应该为 null
  }
}

//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LRUCache<K, V> {
//
//  private int size = 0;
//  private final int capacity;
//  private final Map<K, Node<K, V>> cache = new HashMap<>();
//  private Node<K, V> first;
//  private Node<K, V> last;
//
//  public LRUCache(int capacity) {
//    this.capacity = capacity;
//  }
//
//  public V get(K key) {
//    if (!cache.containsKey(key)) {
//      return null;
//    }
//    Node<K, V> node = cache.get(key);
//    moveToHead(node);
//    return node.getContent();
//  }
//
//  public void put(K key, V value) {
//    Node<K, V> node = cache.get(key);
//    if (node != null) {
//      node.setContent(value);
//      moveToHead(node);
//    } else {
//      node = new Node<>(key, value);
//      addToLinked(node);
//      cache.put(key, node);
//      size++;
//      if (size > capacity) {
//        Node<K, V> removed = removeLast();
//        cache.remove(removed.getKey());
//        size--;
//      }
//    }
//  }
//
//  private Node<K, V> removeLast() {
//    Node<K, V> node = last;
//    if (first == last) {
//      first = null;
//    }
//    last = last.getPrev();
//    if (last != null) {
//      last.setNext(null);
//    }
//    node.setPrev(null);
//    return node;
//  }
//
//  private void addToLinked(Node<K, V> node) {
//    if (first == null) {
//      first = last = node;
//    } else {
//      node.setNext(first);
//      first.setPrev(node);
//      first = node;
//    }
//  }
//
//  private void moveToHead(Node<K, V> node) {
//    if (node.getPrev() == null) return;
//    if (node == last) {
//      last = node.getPrev();
//    }
//    node.getPrev().setNext(node.getNext());
//    if (node.getNext() != null) {
//      node.getNext().setPrev(node.getPrev());
//    }
//    node.setPrev(null);
//    node.setNext(first);
//    first.setPrev(node);
//    first = node;
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    Node<K, V> node = first;
//    while (node != null) {
//      sb.append(node.getKey() + ":" + node.getContent() + " , ");
//      node = node.getNext();
//    }
//    return sb.toString();
//  }
//
//  public static void main(String[] args) {
//    LRUCache<String, String> cache = new LRUCache<>(3);
//    cache.put("1", "you");
//    System.out.println("cache.put(\"1\", \"you\") 此时链表为：" + cache.toString());
//    cache.put("2", "ke");
//    System.out.println("cache.put(\"2\", \"ke\") 此时链表为：" + cache.toString());
//    cache.put("3", "da");
//    System.out.println("cache.put(\"3\", \"da\") 此时链表为：" + cache.toString());
//    cache.put("4", "hello");
//    System.out.println("cache.put(\"4\", \"hello\") 此时链表为：" + cache.toString());
//
//    System.out.println(cache.get("1")); // 应该为 null
//    System.out.println("cache.get(\"1\") 此时链表为：" + cache.toString());
//
//    System.out.println(cache.get("4")); // 应该为 hello
//    System.out.println("cache.get(\"4\") 此时链表为：" + cache.toString());
//
//    cache.get("2");
//    System.out.println("cache.get(\"2\") 此时链表为：" + cache.toString());
//
//    cache.get("3");
//    System.out.println("cache.get(\"3\") 此时链表为：" + cache.toString());
//
//    cache.put("5", "world");
//    System.out.println("cache.put(\"5\", \"world\") 此时链表为：" + cache.toString());
//
//    System.out.println(cache.get("4")); // 应该为 null
//  }
//}
//import java.util.Map;
//import java.util.concurrent.*;
//
//public class ExpiredLRUCache<K, V> {
//
//  private final Map<K, ExpiredCacheValue<V>> cache;
//  private final long expiredTimeMillis;
//  private final ScheduledExecutorService scheduler;
//
//  public static class ExpiredCacheValue<V> {
//    private final long timestamp;
//    private final V value;
//
//    public ExpiredCacheValue(V value) {
//      this.timestamp = System.currentTimeMillis();
//      this.value = value;
//    }
//
//    public boolean isExpired(long expiredTimeMillis) {
//      return System.currentTimeMillis() - timestamp > expiredTimeMillis;
//    }
//
//    public V getValue() {
//      return value;
//    }
//  }
//
//  public ExpiredLRUCache(int capacity, long expiredTimeMillis) {
//    this.cache = new ConcurrentHashMap<>(capacity);
//    this.expiredTimeMillis = expiredTimeMillis;
//    this.scheduler = Executors.newSingleThreadScheduledExecutor();
//
//    // 定时检查过期项
//    this.scheduler.scheduleAtFixedRate(this::cleanUpExpiredEntries, 0, 1, TimeUnit.SECONDS);
//  }
//
//  public V get(K key) {
//    ExpiredCacheValue<V> cacheValue = cache.get(key);
//    if (cacheValue != null && !cacheValue.isExpired(expiredTimeMillis)) {
//      return cacheValue.getValue();
//    } else {
//      cache.remove(key);
//      return null;
//    }
//  }
//
//  public void put(K key, V value) {
//    cache.put(key, new ExpiredCacheValue<>(value));
//  }
//
//  public boolean containsKey(K key) {
//    return cache.containsKey(key);
//  }
//
//  public void remove(K key) {
//    cache.remove(key);
//  }
//
//  private void cleanUpExpiredEntries() {
//    cache.entrySet().removeIf(entry -> entry.getValue().isExpired(expiredTimeMillis));
//  }
//
//  public static void main(String[] args) {
//    ExpiredLRUCache<String, String> cache = new ExpiredLRUCache<>(3, 1000);
//    cache.put("1", "you");
//    System.out.println("cache.put(\"1\", \"you\") 此时链表为：" + cache.toString());
//    cache.put("2", "ke");
//    System.out.println("cache.put(\"2\", \"ke\") 此时链表为：" + cache.toString());
//    cache.put("3", "da");
//    System.out.println("cache.put(\"3\", \"da\") 此时链表为：" + cache.toString());
//    cache.put("4", "hello");
//    System.out.println("cache.put(\"4\", \"hello\") 此时链表为：" + cache.toString());
//    System.out.println(cache.get("1"));
//    System.out.println("cache.get(\"1\") 此时链表为：" + cache.toString());
//    System.out.println(cache.get("4"));
//    System.out.println("cache.get(\"4\") 此时链表为：" + cache.toString());
//    cache.get("2");
//    System.out.println("cache.get(\"2\") 此时链表为：" + cache.toString());
//    cache.get("3");
//    System.out.println("cache.get(\"3\") 此时链表为：" + cache.toString());
//    cache.put("5", "world");
//    System.out.println("cache.put(\"5\", \"world\") 此时链表为：" + cache.toString());
//    System.out.println(cache.get("4"));
//    System.out.println(cache.containsKey("4"));
//  }
//}
