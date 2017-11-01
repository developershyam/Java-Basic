package com.basic;

//Multithreading in java is a process of executing multiple threads simultaneously.
//Multiprocessing and multithreading, both are used to achieve multitasking.

//	1.	Process-based Multitasking(Multiprocessing)	2.	Thread-based Multitasking(Multithreading)

//Process-based Multitasking (Multithreading)
//Each process have its own address in memory i.e. each process allocates separate memory area.
//Process is heavyweight.
//Cost of communication between the process is high.
//Switching from one process to another require some time for saving and loading registers, memory maps, 
//updating lists etc.

//Thread-based Multitasking (Multithreading)
//Threads share the same address space.
//Thread is lightweight.
//Cost of communication between the thread is low.

// At least one process is required for each thread.

//A thread is a lightweight sub process, a smallest unit of processing. 
//It is a separate path of execution.
//Threads are independent, if there occurs exception in one thread, 
//it doesn't affect other threads. It shares a common memory area.

public class Threading {

}
