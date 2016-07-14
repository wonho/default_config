package edu.showcase.system.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
public class DatabaseConfig {

//<jdbc:embedded-database id="dataSource" type="HSQL">
//<jdbc:script location="classpath:jdbc/schema.sql"/>
//<jdbc:script location="classpath:jdbc/data.sql"/>
//</jdbc:embedded-database>
	@Bean
//	@Profile("dev")
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				   .setType(EmbeddedDatabaseType.HSQL)
				   .addScript("classpath:jdbc/schema.sql")
				   .addScript("classpath:jdbc/data.sql")
				   .build();
	}
}
