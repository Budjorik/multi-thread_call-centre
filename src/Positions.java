public enum Positions {
    JUNIOR (1,"младший специалист"),
    MIDDLE (2,"специалист"),
    SENIOR (3,"старший специалист");

    int number;
    String position;

    Positions(int number, String position) {
        this.number = number;
        this.position = position;
    }

    public String getNameOfPosition() {
        return this.position;
    }

    public static Positions getPosition(int number) {
        switch (number) {
            case 1:
                return JUNIOR;
            case 2:
                return MIDDLE;
            case 3:
                return SENIOR;
            default:
                return null;
        }
    }
}

