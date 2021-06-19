package io.friendlyfoods.ffspringbootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration //makes this as a bean
@ConfigurationProperties("db")  //looks for properties similar to db and update it with corresponding names
public class DbSettingsFromProps {

	private String dbConnectionName;
	private String dbHost;
	private int dbPort;
	
	public String getDbConnectionName() {
		return dbConnectionName;
	}

	public void setDbConnectionName(String dbConnectionName) {
		this.dbConnectionName = dbConnectionName;
	}

	public String getDbHost() {
		return dbHost;
	}

	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	public int getDbPort() {
		return dbPort;
	}

	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}

	public DbSettingsFromProps() {
	}

	
}
