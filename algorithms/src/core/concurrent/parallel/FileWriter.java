package core.concurrent.parallel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {
    private static final String FILE_PATH = "/Users/chongyuli/Documents/GitHub/algorithms/algorithms/src/core/concurrent/parallel/";
    private static final String FILE_NAME = "test.txt";

    public void demo() throws IOException {
        File testFile = new File(FILE_PATH + FILE_NAME);
        testFile.createNewFile();
        Path path = Paths.get(testFile.getPath());
        StringBuffer sb = new StringBuffer();

        Runnable writerA = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    sb.append("AAA" + "\r\n");
                }
            }
        };
        Runnable writerB = () -> {
            for(int i = 0; i < 1000; i++){
                sb.append("BBBBB"+ "\r\n");
            }
        };
        Runnable writerC = () -> {
            for(int i = 0; i < 1000; i++){
                sb.append("CCCCCCC"+ "\r\n");
            }
        };
        Runnable waitAndWrite = () -> {
            try {
                Thread.sleep(2000);
                try {
                    Files.write(path, sb.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(writerA);
        Thread t2 = new Thread(writerB);
        Thread t3 = new Thread(writerC);
        Thread holdAndWrite = new Thread(waitAndWrite);

        kickStartThread(t1);
        kickStartThread(t2);
        kickStartThread(t3);

        holdAndWrite.start();
    }

    private synchronized void kickStartThread (Thread t) {
        t.start();
    }
}
