package ir.ac.kntu;


import java.time.Duration;
import java.time.Instant;

public class TimeCalculator {


    public  int timeDifference(Instant start, Instant end) {
        Duration timeElapsed = Duration.between(start, end);
        /*long totalTime = endTime - startTime;
        int difference=(int)(Math.pow(10,-9)*totalTime*100);
        return difference;*/
        int duration= Integer.parseInt(String.valueOf(timeElapsed.toMillis()));
        return (int)(duration/1000);

    }
}
