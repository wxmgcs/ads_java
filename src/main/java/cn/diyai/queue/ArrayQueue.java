package cn.diyai.queue;

import cn.diyai.exception.Overflow;
import cn.diyai.exception.Underflow;

//基于数组实现队列
public class ArrayQueue {

    //指向队首
    private int front;
    //指向队尾
    private int rear;
    //队的长度
    private int capacity;
    private int[] array;

    public ArrayQueue(int size) {
        this.front = -1;
        this.rear = -1;
        this.capacity = size;
        this.array = new int[size];
    }

    public static ArrayQueue createQueue(int size){
        return new ArrayQueue(size);
    }

    public boolean isEmpty(){
        return (front == -1);
    }

    public boolean isFull(){
        return ((rear +1) % capacity == front);
    }

    public int getQueueSize(){
        return ((capacity-front+rear+1)%capacity);
    }

    /**
     * 入队
     * @param data
     * @throws Exception
     */
    public void enQueue(int data) throws Exception{
        if(isFull()){
            throw new Overflow();
        }else{
            rear = (rear+1) % capacity;
            array[rear] = data;
            if(front == -1){
                front = rear;
            }
        }
    }

    public int deQueue() throws  Exception{
        int data;
        if(isEmpty()){
            throw  new Underflow();
        }else{
            data = array[front];
            if(front == rear){
                front = rear-1;

            }else{
                front = (front+1)%capacity;
            }
        }
        return data;
    }

    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 11;i++){
            try{
                arrayQueue.enQueue(i);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        for(int i = 0; i < 11; i++){

            try{
                System.out.println(arrayQueue.deQueue());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
