package ReaderAndWriter;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class Main {
    public static void main(String[] args){
        DateFile dateFile = new DateFile();
        Reader r1 = new Reader(dateFile,1);
        Reader r2 = new Reader(dateFile,2);
        Writer w1 = new Writer(dateFile,1);
        Writer w2 = new Writer(dateFile,2);
        new Thread(r1,"reader1").start();
        new Thread(r2,"reander2").start();
        new Thread(w1,"writer1").start();
        new Thread(w2,"writer2").start();
    }
}
