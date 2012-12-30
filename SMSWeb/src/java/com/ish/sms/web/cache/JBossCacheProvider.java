package com.ish.sms.web.cache;

import javax.management.MBeanServer;

import org.jboss.cache.CacheException;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.TreeCache;
import org.jboss.cache.TreeCacheMBean;
import org.jboss.mx.util.MBeanProxyExt;
import org.jboss.mx.util.MBeanServerLocator;
import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dto.ReferenceListDTO;
import com.ish.sms.web.business.ReferenceBusiness;
import com.ish.sms.web.util.WebConstants;

/**
 * A JBossCache service provider provides the API to manipulate the cache.
 * Provides ways to access or delete nodes/data from the cache.
 * 
 * @author Naren
 * 
 */

public class JBossCacheProvider implements WebConstants {

	private TreeCache tree;
	private long cacheHitCount = 0L;
	private long nonCacheHitCount = 0L;

	@Autowired
	private ReferenceBusiness referenceBusiness;

	/**
	 * Method to start the tree cache service and call the methods to create the
	 * cache
	 * 
	 * @throws Exception
	 */
	public void startCache() throws Exception {
		tree = new TreeCache();
		PropertyConfigurator config = new PropertyConfigurator();
		config.configure(tree, REPL_SYNC_FILE);
		tree.startService();
		createReferenceServiceCache();
	}

	/**
	 * Method to create the reference data tree cache
	 * 
	 * @throws Exception
	 */
	public void createReferenceServiceCache() throws Exception {
		ReferenceListDTO referenceListDTO = referenceBusiness.retrieveAllReferenceList();
		put(BLOOD_GROUP_FQN, BLOOD_GROUP_KEY, referenceListDTO.getBloodGroupDTOList());
		put(STATE_FQN, STATE_KEY, referenceListDTO.getStateDTOList());
		put(MODE_OF_TRANSPORT_FQN, MODE_OF_TRANSPORT_KEY, referenceListDTO.getModeofTransportDTOList());
		put(EXTRA_CURRICULAR_FQN, EXTRA_CURRICULAR_KEY, referenceListDTO.getExtraCurricularDTOList());
		put(CLASS_FQN, CLASS_KEY, referenceListDTO.getClassDTOList());
	}

	/**
	 * Method to register the tree cache mbean
	 * 
	 * @throws Exception
	 */
	public void initCache() throws Exception {
		MBeanServer server = MBeanServerLocator.locateJBoss();
		MBeanProxyExt.create(TreeCacheMBean.class, TREECACHE_MBEAN_SERVICE, server);
	}

	/**
	 * Method to get the values into the tree cache
	 * 
	 * @param fqn
	 * @param key
	 * @return result
	 * @throws CacheException
	 */
	public Object get(String fqn, Object key) throws CacheException {
		Object result = null;
		if (tree != null) {
			result = tree.get(fqn, key);
		}
		if (result == null)
			incrementNonCacheHitCount();
		else
			incrementCacheHitCount();
		return result;
	}

	/**
	 * Method to put the values into the tree cache
	 * 
	 * @param fqn
	 * @param key
	 * @param results
	 * @throws CacheException
	 */
	public void put(String fqn, Object key, Object results) throws CacheException {
		if (tree != null) {
			tree.put(fqn, key, results);
		}
	}

	public void incrementNonCacheHitCount() {
		synchronized (this) {
			nonCacheHitCount++;
		}
	}

	public long getNonCacheHitCount() {
		return nonCacheHitCount;
	}

	public void incrementCacheHitCount() {
		synchronized (this) {
			cacheHitCount++;
		}
	}

	public long getCacheHitCount() {
		return cacheHitCount;
	}

}
