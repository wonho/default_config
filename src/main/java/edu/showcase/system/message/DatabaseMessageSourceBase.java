package edu.showcase.system.message;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractMessageSource;

// http://www.journaldev.com/1370/java-i18n-internationalization-in-java
public class DatabaseMessageSourceBase extends AbstractMessageSource {

	private static final Logger LOG = LoggerFactory.getLogger(DatabaseMessageSourceBase.class);
	
	private Messages messages;
	
	@PostConstruct
	public void init() {

//		String i18nQuery = this.getI18NSqlQuery();

//		LOG.info("Initializing message source using query [{}]", i18nQuery);

//		this.messages = jdbcTemplate.query(i18nQuery,
//				new ResultSetExtractor<Messages>() {
//					@Override
//					public Messages extractData(ResultSet rs)
//							throws SQLException, DataAccessException {
//
//						return extractI18NData(rs);
//					}
//				});
	}
	
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		String msg = messages.getMessage(code, locale);
		return createMessageFormat(msg, locale);
	}
	
	protected static final class Messages {
		private Map<String, Map<Locale, String>> messages;

		public void addMessage(String code, Locale locale, String msg) {
			if (messages == null)
				messages = new HashMap<String, Map<Locale, String>>();

			Map<Locale, String> data = messages.get(code);
			if (data == null) {
				data = new HashMap<Locale, String>();
				messages.put(code, data);
			}
			data.put(locale, msg);
		}

		public String getMessage(String code, Locale locale) {
			Map<Locale, String> data = messages.get(code);
			return data != null ? data.get(locale) : null;
		}
	}	

}
