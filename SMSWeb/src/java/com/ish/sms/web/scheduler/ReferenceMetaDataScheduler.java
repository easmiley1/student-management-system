package com.ish.sms.web.scheduler;

import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

import com.ish.sms.web.cache.JBossCacheProvider;

/**
 * Class to run scheduled jobs and do routine operations
 * 
 * @author Naren
 *
 */
public class ReferenceMetaDataScheduler {

	private JBossCacheProvider jbossCacheProvider;

	/**
	 * @return the jbossCacheProvider
	 */
	public JBossCacheProvider getJbossCacheProvider() {
		return jbossCacheProvider;
	}


	/**
	 * @param jbossCacheProvider the jbossCacheProvider to set
	 */
	public void setJbossCacheProvider(JBossCacheProvider jbossCacheProvider) {
		this.jbossCacheProvider = jbossCacheProvider;
	}


	/**
	 * Scheduler method which gets called every day to refresh the reference data
	 * 
	 * @throws Exception
	 */
	public void loadReferenceData() throws Exception {
		jbossCacheProvider.initCache();
		jbossCacheProvider.startCache();
		
	}

}
