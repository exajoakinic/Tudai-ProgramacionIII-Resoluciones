package ProgramacionIII.tp1;

public class NodeDouble<T> extends Node {

	private T info;
	private NodeDouble<T> next;
	private NodeDouble<T> previous;

	public NodeDouble() {
		this.info = null;
		this.next = null;
		this.previous= null;
	}

	public NodeDouble(T info) {
		this.info = info;
		this.next = null;
		this.previous= null;
	}
	
	public NodeDouble(T info, NodeDouble<T> previous, NodeDouble<T> next) {
		this.setInfo(info);
		this.setNext(next);
		this.setPrevious(previous);
	}
	
	public NodeDouble<T> getNext() {
		return this.next;
	}

	public NodeDouble<T> getPrevious() {
		return this.previous;
	}

	public void setNext(NodeDouble<T> next) {
		this.next = next;
	}
	public void setPrevious(NodeDouble<T> previous) {
		this.previous = previous;
	}

}
