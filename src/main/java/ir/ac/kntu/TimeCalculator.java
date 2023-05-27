package ir.ac.kntu;

public class TimeCalculator {


    public static  int timeDifference(long startTime,long endTime){
        long totalTime = endTime - startTime;
        int difference=(int)(Math.pow(10,-9)*totalTime*100);
        return difference;

    }
}
