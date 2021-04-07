package jsjf;
public class CircularArrayQueue<T> implements QueueADT<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;
	
	
	public CircularArrayQueue (int initialCapacity)
	{
		front = rear = count = 0;
		queue = (T[]) (new Object[initialCapacity]);
	}
	
	public CircularArrayQueue()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public void enqueue(T element)
	{
		if (size() == queue.length)
			expandCapacity();
		
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		
		count++;
	}
	private void expandCapacity()
	{
		// TODO Auto-generated method stub
		
	}

	public T dequeue() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		T result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		
		count--;
		
		return result;
	}

	@Override
	public T first()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}