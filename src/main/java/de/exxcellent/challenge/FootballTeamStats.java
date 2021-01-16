package de.exxcellent.challenge;

/// Immutable plain data object which stores weather based data.
public class FootballTeamStats {
    private String team_name;
    private int goals_scored;
    private int goals_allowed;

    public FootballTeamStats() {}
    public FootballTeamStats(String team_name_, int goals_scored_, int goals_allowed_) {
        team_name = team_name_;
        goals_scored = goals_scored_;
        goals_allowed = goals_allowed_;
    }

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
