package com.blubank.interviewpostquestion.service.impl;

import com.blubank.interviewpostquestion.domain.Tweet;
import com.blubank.interviewpostquestion.domain.TweetHashTag;
import com.blubank.interviewpostquestion.repository.TweetRepository;
import com.blubank.interviewpostquestion.service.TweetService;
import com.blubank.interviewpostquestion.service.api.tweet.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    @Override
    public TweetSaveResult save(TweetSaveParam param) {
        Tweet tweet = Tweet.builder().author(param.getAuthor()).content(param.getContent()).build();

        Set<TweetHashTag> hastags = new HashSet<>();

        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(param.getContent());

        while (matcher.find()) {
            hastags.add(TweetHashTag.builder().title(matcher.group()).build());
        }

        tweet.setTweetHashTagSet(hastags);

        Tweet savedTweet = tweetRepository.save(tweet);
        return TweetSaveResult.builder().tweetId(savedTweet.getId()).build();
    }

    @Override
    public TweetLikeResult like(TweetLikeParam param) {
        return null;
    }

    @Override
    public TweetModel load(TweetLoadParam param) {
        return null;
    }
}
