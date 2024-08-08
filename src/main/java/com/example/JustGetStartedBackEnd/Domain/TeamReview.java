package com.example.JustGetStartedBackEnd.Domain;

import com.example.JustGetStartedBackEnd.Member.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="team_review")
@NoArgsConstructor
public class TeamReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_review_id")
    private int teamReviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_name")
    private Team team;

    @Column(name="rating")
    private float rating;

    @Column(name="content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writter")
    private Member writter;

    @Builder
    TeamReview(Team team, float rating, String content, Member writter) {
        this.team = team;
        this.rating = rating;
        this.content = content;
        this.writter = writter;
    }
}
