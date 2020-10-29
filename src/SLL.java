import java.util.Comparator;

public class SLL <Avenger extends Comparable<Avenger>> {
	
	
	private int size;
	private Node<Avenger> head;
	private Node<Avenger> tail;
	
	
	
	private Comparator comparator;
	
	public SLL () {
		size = 0;
		head = null;
		tail = null;
		comparator = null;
	}
	
	
	
	public SLL(Comparator comparator) {
		head = null;
		tail = null;
		size = 0;
		this.comparator = comparator;
		
	}
	
	public void addHead(Node<Avenger> n) {
		
		if (head == null) {
			head = n;
			tail = n;
		}
		else {
			n.setNext(head);
			head = n;
			
		}
		
	}
	
	
	//adds every node to the end of the list
	public void add(Node<Avenger> n ) {
		if (tail == null) {
			head = n;
			tail = n;
		}
		else {
			tail.setNext(n);
			tail = n;
		}
	}
	
	
	//i dont know if the prof wants us to delete a node based off the avenger or based on the index given
	public void delete(Node<Avenger> n) {
		
		Node<Avenger> curr = head;
		Node<Avenger> prev = head;
		
		while(curr.getNext() != null) {
			if (curr.getData().equals(n.getData())) {
				
			}
			else {
				prev = curr;
				curr.setNext(curr.getNext());
			}
		}
	
	}
	
	//this probably needs changing
	 //I dont know if the prof wants us to find it by index or by avenger name or alias
	public Node<Avenger> find (Node<Avenger> n){
		
		Node<Avenger> temp = head;
		
		while(temp.getNext() != null) {
			if (temp.getData().equals(n.getData())) {
				return temp;
			}
			else {
				temp.setNext(temp.getNext());
			}
		}
		return null;
		
	}
	
	
	//if we are to add an avenger in the order what is the order?
	//it is the order that is dictated by the comparator or comparable 
	//meaning the node placement will be dependent on the result
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
		}
	}
	
	//"Comparator isnt null so using comparator method of sorting");
	//"comparator is null, using internal data method of sorting");
	private int compare(Node<Avenger>a1, Node<Avenger> a2) {
		
		if(comparator == null) {
			
			return a1.getData().compareTo(a2.getData());
		}
		else {
			comparator.compare(a1.getData(), a2.getData());
			
			
		}
		
		return 0;
	}

	public int getSize() {
		
		return size;
	}

}
