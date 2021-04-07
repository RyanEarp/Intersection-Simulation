package jsjf;

public class LinkedQueue<T> implements QueueADT<T>
{
	private int count;
	private LinearNode<T> head, tail;

	
	public LinkedQueue()
	{
		count =0;
		head = null;
		tail = null;
	}
	
	public void enqueue(T element)
	{
		LinearNode<T> node = new LinearNode<T>(element);
		
		if (isEmpty())
			head = node;
		else
			tail.setNext(node);
		
		tail = node;
		count++;
	}
	public T dequeue() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		
		T result = head.getElement();
		head = head.getNext();
		count--;
		
		if (isEmpty())
			tail = null;
		
		return result;
	}

	@Override
	public T first()
	{
		
		return head.getElement();
	}

	@Override
	public boolean isEmpty()
	{
		return count == 0;
	}

	@Override
	public int size()
	{
		return count;
	}

}