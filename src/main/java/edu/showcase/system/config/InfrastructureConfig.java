package edu.showcase.system.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.showcase.system.dao.CommonDao;
import edu.showcase.system.dao.CommonDaoImpl;

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
//<tx:annotation-driven>
@EnableTransactionManagement
public class InfrastructureConfig {
		
	//<bean id="transactionManager"
	//class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
	//p:dataSource-ref="dataSource" />
	@Bean
	public PlatformTransactionManager transactionManager() {
	  return new DataSourceTransactionManager(dataSource);
	}
	
	//<bean id="commonDao" class="edu.showcase.system.dao.CommonDaoImpl">
	//<property name="sqlSessionTemplate" ref="sqlSessionTemplate" />
	//</bean>
	@Bean
	public CommonDao commonDao() throws Exception {
		CommonDaoImpl commonDao = new CommonDaoImpl();
		commonDao.setSqlSessionTemplate(sqlSessionTemplate());
		return commonDao;
	}
	
	//<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate"  destroy-method="clearCache">
	//<constructor-arg ref="sqlSessionFactory" />
	//</bean>
	//
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
	}

	//<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	//<property name="configLocation" value="classpath:jdbc/mybatis-config.xml"/>
	//<property name="mapperLocations" value="classpath:**/service/sqlmap-*.xml" />
	//<property name="dataSource" ref="dataSource" />
	//</bean>

	@Autowired
    private DataSource dataSource;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	// 파라메터이냐 생성자냐
//	@Bean(destroyMethod="clearCache")
	@Bean	
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:jdbc/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:**/service/sqlmap-*.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		return sqlSessionFactoryBean.getObject();
	}

	
}
