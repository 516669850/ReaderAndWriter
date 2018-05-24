package ReaderAndWriter;

public class DateFile {
    private int readerCount;//正在读的人数
    private boolean doreading;//读信号量，为true时不能写操作
    private boolean dowriting;//写信号量，为true时不能读操作

    public DateFile(){
        readerCount = 0;
        doreading = false;
        dowriting = false;
    }

    public static void naps(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized int startRead(){
        while(dowriting == true){
            try{
                System.out.println(Thread.currentThread().getName() + " is waiting");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "begin to read");
        readerCount++;
        if(readerCount >= 1){
            doreading = true;
        }
        return  readerCount;
    }

    public synchronized int endRead(){
        readerCount--;
        if(readerCount == 0){
            doreading = false;
        }
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " reading done!");
        return readerCount;
    }

    public synchronized void startWrite(){
        while(doreading == true || dowriting == true){
            try{
                System.out.println(Thread.currentThread().getName() + " is waiting");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " begin to write!");
        dowriting = true;
    }

    public synchronized void endWrite(){
        dowriting = false;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " writing done!");
    }
}
