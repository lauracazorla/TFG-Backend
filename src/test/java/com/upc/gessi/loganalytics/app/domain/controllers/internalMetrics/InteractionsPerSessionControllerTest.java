package com.upc.gessi.loganalytics.app.domain.controllers.internalMetrics;

import com.upc.gessi.loganalytics.app.domain.controllers.SessionController;
import com.upc.gessi.loganalytics.app.domain.models.Session;
import com.upc.gessi.loganalytics.app.domain.models.Subject;
import com.upc.gessi.loganalytics.app.domain.models.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InteractionsPerSessionControllerTest {

    @Mock
    SessionController sessionController;

    @InjectMocks
    InteractionsPerSessionController interactionsPerSessionController;

    @Test
    void evaluateByTeam() {
        Subject s = new Subject("s");
        Team team1 = new Team("t1", "22-23-Q1", s);
        Team team2 = new Team("t2", "22-23-Q1", s);
        List<Session> sessions = new ArrayList<>();
        Session session1 = new Session("s", team1, 0, 10, 10, 10);
        Session session2 = new Session("s", team1, 15, 25, 10, 5);
        sessions.add(session1); sessions.add(session2);
        Mockito.when(sessionController.getAllByTeam(Mockito.any())).thenReturn(sessions);
        assertEquals(7.5, interactionsPerSessionController.evaluate(team1));
    }

    @Test
    void evaluateBySubject() {
        Subject s = new Subject("s");
        Team team1 = new Team("t1", "22-23-Q1", s);
        Team team2 = new Team("t2", "22-23-Q1", s);
        List<Session> sessions = new ArrayList<>();
        Session session1 = new Session("s", team1, 0, 10, 10, 10);
        Session session2 = new Session("s", team1, 15, 25, 10, 5);
        sessions.add(session1); sessions.add(session2);
        Mockito.when(sessionController.getAllBySubject(Mockito.any())).thenReturn(sessions);
        assertEquals(7.5, interactionsPerSessionController.evaluate(s));
    }

    @Test
    void evaluate() {
        Subject s = new Subject("s");
        Team team1 = new Team("t1", "22-23-Q1", s);
        Team team2 = new Team("t2", "22-23-Q1", s);
        List<Session> sessions = new ArrayList<>();
        Session session1 = new Session("s", team1, 0, 10, 10, 10);
        Session session2 = new Session("s", team1, 15, 25, 10, 5);
        sessions.add(session1); sessions.add(session2);
        Mockito.when(sessionController.getAll()).thenReturn(sessions);
        assertEquals(7.5, interactionsPerSessionController.evaluate());
    }
}