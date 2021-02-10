package core.concurrent.locks;

// DisplayJob class implementing Runnable interface.
// This uses TestResource object passed in the constructor.
// run method invokes displayRecord method on TestResource.
class DisplayJob implements Runnable
{

    private TestResource test;
    public DisplayJob(TestResource tr) {
        test = tr;
    }
    @Override
    public void run() {
        System.out.println("display job");
        test.displayRecord(new Object());
    }
}