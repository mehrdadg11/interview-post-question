package com.blubank.interviewpostquestion.controller;

import com.blubank.interviewpostquestion.controller.api.tweet.TweetSaveRequest;
import com.blubank.interviewpostquestion.service.TweetService;
import com.blubank.interviewpostquestion.service.api.tweet.TweetSaveParam;
import com.blubank.interviewpostquestion.service.api.tweet.TweetSaveResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TweetRestController {

    private final TweetService tweetService;

    @PostMapping("/tweets")
    public TweetSaveResult getTweets(@RequestBody TweetSaveRequest request) {
        TweetSaveParam params = TweetSaveParam.builder().author(request.getAuthor()).content(request.getContent()).build();

        return tweetService.save(params);
    }
}
