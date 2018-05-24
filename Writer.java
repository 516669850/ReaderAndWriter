package ReaderAndWriter;

public class Writer implements Runnable{
    private DateFile dateFile;
    private int writerNum;

    public Writer(DateFile dateFile,int writerNum){
        this.dateFile = dateFile;
        this.writerNum = writerNum;
    }

    public void run(){
       while(true){
           dateFile.naps();
           dateFile.startWrite();
           dateFile.naps();
           dateFile.endWrite();
       }
    }
}
