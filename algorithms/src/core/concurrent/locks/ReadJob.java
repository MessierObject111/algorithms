package core.concurrent.locks;

// ReadJob class implementing Runnable interface.
// which uses TestResource object passed in the constructor.
// run method invokes readRecord method on TestResource.
class ReadJob implements Runnable {

    private TestResource test;

    public ReadJob(TestResource tr) {
        test = tr;
    }
    @Override
    public void run() {
        System.out.println("read job");
        test.readRecord(new Object());
    }
}
