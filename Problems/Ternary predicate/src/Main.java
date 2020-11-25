class Predicate {

    @FunctionalInterface
    public interface TernaryIntPredicate {
        // Write a method here
        boolean test(int first, int second, int third);
    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (x, y, z) -> x != y &&
            x != z && y != z;

}