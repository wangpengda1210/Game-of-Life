public class Main {

    public static void main(String[] args) {

        // create threads and start them using the class RunnableWorker
        Thread thread1 = new Thread(new RunnableWorker());
        thread1.setName("worker-1");

        Thread thread2 = new Thread(new RunnableWorker());
        thread2.setName("worker-2");

        Thread thread3 = new Thread(new RunnableWorker());
        thread3.setName("worker-3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        } else {
            return;
        }
    }
}