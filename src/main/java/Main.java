import picocli.CommandLine;

@CommandLine.Command(name="greeting",
        mixinStandardHelpOptions = true,
        description = "Says hello the caller, or world if no name is passed")
public class Main implements Runnable {


    /*
    *
    * This field is a representation of our first argument
    * that we pass into the program. Note that we defined a
    * default value for the field
    *
    * */
    @CommandLine.Parameters(index = "0",
            description = "Name of user",
            defaultValue = "world")
    private String name;

    /*
    *
    * Business logic would reside in the overridden method below.
    * Note that this class needs to implement Runnable or Callable.
    *
    * */
    @Override
    public void run() {
        System.out.printf("Hello %s!", name);
    }

    public static void main(String[] args) {
        /*
        *
        * Instead of passing in "args", you can pass in a string value
        * that will serve as your first argument. If you leave it as "args",
        * the program will print "Hello world!" If you pass in "Jimmy",
        * the program will print "Hello Jimmy!"
        *
        * */
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
