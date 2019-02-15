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
@Table(name = "logging_event_exception")
@Subselect("select * from logging_event_exception")  //pra nao criar a tabela automaticamente
@IdClass(LoggingEventException.LoggingEventExceptionPK.class)
public class LoggingEventException {

	@Id
	@ManyToOne
	@JoinColumn(name = "event_id"/*, referencedColumnName="eventId", insertable = false, updatable = false*/)
	private LoggingEvent loggingEvent;

	@Id
	private Integer i;
	
	private String traceLine;
	
	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public String getTraceLine() {
		return traceLine;
	}

	public void setTraceLine(String traceLine) {
		this.traceLine = traceLine;
	}

	@SuppressWarnings("serial")
	public static class LoggingEventExceptionPK implements Serializable {
		
		private LoggingEvent loggingEvent;
		private Integer i;
		
		public Integer getI() {
			return i;
		}
		public void setI(Integer i) {
			this.i = i;
		}
		public LoggingEvent getLoggingEvent() {
			return loggingEvent;
		}
		public void setLoggingEvent(LoggingEvent loggingEvent) {
			this.loggingEvent = loggingEvent;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((i == null) ? 0 : i.hashCode());
			result = prime * result
					+ ((loggingEvent == null) ? 0 : loggingEvent.hashCode());
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
			LoggingEventExceptionPK other = (LoggingEventExceptionPK) obj;
			if (i == null) {
				if (other.i != null)
					return false;
			} else if (!i.equals(other.i))
				return false;
			if (loggingEvent == null) {
				if (other.loggingEvent != null)
					return false;
			} else if (!loggingEvent.equals(other.loggingEvent))
				return false;
			return true;
		}

	}
}
