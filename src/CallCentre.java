import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class CallCentre {
    private final static int UNIT_OF_TIME_IN_SECONDS_FOR_GENERATION = 1;
    private final static int UNIT_OF_TIME_IN_SECONDS_FOR_PROCESSING = 3;
    private final static int NUMBER_OF_CALLS_PER_UNIT_OF_TIME = 60;

    private final int NUMBER_OF_SPECIALISTS;
    private final long WORKING_TIME_IN_SECONDS;
    private final List<Specialist> specialists;

    private Queue<String> queueCalls = new ConcurrentLinkedQueue<>();
    private volatile long startTime;
    private int totalCalls;

    public CallCentre(int NUMBER_OF_SPECIALISTS, long WORKING_TIME_IN_SECONDS) {
        this.NUMBER_OF_SPECIALISTS = NUMBER_OF_SPECIALISTS;
        this.WORKING_TIME_IN_SECONDS = WORKING_TIME_IN_SECONDS;
        this.specialists = recruitmentOfSpecialists();
    }

    public List<Specialist> recruitmentOfSpecialists() {
        List<Specialist> specialists = new ArrayList<>();
        for (int i = 0 ; i < NUMBER_OF_SPECIALISTS ; i++) {
            specialists.add(new Specialist());
        }
        return specialists;
    }

    public void callGeneration() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        try {
            while (((System.currentTimeMillis() - startTime) / 1_000) < WORKING_TIME_IN_SECONDS) {
                TimeUnit.SECONDS.sleep(UNIT_OF_TIME_IN_SECONDS_FOR_GENERATION);
                for (int i = 1; i <= NUMBER_OF_CALLS_PER_UNIT_OF_TIME; i++) {
                    totalCalls ++;
                    String newCall = "Звонок № " + totalCalls;
                    queueCalls.add(newCall);
                }
                System.out.printf("Колл-центр принял очередные %d звонков, всего поступило %d звонков.\n",
                        NUMBER_OF_CALLS_PER_UNIT_OF_TIME, totalCalls);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void callProcessing(int numberOfSpecialist) {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        String nameOfThread = Thread.currentThread().getName() + ":";
        String specialist = specialists.get(numberOfSpecialist).getSpecialist();
        try {
            while (((System.currentTimeMillis() - startTime) / 1_000) < WORKING_TIME_IN_SECONDS) {
                TimeUnit.SECONDS.sleep(UNIT_OF_TIME_IN_SECONDS_FOR_PROCESSING);
                if (!queueCalls.isEmpty()) {
                    String processedCall = queueCalls.poll();
                    System.out.printf("%s %s - обработал %s.\n",
                            nameOfThread, specialist, processedCall);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
