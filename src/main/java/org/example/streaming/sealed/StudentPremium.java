package org.example.streaming.sealed;

import org.example.streaming.enums.Quality;

public final class StudentPremium extends PremiumSubscription {
    private final String university;

    public StudentPremium(String username, String startDate, String university) {
        super(username, startDate, 14.99, Quality.HIGH); // pret redus pentru studenti
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public String toString() {
        return super.getUsername() + " (din " + super.getStartDate()
                + ") [STUDENT PREMIUM - " + university + " - 14.99 RON/luna]";
    }
}
