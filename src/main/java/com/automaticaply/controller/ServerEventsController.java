package com.automaticaply.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@RestController
@RequestMapping("/server-events")
public class ServerEventsController {

	@GetMapping("/demo")
	public String demo() {
		System.out.println("Done");
		return "Work";
	}
	
	
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>>getEvents() throws IOException {
 /*
        // Read lines from a file
        Stream<String> lines=Files.lines(Path.of(
          //"C:\\Users\\prade\\Downloads\\server-sent-events-example\\server-sent-events-example\\pom.xml"));

        		"C:\\Users\\Rushikesh\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\ServerSentEvents\\pom.xml"));		
        	*/
        
        InputStream inputStream =
        	    new ClassPathResource("data/sample.txt").getInputStream();

        	BufferedReader reader =
        	    new BufferedReader(new InputStreamReader(inputStream));

        	Stream<String> lines = reader.lines();
        		
        // Counter for event IDs
        AtomicInteger counter=new AtomicInteger(1);

        // Convert lines to Server-Sent Events
        return Flux.fromStream(lines)
                // Filter out blank lines
                .filter(line -> !line.isBlank())
                // Map each line to a Server-Sent Event
                .map(line -> ServerSentEvent.<String>builder()
                        // Assign an ID to the event
                        .id(String.valueOf(counter.getAndIncrement()))
                        // Set the data of the event to the line content
                        .data(line)
                        // Set the event type
                        .event("lineEvent")
                        // Set the retry duration
                        .retry(Duration.ofMillis(1000))
                        // Build the Server-Sent Event
                        .build())
                // Introduce a delay between sending each event
                .delayElements(Duration.ofMillis(300));
                } 

    }