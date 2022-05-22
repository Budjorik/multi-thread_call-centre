public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUMBER_OF_SPECIALISTS = 5;
        final long WORKING_TIME_IN_SECONDS = 20;

        CallCentre callCentre = new CallCentre(NUMBER_OF_SPECIALISTS, WORKING_TIME_IN_SECONDS);
        new Thread(null, callCentre::callGeneration, "Колл-центр").start();
        startCallProcessing(callCentre, NUMBER_OF_SPECIALISTS);

    }

    public static void startCallProcessing(CallCentre callCentre, int numberOfSpecialist) {
        for (int i = 0 ; i < numberOfSpecialist ; i++) {
            final int num = i;
            new Thread(null, () -> callCentre.callProcessing(num), "Специалист колл-центра").start();
        }
    }

}
