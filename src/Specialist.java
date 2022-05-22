import javax.swing.text.Position;

public class Specialist {
    private Positions position;
    private Names name;
    private final int LOWER_THRESHOLD_POSITION = 1;
    private final int UPPER_THRESHOLD_POSITION = 3;
    private final int LOWER_THRESHOLD_NAME = 1;
    private final int UPPER_THRESHOLD_NAME = 5;

    public Specialist() {
        this.position = Positions.getPosition(setThreshold(LOWER_THRESHOLD_POSITION, UPPER_THRESHOLD_POSITION));
        this.name = Names.getName(setThreshold(LOWER_THRESHOLD_NAME, UPPER_THRESHOLD_NAME));
    }

    public String getPosition() {
        return this.position.getNameOfPosition();
    }

    public String getName() {
        return this.name.getNameOfName();
    }

    public String getSpecialist() {
        return this.position.getNameOfPosition() + " " + this.name.getNameOfName();
    }


    private int setThreshold(int lowerThreshold, int upperThreshold) {
        upperThreshold -= lowerThreshold;
        int count = (int) (Math.random() * ++upperThreshold) + lowerThreshold;
        return count;
    }
}
