import java.util.HashMap;

public class LRU {

	public static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> pre;
		private Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static class NodeDoubleLinkedList<K, V> {
		private Node<K, V> head;
		private Node<K, V> tail;

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		/**
		 * 将一个节点插入到双向链表 新节点的插入都从尾部进行。即尾部的节点是最近使用
		 * 
		 * @Title: addNode
		 * @Description: TODO
		 * @param: @param newNode
		 * @return: void
		 */
		public void addNode(Node<K, V> newNode) {
			if (newNode == null) {
				return;
			}
			// 当头结点为null说明现在是一个空链表
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.pre = this.tail;
				this.tail = newNode;
			}
		}

		/**
		 * 将一个节点移动到链表尾部 在查询到该节点的时候要进行移动
		 * 
		 * @Title: moveNodeToTail
		 * @Description: TODO
		 * @param: @param moveNode
		 * @return: void
		 */
		public void moveNodeToTail(Node<K, V> moveNode) {
			if (this.tail == moveNode) {
				return;
			}
			if (this.head == moveNode) {// 移动的节点是头结点
				this.head = moveNode.next;
				this.head.pre = null;
			} else {// 移动的节点是普通节点
				moveNode.next.pre = moveNode.pre;
				moveNode.pre.next = moveNode.next;
			}
			moveNode.pre = this.tail;
			moveNode.next = null;
			this.tail.next = moveNode;
			this.tail = moveNode;
		}

		/**
		 * 当容量到了的时候从链表的头部进行删除
		 * 
		 * @Title: removeNode
		 * @Description: TODO
		 * @param: @return
		 * @return: Node<K,V>
		 */
		public Node<K, V> removeNode() {
			if (this.head == null) {
				return null;
			}
			Node<K, V> res = this.head;
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.pre = null;
			}
			return res;
		}
	}

	
	public static class LRUCache<K, V> {
		private HashMap<K, Node<K, V>> keyNodeMap;
		private NodeDoubleLinkedList<K, V> nodeList;
		private int capacity;

		public LRUCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("容量应该大于0");
			}
			this.capacity = capacity;
			this.keyNodeMap = new HashMap<K, Node<K, V>>();
			this.nodeList = new NodeDoubleLinkedList<K, V>();
		}

		public V get(K key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<K, V> res = keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}

		public void set(K key, V value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {
				Node<K, V> newNode = new Node<K, V>(key, value);
				keyNodeMap.put(key, newNode);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		public void removeMostUnusedCache() {
			Node<K, V> removeNode = this.nodeList.removeNode();
			K removeKey = removeNode.key;
			this.keyNodeMap.remove(removeKey);
			System.out.println(removeKey);
		}
	}

	public static void main(String[] args) {
		LRUCache<String, Integer> testCache = new LRUCache<String, Integer>(2);
		testCache.set("A", 111);
		testCache.set("B", 222);
		testCache.get("B");
		testCache.set("C", 333);
		testCache.set("D", 444);
	}

}
