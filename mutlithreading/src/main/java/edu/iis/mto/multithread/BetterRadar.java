package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {
    
    final int rocketCount;
    
    private PatriotBattery battery;
    
    private ExecutorService executorService;
    
    public BetterRadar(PatriotBattery patriotBattery, int rocketCount, ExecutorService executorService) {
        this.battery = patriotBattery;
        this.rocketCount = rocketCount;
        this.executorService = executorService;
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

        executorService.execute(launchPatriotTask);
    }
}
