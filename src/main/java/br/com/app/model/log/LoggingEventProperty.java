package br.com.app.model.log;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Table(name = "logging_event_property")
@Subselect("select * from logging_event_property") //pra nao criar a tabela automaticamente
@IdClass(LoggingEventProperty.LoggingEventPropertyPK.class)
public class LoggingEventProperty {

//	@Id
//	private Long eventId;

	@Id
	private String mappedKey;
	
	private String mappedValue;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "event_id"/*, referencedColumnName="eventId", insertable = false, updatable = false*/)
	private LoggingEvent loggingEvent;
	
//	public Long getEventId() {
//		return eventId;
//	}
//
//	public void setEventId(Long eventId) {
//		this.eventId = eventId;
//	}

	public String getMappedKey() {
		return mappedKey;
	}

	public void setMappedKey(String mappedKey) {
		this.mappedKey = mappedKey;
	}

	public String getMappedValue() {
		return mappedValue;
	}

	public void setMappedValue(String mappedValue) {
		this.mappedValue = mappedValue;
	}

	@SuppressWarnings("serial")
	public static class LoggingEventPropertyPK implements Serializable {
		private LoggingEvent loggingEvent;
		private String mappedKey;
		
		public LoggingEvent getLoggingEvent() {
			return loggingEvent;
		}
		
		public void setLoggingEvent(LoggingEvent loggingEvent) {
			this.loggingEvent = loggingEvent;
		}
		
		public String getMappedKey() {
			return mappedKey;
		}
		
		public void setMappedKey(String mappedKey) {
			this.mappedKey = mappedKey;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((loggingEvent == null) ? 0 : loggingEvent.hashCode());
			result = prime * result
					+ ((mappedKey == null) ? 0 : mappedKey.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoggingEventPropertyPK other = (LoggingEventPropertyPK) obj;
			if (loggingEvent == null) {
				if (other.loggingEvent != null)
					return false;
			} else if (!loggingEvent.equals(other.loggingEvent))
				return false;
			if (mappedKey == null) {
				if (other.mappedKey != null)
					return false;
			} else if (!mappedKey.equals(other.mappedKey))
				return false;
			return true;
		}
		
		
	}
}
