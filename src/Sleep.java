public class Sleep {
    public void sleepFor(long nanoseconds) {
        long timeElapsed;
        final long startTime = System.nanoTime();
        do {
            timeElapsed = System.nanoTime() - startTime;
        } while(timeElapsed < nanoseconds);
    }
    
    public long secondsToNano(long time) {
        return time * (long)Math.pow(10, 9);
    }
    
    public long millisecondsToNano(long time) {
        return time * (long)Math.pow(10, 6); 
    }
    
    public long microsecondsToNano(long time) {
        return time * (long)Math.pow(10, 3); 
    }   
}
