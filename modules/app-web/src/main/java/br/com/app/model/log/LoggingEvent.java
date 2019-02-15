package br.com.app.model.log;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Subselect;

@Entity
@Table(name = "logging_event")
@Subselect("select * from logging_event")  //pra nao criar a tabela automaticamente
public class LoggingEvent {

	@Id
	private Long eventId;
	
	private Long timestmp;
	private String formattedMessage;
	private String levelString;
	
	@OneToMany(mappedBy = "loggingEvent")
	private Set<LoggingEventProperty> properties;
	
	public Long getEventId() {
		return eventId;
	}
	
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public Long getTimestmp() {
		return timestmp;
	}
	
	public void setTimestmp(Long timestmp) {
		this.timestmp = timestmp;
	}
	
	public String getFormattedMessage() {
		return formattedMessage;
	}
	
	public void setFormattedMessage(String formattedMessage) {
		this.formattedMessage = formattedMessage;
	}
	
	public String getLevelString() {
		return levelString;
	}
	
	public void setLevelString(String levelString) {
		this.levelString = levelString;
	}

	public Set<LoggingEventProperty> getProperties() {
		return properties;
	}

	public void setProperties(Set<LoggingEventProperty> properties) {
		this.properties = properties;
	}
	
	@Transient
	public LoggingEventProperty findProperty(String key) {
		for (LoggingEventProperty property : properties) {
			if(property.getMappedKey().equals(key)) {
				return property;
			}
		}
		
		return null;
	}
	
	@Transient
	public Date getData() {
		if(timestmp != null) {
			return new Date(timestmp);
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((formattedMessage == null) ? 0
				: formattedMessage.hashCode());
		result = prime * result
				+ ((levelString == null) ? 0 : levelString.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
		result = prime * result
				+ ((timestmp == null) ? 0 : timestmp.hashCode());
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
		LoggingEvent other = (LoggingEvent) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (formattedMessage == null) {
			if (other.formattedMessage != null)
				return false;
		} else if (!formattedMessage.equals(other.formattedMessage))
			return false;
		if (levelString == null) {
			if (other.levelString != null)
				return false;
		} else if (!levelString.equals(other.levelString))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (timestmp == null) {
			if (other.timestmp != null)
				return false;
		} else if (!timestmp.equals(other.timestmp))
			return false;
		return true;
	}
}
