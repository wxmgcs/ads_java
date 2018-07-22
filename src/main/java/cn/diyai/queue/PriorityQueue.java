package cn.diyai.queue;


//优先级队列
public class PriorityQueue {

	private int maxSize;
	private long[] queueArray;
	private int nItems;


	public PriorityQueue(int size) {
		this.maxSize = size;
		this.queueArray = new long[this.maxSize];
		this.nItems = 0;
	}

	//需要O(N)时间
	public void insert(long item){
		int j;

		if(nItems == 0){
			queueArray[nItems++] = item;
		}else{
			for(j= nItems-1;j >= 0; j--){
				if(item > queueArray[j]){
					queueArray[j+1]=  queueArray[j];
				}else{
					break;
				}
			}

			queueArray[j+1] = item;
			nItems++;
		}
	}

	//需要O(1)时间
	public long remove(){
		return queueArray[--nItems];
	}

	//返回front指针所指向的值
	public long peekMin(){
		return queueArray[nItems-1];
	}


	public boolean isEmpty(){

		return nItems == 0;
	}

	public boolean isFull(){
		return nItems == maxSize;
	}

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(5);
		queue.insert(10);
		queue.insert(40);
		queue.insert(30);
		queue.insert(20);

		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
	}

}
