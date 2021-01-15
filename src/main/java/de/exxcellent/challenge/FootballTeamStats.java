package de.exxcellent.challenge;

/// Immutable plain data object which stores weather based data.
public class FootballTeamStats {
    private String team_name;
    private int goals_scored;
    private int goals_allowed;

    String getTeamName() {
        return team_name;
    }

    int getGoalsScored() {
        return goals_scored;
    }

    int getGoalsAllowed() {
        return goals_allowed;
    }
}
