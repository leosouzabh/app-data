package br.com.app.repository.log;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.app.model.log.LoggingEvent;

public interface LoggingEventRepository extends Repository<LoggingEvent, Long> {

//	@Query("SELECT distinct lep.loggingEvent FROM LoggingEventProperty lep where lep.mappedKey = :mappedKey and lep.mappedValue = :mappedValue")
	@Query("SELECT distinct le FROM LoggingEvent le join le.properties lep where lep.mappedKey = :mappedKey and lep.mappedValue = :mappedValue order by le.timestmp")
	public List<LoggingEvent> lista(@Param("mappedKey") String mappedKey, @Param("mappedValue") String mappedValue);
	
	public LoggingEvent findOne(Long pk);
}
