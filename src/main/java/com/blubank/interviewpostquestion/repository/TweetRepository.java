package com.blubank.interviewpostquestion.repository;

import com.blubank.interviewpostquestion.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
