package interpret.clarify.prompt;

public class Test {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory()/(long)Math.pow(2, 20));
        System.out.println(runtime.freeMemory());
    }
}