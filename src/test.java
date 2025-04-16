import java.util.ArrayList;

public class test{
       
    private int counter = 90;//create counter
    private Object lock = new Object();//make object to control synchronozation

    public test(){//make constructor
      ArrayList<Thread> t= new ArrayList<Thread>();
      for (int i=1;i<=5;i++){
        Thread ti=new Thread(new InnerThread("Thread "+i));
        t.add(ti);
        ti.start();
      }
      
      for(Thread threads:t){
        try {
            threads.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
      System.out.println("end counter: "+counter);
    }

    public static void main(String[] args) {
        new test();
    }


    class InnerThread implements Runnable{
        private String name;
        

        public InnerThread(String name) {
            this.name = name;
        }


        @Override
        public void run() {

            synchronized(lock){
                 for(int i=0;i<10;i++){
                if(counter<=0)break;
                counter=counter-3;
                System.out.println(this.name+" "+"Counter "+counter);
            }
            }
           
        }

        
    }
    
}