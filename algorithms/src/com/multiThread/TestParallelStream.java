package com.multiThread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class TestParallelStream {
    // Replace this with the actual API endpoint and request logic
    private static String makeApiCall(String request) {
        // Implement your API call logic here
        // For simplicity, just returning the request for demonstration
        return "Response for " + request;
    }

    public static void main(String[] args) {
        List<String> requests = generateRequestList(1000);

        // Set the maximum number of concurrent requests
        int maxConcurrentRequests = 4;

        // Create a fixed-size thread pool with the desired number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(maxConcurrentRequests);

        try {
            // Use CompletableFuture to make API calls in parallel
            List<CompletableFuture<String>> futures = requests.stream()
                    .map(request -> CompletableFuture.supplyAsync(() -> makeApiCall(request), executorService))
                    .collect(Collectors.toList());

            // Combine all CompletableFutures into a single CompletableFuture
            CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

            // Wait for all API calls to complete
            allOf.join();

            // Retrieve the results from completed CompletableFutures
            List<String> responses = futures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());

            // Do something with the responses
            responses.forEach(System.out::println);
        } finally {
            // Shutdown the executor service when done
            executorService.shutdown();
        }
    }

    private static List<String> generateRequestList(int size) {
        // Replace this with logic to generate your list of 1000 requests
        return Arrays.asList("Request1", "Request2", /* ... */ "Request1000");
    }
}
