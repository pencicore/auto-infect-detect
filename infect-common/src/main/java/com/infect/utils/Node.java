package com.infect.utils;


class Node<K, V> {
  K key;
  V content;
  Node<K, V> prev;
  Node<K, V> next;

  public Node(K key, V content) {
    this.key = key;
    this.content = content;
  }

  public K getKey() {
    return key;
  }

  public V getContent() {
    return content;
  }

  public void setContent(V content) {
    this.content = content;
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
}