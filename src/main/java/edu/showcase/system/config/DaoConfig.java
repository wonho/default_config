package edu.showcase.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//<jdbc:embedded-database id="dataSource" type="HSQL">
//<jdbc:script location="classpath:jdbc/schema.sql"/>
//<jdbc:script location="classpath:jdbc/data.sql"/>
//</jdbc:embedded-database>
//
//<bean id="commonDao" class="edu.showcase.system.dao.CommonDaoImpl">
//<property name="sqlSessionTemplate" ref="sqlSessionTemplate" />
//</bean>
//
//<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
//<property name="configLocation" value="classpath:jdbc/mybatis-config.xml"/>
//<property name="mapperLocations" value="classpath:**/service/sqlmap-*.xml" />
//<property name="dataSource" ref="dataSource" />
//</bean>
//
//<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate"  destroy-method="clearCache">
//<constructor-arg ref="sqlSessionFactory" />
//</bean>
//
//<bean id="transactionManager"
//class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
//p:dataSource-ref="dataSource" />
//
//<tx:advice id="txAdvice" transaction-manager="transactionManager">
//<tx:attributes>
//		<tx:method name="get*" read-only="true" />
//		<tx:method name="find*" read-only="true" />
//		<tx:method name="select*" read-only="true" />
//		<tx:method name="retrieve*" read-only="true" />
//	<tx:method name="*TxNew" propagation="REQUIRES_NEW" />
//	<tx:method name="*" propagation="REQUIRED" />
//</tx:attributes>
//</tx:advice>
//
//<aop:config>
//<aop:pointcut id="serviceMethods"
//	expression="execution(* *..*Service.*(..))" />
//<aop:advisor advice-ref="txAdvice" pointcut-ref="serviceMethods" />
//</aop:config>


@Configuration
public class DaoConfig {
	
	@Bean
    @Profile("dev")
	public String getDataDev() {
		String database ="mysql";
		return database;
	}
	
	@Bean
    @Profile("real")
	public String getDataReal() {
		String database ="oracle";
		return database;
	}	
}
