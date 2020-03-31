public class sak {

    // This program is for the command line and is used to test different features.
    // Some examples of features include HttpRequest and HttpRequestIndex.
    // The user can input three different parameters before the program executes.
    // The time elapsed is given for each function after the function executes.
    public static void main(String[] args) {
        System.out.println();
        if (args.length == 0) {
            System.out.println("The sak application needs an argument to run. Type in \"-Help\""
            + " after java sak for helpful instructions.\n");
            HelpCommand.help();
        }
        else if (args[0].equalsIgnoreCase("-help")) {
            HelpCommand.help();
        }

        // If -httpsrequest is used as a parameter with a URL the program will take data from that
        // URL and place it in an ArrayList of strings and output it to the console.
        else if (args[0].equalsIgnoreCase("-httprequest")) {
            System.out.println("Executing HttpRequest...");
            long timeStartTwo = System.nanoTime();
            if (args.length != 2) {
                System.out.println("\nA URL is needed as the second parameter for -HttpRequest.");
            }
            else {
                String requestURL = args[1];
				HttpRequest myHttpRequest = new HttpRequest();
				if (myHttpRequest.readURL(requestURL)) {
					System.out.println(myHttpRequest);
				};
            }
            long timeFinishTwo = System.nanoTime();
            long timeDurationTwo = (timeFinishTwo - timeStartTwo)/1000000;
            System.out.println("\nTime elapsed for HttpRequest: " + timeDurationTwo + " ms\n");
        }
        else if (args[0].equalsIgnoreCase("-httprequestindex")) {
            System.out.println("Executing HttpRequestIndex...");
            long timeStartThree = System.nanoTime();
            if (args.length != 2) {
                System.out.println("\nA URL is needed as the second parameter for"
                + "-HttpRequestIndex.");
            }
            else {
                String requestIndexURL = args[1];
                HttpRequestIndex myHttpRequestIndex = new HttpRequestIndex();
                if (myHttpRequestIndex.readURL(requestIndexURL)) {
                    System.out.println(myHttpRequestIndex);
                    myHttpRequestIndex.parse();
                }
            }
            long timeFinishThree = System.nanoTime();
            long timeDurationThree = (timeFinishThree - timeStartThree)/1000000;
            System.out.println("\nTime elapsed for HttpRequestIndex: " + timeDurationThree + 
            " ms\n");
        }
    }   
}