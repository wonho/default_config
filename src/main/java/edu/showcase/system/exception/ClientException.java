package edu.showcase.system.exception;


/**
 * 
 * 클라이언트로 에러 메시지 및 에러 코드를 전달하기 위한 예외 클래스.
 * <p>
 * 클라이언트에서는 에러 메시지를 메시지 매핑 테이블에 의해 변환하여 사용자에게 보여주도록 한다.
 * <p>
 * 에러 코드에 따라 공통 스크립트 또는 개별 트랜젝션 스크립트에서 화면 동작을 결정하도록 한다.
 * <p>
 * 시스템 공통 부분 설정에서는 이 예외에 대한 view resolver와 view를 설정해주도록 한다.
 * 
 * 
 * @author setq
 *
 */
public class ClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	/**
	 * 에러 메시지 코드와 에러 코드를 클라이언트로 반환하기 위해 사용되는 예외 생성자.
	 * 
	 * @param errorCode
	 * @param errorMessageCode
	 */
	public ClientException(String errorCode, String errorMessageCode) {
		super(errorMessageCode);
		this.errorCode = errorCode;
	}
	
	/**
	 * 에러 메시지 코드와 에러 코드를 클라이언트로 반환하기 위해 사용되는 예외 생성자.
	 * <p>
	 * 파라미터는 에러 메시지 코드가 메시지로 변환되어 파싱될 때 치환해넣을 값이다.
	 * <p>
	 * 메시지 파싱 규칙은 클라이언트 공통 스크립트 참조.
	 * 
	 * @param errorCode
	 * @param errorMessageCode
	 * @param param
	 */
	/*
	public ClientException(String errorCode, String errorMessageCode, Object param) {
		super(convertToString(errorMessageCode, param));
		this.errorCode = errorCode;
	}
    */

	/**
	 * 에러 메시지 코드와 에러 코드를 클라이언트로 반환하기 위해 사용되는 예외 생성자.
	 * <p>
	 * 파라미터는 에러 메시지 코드가 메시지로 변환되어 파싱될 때 치환해넣을 값이다.
	 * <p>
	 * 메시지 파싱 규칙은 클라이언트 공통 스크립트 참조.
	 * 
	 * @param errorCode
	 * @param errorMessageCode
	 * @param param
	 */	
	public ClientException(String errorCode, String... messageParam) {
		super(arrayToString(messageParam));
		this.errorCode = errorCode;		
	}
	
	/**
	 * 에러 코드 반환.
	 * @return 에러코드.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	private static String arrayToString(String... messageParam) {
		if (messageParam == null) return "";
		
		StringBuffer sb = new StringBuffer();		
		
		for (int i = 0; i < messageParam.length; i++) {
			if (i > 0) sb.append(",");
			sb.append(messageParam[i]);
		}
		return sb.toString();
	}	
	
	private static String convertToString(String errorMessageCode, Object param) {
		return errorMessageCode + "|" + (param ==  null? "":param);
	}
	
}
