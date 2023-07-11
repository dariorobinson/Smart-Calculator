class Army {

    public static void createArmy() {
        Unit unit1 = new Unit("A");
        Unit unit2 = new Unit("B");
        Unit unit3 = new Unit("C");
        Unit unit4 = new Unit("D");
        Unit unit5 = new Unit("E");

        Knight knight1 = new Knight("F");
        Knight knight2 = new Knight("G");
        Knight knight3 = new Knight("H");

        General general = new General("I");

        Doctor doctor = new Doctor("J");
        // Create all objects here
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}