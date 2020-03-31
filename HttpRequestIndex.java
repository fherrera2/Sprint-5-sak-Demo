public class HttpRequestIndex extends HttpRequest {
    public int retrievedURL = 0;

    HttpRequestIndex(){
        super();
    }

    // This method finds the time elapsed for the retrieval of all URLs, the average time
    // elapsed for each URL, and the total number of URLs retrieved.
    public Boolean parse() {
        long timeStartFour = System.nanoTime();
        for (final String fileLine : urlContent) {
            parseLine(fileLine);
        }
        long timeFinishFour = System.nanoTime();
        long timeDurationFour = (timeFinishFour - timeStartFour)/1000000;
        System.out.println("Retrieved URLs: " + retrievedURL);
        System.out.println("\nTime elapsed to retrieve URLs: " + timeDurationFour + " ms");
        long averageTime = timeDurationFour/retrievedURL;
        System.out.println("\nAverage time elapsed to retrieve each URL: " + averageTime + " ms");
        return true;
    }

    // This method parses the line in the JSON file or website
    // and looks for URLs. Then if a URL is found an HttpRequest is called.
    private void parseLine(String FileLine) {
        final String[] mySubString = FileLine.split("\"");

        // Substring[9] is the line that holds the label "ContactURL."
        // Substring[11] is the actual URL that will be parsed.
        // These values were found by looking at the result of how each line was parsed.
        // These values only work with how the specific file used is currently formatted.
        if (mySubString.length > 11) {
            if (mySubString[9].equals("ContactURL")) {
                String contactURL = mySubString[11];
                HttpRequestIndex myHttpRequestIndexParse = new HttpRequestIndex();
                if (myHttpRequestIndexParse.readURL(contactURL)) {
                    System.out.println(myHttpRequestIndexParse);
                    retrievedURL += 1;
                }
            }
        }
    }
}