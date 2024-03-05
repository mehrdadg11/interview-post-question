package com.blubank.interviewpostquestion.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tweets")
public class Tweet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String author;

    @Column
    private String content;

    @ManyToMany(cascade = { CascadeType.ALL })
    private Set<TweetHashTag> tweetHashTagSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return id.equals(tweet.id) && author.equals(tweet.author) && content.equals(tweet.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, content);
    }
}
