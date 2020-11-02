import java.util.Comparator;

public class SLL <Avenger extends Comparable<Avenger>> {
	
	
	private int size;
	private Node<Avenger> head;
	private Node<Avenger> tail;
	
	
	
	private Comparator<Avenger> comparator;
	
	
	
	 /**
	  * Constructor
	  * This is the constructor where there is comparator given and no avenger list given
	  */
	public SLL () {
		size = 0;
		head = null;
		tail = null;
		comparator = null;
	}
	
	
	/**
	 * Constructor for where a custom comparator is given
	 * @param comparator
	 */
	public SLL(Comparator<Avenger> comparator) {
		head = null;
		tail = null;
		size = 0;
		this.comparator = comparator;
		
	}
	
	/**
	 * receives node n and adds it to the head
	 * @param n
	 */
	public void addHead(Node<Avenger> n) {
		
		if (head == null) {
			head = n;
			tail = n;
			size++;
		}
		else {
			n.setNext(head);
			head = n;
			size++;
		}
		
	}
	
	/**
	 * adds every node to the end of the list
	 * @param n
	 */
	
	public void add(Node<Avenger> n ) {
		if (tail == null) {
			head = n;
			tail = n;
			size++;
		}
		else {
			tail.setNext(n);
			tail = n;
			size++;
		}
	}
	
	
	/**
	 * Removes node n by receiving data to remove
	 * @param n
	 */
	public void delete(Avenger av) {
		
		Node<Avenger> curr = head;
		Node<Avenger> prev = head;
		
		while(curr.getNext() != null) {
			if (curr.getData().equals(av)) {
				size--;
				if (head == tail) {
					head = null;
					tail = null;
					return;
				}

				if (curr == head)
					head = curr.getNext();
				else {
				
					prev.setNext(curr.getNext());
				}
				if (curr == tail) {
					tail = prev;
				}

				return;
			}
			else {
				prev = curr;
				curr.setNext(curr.getNext());
			}
		}
	
	}
	
	/**
	 * receives avenger information and returns the corresponding Node
	 * @param av
	 * @return 
	 * returns the node of the avenger found
	 */
	public Node<Avenger> find (Avenger av){
		
		Node<Avenger> temp = head;
		
		while(temp.getNext() != null) {
			if (temp.getData().equals(av)) {
				return temp;
			}
			else {
				temp.setNext(temp.getNext());
			}
		}
		return null;
		
	}
	
	
	/**
	 * Receives a n node and adds in the order of either the default comparator or the 
	 * Custom comparator
	 * @param n
	 */
	public void addInOrder(Node<Avenger> n) {
		if (head == null || compare(n, head) <= 0 ) {
			addHead(n);
		}
		else if(compare(n, head) > 0) {
			add(n);
		}
		else {
			Node<Avenger> temp = head;
			while(temp.getNext() != null && compare(n, temp.getNext() ) > 0) {
				temp = temp.getNext();
				
			}
			n.setNext(temp.getNext());
			temp.setNext(n);
			size++;
		}
	}
	
	/**
	 * 
	 * @param a1
	 * @param a2
	 * @return
	 * returns the order of comparing two avenger nodes
	 * this is done either using the default avenger comparator or the custom
	 */
	private int compare(Node<Avenger>a1, Node<Avenger> a2) {
		
		if(comparator == null) {
			
			return a1.getData().compareTo(a2.getData());
		}
		else {
			comparator.compare(a1.getData(), a2.getData());
			
			
		}
		
		return 0;
	}

	/**
	 * returns size of Linked List Structure
	 * @return
	 */
	public int getSize() {
		
		return size;
	}

}
