import java.io.IOException;
import java.util.TimerTask;

class MyTask extends TimerTask {

    public MyTask(){
        //Some stuffs
    }

    @Override
    public void run() {
        APITest test= new APITest();
        try {
            test.call();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}