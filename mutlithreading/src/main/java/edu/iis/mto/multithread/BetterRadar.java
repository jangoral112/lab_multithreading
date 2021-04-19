package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class BetterRadar {
    
    final int rocketCount;
    
    private PatriotBattery battery;
    
    private Executor executor;
    
    public BetterRadar(PatriotBattery patriotBattery, int rocketCount, Executor executor) {
        this.battery = patriotBattery;
        this.rocketCount = rocketCount;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, rocketCount);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        executor.execute(launchPatriotTask);
    }
}
