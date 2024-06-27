package com.siemens.rate.limiter.controller;

import java.util.concurrent.CompletableFuture;

import com.siemens.rate.limiter.entity.Movie;
import com.siemens.rate.limiter.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
public class TimeLimiterController {
    @Autowired
    private MovieService movieService;
    Logger logger = LoggerFactory.getLogger(TimeLimiterController.class);

    @GetMapping("/getMessageTL/{id}")
    @TimeLimiter(name = "getMessageTL")
    public CompletableFuture<String> getMessage(@PathVariable("id") String id) {
        return CompletableFuture.completedFuture(this.getResponse(id));
    }

    private String getResponse(String id) {

        if (Math.random() < 0.4) {
            //Expected to fail 40% of the time
            Movie movie = movieService.getMovieDetails(id);
            return "Executing Within the time Limit..." + movie.getTitle();
            //return "Executing Within the time Limit...";
        } else {
            try {
                logger.info("Getting Delayed Execution");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Exception due to Request Timeout.";
    }
}
