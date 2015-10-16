package com.hcs.services;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.hcs.activities.Registration;
import com.hcs.beans.Registerbean;
import com.hcs.constants.ApplicationConstants;
import com.hcs.http.HttpConnectionManager;

/**
 * @author amareshy
 * @Date May 21, 2014
 * @Description Service layer. Service class for handling input and output after
 *              interacting with APIs.
 */
public class HCSServices implements ApplicationConstants {
	private static Logger LOGGER = Logger
			.getLogger(HCSServices.class);

	/**
	 * @author vishal jangid
	 * @Date May 22, 2014
	 * @param baseUrl
	 * @param loginRequestBean
	 * @return JSONObject
	 * @Description Call agent login web service and return the response data.
	 */
	public String agentRegistrationService( Registerbean loginRequestBean) {
		String responseObject = null;
		try {
			HashMap<String, String> postDataParams  = new HashMap<String, String>();
			postDataParams.put(PHONE_NUMBER, loginRequestBean.getMobileNumber());
			postDataParams.put(EMAIL, loginRequestBean.getEmail());
			postDataParams.put(FULL_NAME,loginRequestBean.getFullName());
			postDataParams.put(PASSWORD,loginRequestBean.getPassword());
			
			
			HttpConnectionManager httpConnManager = new HttpConnectionManager();
			responseObject = httpConnManager.performPostCall(BASE_URL + REGISTER, postDataParams);
		} catch (Exception e) {
			LOGGER.error( "Error occurred in agent authentication service " +
			e.getMessage(), e);
			e.printStackTrace();
		}
		return responseObject;
	}





}
