public enum Names {
    IVAN (1,"Иван"),
    PETR (2,"Пётр"),
    TATYANA (3,"Татьяна"),
    ANNA (4,"Анна"),
    SVETLANA (5,"Светлана");

    int number;
    String name;

    Names(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNameOfName() {
        return this.name;
    }

    public static Names getName(int number) {
        switch (number) {
            case 1:
                return IVAN;
            case 2:
                return PETR;
            case 3:
                return TATYANA;
            case 4:
                return ANNA;
            case 5:
                return SVETLANA;
            default:
                return null;
        }
    }
}
