
public class Node <Avenger extends Comparable>{
	
	
	private Node<Avenger> next;
	private Avenger avenger;
	
	public Avenger getData() {
		
		return avenger;
	}
	
	public void setData(Avenger a) {
		
		avenger = a;
	}
	public Node<Avenger> getNext() {
		
		return next;
	}
	public  void setNext(Node<Avenger> n) {
		
		next = n;
	}
	
	
	
}
