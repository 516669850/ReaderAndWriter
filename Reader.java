package ReaderAndWriter;

public class Reader implements Runnable{
    private DateFile dateFile;
    private int readerNum;

    public Reader(DateFile dateFile,int readerNum){
        this.dateFile = dateFile;
        this.readerNum = readerNum;
    }

    public void run(){
        while(true){
            dateFile.naps();
            dateFile.startRead();
            dateFile.naps();
            dateFile.endRead();
        }
    }
}
