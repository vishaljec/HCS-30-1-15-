package com.hcs.services;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;

import com.hcs.activities.ParentScreen;
import com.hcs.beans.Registerbean;
import com.hcs.progressbar.ProgressHUD;

/**
 * @author Amareshy
 * @Date May 21, 2014
 * @Description This class performs web service calling task.
 */
public class HTTPAsyncServiceTask extends AsyncTask<Object, Void, Object> implements OnCancelListener{
	// private static final Logger LOGGER =
	// Logger.getLogger(HTTPAsyncServiceTask.class);
	private ParentScreen activity = null;
	private String progressMsg;
	private ProgressHUD mProgressHUD;    	
	private HCSServices hcsServices;
	public HTTPAsyncServiceTask(ParentScreen activity, String progressMsg) {
		this.activity = activity;
		this.progressMsg = progressMsg;
		hcsServices=new HCSServices();
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		mProgressHUD = ProgressHUD.show(activity,progressMsg, true,false,this);
		//activity.displayManager.showProgressBar(activity, progressMsg);
	}

	@Override
	protected Object doInBackground(Object... params) {
		Object responseObject = null;
		try {
 			

			Object object = params[0];
			if (object instanceof Registerbean) {
				responseObject = hcsServices.agentRegistrationService((Registerbean) object);
 			} 
		} catch (Exception e) {
			// LOGGER.error("Error occured inside doInBackground ", e);
		} finally {
		
		}

		return responseObject;
	}

	@Override
	protected void onPostExecute(Object result) {
		super.onPostExecute(result);
		mProgressHUD.dismiss();
		if (result == null || result instanceof String) {
			this.activity.onErrorReceived((String) result);
		} else {
			this.activity.onResponseReceived(result);
		}
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		// TODO Auto-generated method stub
		mProgressHUD.dismiss();
	}

}
