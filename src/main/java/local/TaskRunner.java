package local;

import net.server.system.SmartHomeSystem;

import java.util.Timer;
import java.util.TimerTask;

public class TaskRunner {

    public static void main(String[] args) {
        SmartHomeSystem smartHomeSystem = SmartHomeSystem.getInstance();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                smartHomeSystem.run();
            }
        };

        timer.schedule(timerTask, 10 * 1_000);

    }

}
