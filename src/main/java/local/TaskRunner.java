package local;

import net.server.system.SmartHomeSystem;

import java.util.Timer;
import java.util.TimerTask;

public class TaskRunner {

    public static void main(String[] args) throws InterruptedException {
        SmartHomeSystem smartHomeSystem = SmartHomeSystem.getInstance();

        while(true) {
            Thread.sleep(10 * 1_000);
            smartHomeSystem.run();
        }
        /*
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                smartHomeSystem.run();
            }
        };

        timer.schedule(timerTask, 10 * 1_000);*/

    }

}
