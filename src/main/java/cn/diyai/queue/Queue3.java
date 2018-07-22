package cn.diyai.queue;



public class Queue3 {

	private int maxSize;
	private long[] queueArray;
	//队头
	private int front;
	//队尾
	private int rear;


	public Queue3(int size) {
		this.maxSize = size+1;
		this.queueArray = new long[this.maxSize];
		this.front = 0;
		this.rear = -1;
	}

	public void insert(long j){
		if(rear == maxSize-1){
			rear = -1;
		}

		queueArray[++rear] = j;
	}

	public long remove(){
		long temp = queueArray[front++];
		if(front == maxSize){
			front = 0;
		}

		return temp;
	}

	//返回front指针所指向的值
	public long peekFront(){
		return queueArray[front];
	}

	//返回rear指针所指向的值
	public long peekRear(){
		return queueArray[rear];
	}

	public boolean isEmpty(){
		return (rear+1 == front);
	}

	public boolean isFull(){
		return (rear +2 == front || (front+maxSize-1 == rear));
	}

	public int size(){

		if(rear >= front){
			return rear-front+1;
		}else{
			return (maxSize-front)+(rear +1 );
		}
	}



	public static void main(String[] args) {
		Queue3 queue = new Queue3(5);
		queue.insert(10);
		System.out.println("peek insert:"+queue.peekFront());
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);

		queue.remove();
		System.out.println("peek remove:"+queue.peekFront());
		queue.remove();
		queue.remove();
		System.out.println("peek remove:"+queue.peekFront());


		queue.insert(50);
		queue.insert(60);
		queue.insert(70);
		queue.insert(80);

		while(!queue.isEmpty()){
			long n = queue.remove();
			System.out.println(n);
		}
	}

}
