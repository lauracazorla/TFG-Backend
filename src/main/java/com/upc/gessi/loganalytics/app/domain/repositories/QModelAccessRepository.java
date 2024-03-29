package com.upc.gessi.loganalytics.app.domain.repositories;

import com.upc.gessi.loganalytics.app.domain.models.QModelAccess;
import com.upc.gessi.loganalytics.app.domain.models.pkey.LogPrimaryKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QModelAccessRepository extends CrudRepository<QModelAccess, LogPrimaryKey> {

    List<QModelAccess> findByTeamAndViewFormatAndTimeBetween(String team, String viewFormat, long timeBefore, long timeAfter);

}
