public class HelpCommand {

    // This class prints user-friendly instructions to the user and gives the user the
    // amount of time that has elapsed during the function.
    public static void help() {
        long timeStartOne = System.nanoTime();
        System.out.println("Executing Help...");
        System.out.println("\nHere are instructions for functions supported by this program.");
        System.out.println("\nHttpRequest [URL] Examples:");
        System.out.println("\njava sak -HttpRequest https://www.lewisu.edu");
        System.out.println("\njava sak -HttpRequest https://web-site-fh.azurewebsites.net/fidelherrera.JSON");
        System.out.println("\nHttpRequestIndex [URL] Example:");
        System.out.println("\njava sak -HttpRequestIndex https://thunderbird-index.azurewebsites.net/w0a6zk195d.json ");
        long timeFinishOne = System.nanoTime();

        // Finds the time elapsed during the function and divides this time by 1000000 to 
        // convert it into milliseconds.
        long timeDurationOne = (timeFinishOne - timeStartOne)/1000000;
        System.out.println("\nTime elapsed for HelpCommand: " + timeDurationOne + " ms\n");
    }
}