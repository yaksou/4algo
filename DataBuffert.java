package inlämningsuppgift4;

import java.io.*;
import java.util.*;

public class DataBuffert<AnyType> {
	private AnyType[] kuja;
	private int size;
	private int front;
	private int back = -1;

	public DataBuffert() {
		kuja = (AnyType[]) new Object[10];

	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (size == kuja.length) {
			return true;
		}
		return false;
	}

	private int increment(int a) {
		if (++a == kuja.length)
			a = 0;
		return a;
	}

	public void enqueue(AnyType a) {
		if (isFull())
			throw new NullPointerException();
		back = increment(back);
		kuja[back] = a;
		size++;
	}

	public AnyType dequeue() {
		if (isEmpty()){
			throw new UnderflowException("DataBuffert dequeue");
		}
		size--;
		AnyType returnValue = kuja[front];
		front = increment(front);
		return returnValue;

	}

	public int size() {
		return size;

	}

	public void printQueue() {
		if (size == 0)
			System.out.println("Empty queue");
		for (int i = front; i < size; i++){
				System.out.print(kuja[i]);
			}
		

	}

	public static void main(String[] arg) {
		DataBuffert<String> q = new DataBuffert<String>();

		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");
		q.enqueue("F");
		q.enqueue("G");
		q.enqueue("H");
		q.enqueue("I");
		q.enqueue("J");
//		q.enqueue("K");
//		q.enqueue("L");


		q.printQueue();

		System.out.println();
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		

	}
}
