package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@ExtendWith(MockitoExtension.class)
class BetterRadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(100)
    void shouldExecuteBatteryLunchPatriotWithGivenEnemyMissileFiveTimes() {
        // given
        int sampleRocketCount = 5;
        Executor executor = Runnable::run;
        BetterRadar betterRadar = new BetterRadar(batteryMock, sampleRocketCount, executor);
        Scud enemyMissile = new Scud();

        doNothing().when(batteryMock)
                   .launchPatriot(enemyMissile);
        // when
        betterRadar.notice(enemyMissile);

        // then
        verify(batteryMock, times(sampleRocketCount)).launchPatriot(enemyMissile);
    }

}
