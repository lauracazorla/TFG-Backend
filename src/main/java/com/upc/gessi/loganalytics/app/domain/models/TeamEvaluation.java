package com.upc.gessi.loganalytics.app.domain.models;

import com.upc.gessi.loganalytics.app.domain.models.pkey.TeamEvaluationPrimaryKey;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TeamEvaluation")
@IdClass(TeamEvaluationPrimaryKey.class)
public class TeamEvaluation {

    @Id @Column (name = "date", nullable = false)
    private String date;
    @Id @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "internalMetric", referencedColumnName = "id", nullable = false)
    private InternalMetric internalMetric;
    @Id @Column(name = "team", nullable = false)
    private String team;

    @Column (name = "evaluationValue", nullable = false)
    private double value;

    public TeamEvaluation() {
    }

    public TeamEvaluation(String date, InternalMetric internalMetric, String team) {
        this.date = date;
        this.internalMetric = internalMetric;
        this.team = team;
    }

    public TeamEvaluation(String date, InternalMetric internalMetric, String team, double value) {
        this.date = date;
        this.internalMetric = internalMetric;
        this.team = team;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public InternalMetric getInternalMetric() {
        return internalMetric;
    }

    public void setInternalMetric(InternalMetric internalMetric) {
        this.internalMetric = internalMetric;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamEvaluation that)) return false;
        return Double.compare(that.getValue(), getValue()) == 0 && Objects.equals(getDate(), that.getDate()) && Objects.equals(getInternalMetric(), that.getInternalMetric()) && Objects.equals(getTeam(), that.getTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getInternalMetric(), getTeam(), getValue());
    }

    @Override
    public String toString() {
        return "TeamEvaluation{" +
                "date='" + date + '\'' +
                ", internalMetric=" + internalMetric +
                ", team='" + team + '\'' +
                ", value=" + value +
                '}';
    }
}
