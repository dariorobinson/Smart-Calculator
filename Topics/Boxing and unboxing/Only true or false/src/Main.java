class Primitive {
    public static boolean toPrimitive(Boolean b) {

        if (b == null) {
            return false;
        }

        boolean bee = b.booleanValue();

        return bee;
    }
}