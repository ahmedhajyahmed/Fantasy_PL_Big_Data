package tn.kafka;


import java.util.Timer;

public class TestAPI {

    public static void main(String [] args){

        Timer t = new Timer();
        MyTask myTask = new MyTask();
        t.schedule(myTask, 0, 300000);

    }
}
