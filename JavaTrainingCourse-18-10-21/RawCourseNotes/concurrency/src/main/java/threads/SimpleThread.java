package threads;

// Concurrency: the CPU is switching between n tasks very quickly
// Parallelism: two or more tasks are actually being worked upon at the same time
// Asynchronous: to do something later

// Thread: a lightweight process
// Thread states: RUNNING, BLOCKED, WAITING (for IO), SLEEPING, DEAD
// IO intensive work can benefit from multithreading even if you've only one CPU core
// CPU intensive work requires n cores to benefit from n threads

// Memory is very important
// STACK: methods in execution & their local variables
// HEAP: objects
// NB: Each thread gets its own STACK but all threads share the HEAP

public class SimpleThread extends Thread {

    @Override
    public void run() {
        // The code inside the run method is the subset of app code that will be executed by the thread
        // NEVER call the run method directly - doing so will execute the code in the main thread
        System.out.println(Thread.currentThread().getName() + ": Hello world");
    }

    public static void main(String[] args) {
        var simpleThread = new SimpleThread();
        simpleThread.start(); // <!-- calling start will have the OS schedule the thread
        System.out.println(Thread.currentThread().getName() + ": Goodbye");
    }
}
