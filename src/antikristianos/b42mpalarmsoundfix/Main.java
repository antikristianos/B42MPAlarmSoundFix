package antikristianos.b42mpalarmsoundfix;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        String version = Main.class.getPackage().getImplementationVersion();
        System.out.println("[B42MPAlarmSoundFix] Java " + (version == null ? "development" : version)
                + " loaded; local MP alarm owner correction; awaiting native hook use.");
    }
}
