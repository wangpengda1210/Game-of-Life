class Army {

    public static void createArmy() {
        Unit unit1 = new Unit("a");
        Unit unit2 = new Unit("b");
        Unit unit3 = new Unit("c");
        Unit unit4 = new Unit("d");
        Unit unit5 = new Unit("e");

        Knight knight1 = new Knight("f");
        Knight knight2 = new Knight("g");
        Knight knight3 = new Knight("h");

        General general = new General("i");

        Doctor doctor = new Doctor("j");
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