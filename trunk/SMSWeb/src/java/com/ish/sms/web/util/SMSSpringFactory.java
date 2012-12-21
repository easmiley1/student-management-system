/*
 * $Revision: 1.2.4.1 $
 * $Archive$
 * $Date: 2012/07/13 20:33:37 $
 * $Author: uvjaya $ 
 * 
 * Copyright © 2010, Arbitron, Inc. All rights reserved.
 */
package com.ish.sms.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SMSSpringFactory {
    /**
     * The name of the system property that defines the spring
     * config location
     */
    public final static String PROP_CONFIGNAME = "spring-config";
    /**
     * The name of the spring config
     */
    public final static String CONFIG_FILE = "smsWebApplicationContext.xml";
    /**
     * The bean id of the spring Factory
     */
    public final static String SPRING_FACTORY = "smsSpringFactory";

    
    /**
     * The static singleton instance 
     * it's marked as protected so the test class can access it
     */
    protected static SMSSpringFactory instance;

    /**
     * Used to instantiate configured beans 
     */
    private BeanFactory beanFactory;
    /**
     * Logger
     */
    private static final Log LOGGER = LogFactory.getLog(SMSSpringFactory.class); 
    /**
     * Gets the name/location of the spring config file. This is a trick
     * to allow us to use both runtime and mock config files, both
     * within eclipse and from our ant scripts.
     * 
     * @return This method inspects the system property "spring-config". If the
     * property is null or empty, then it returns the default config file
     * name. If it's not empty, it returns whatever was defined in the property. 
     */
    protected static final String getConfigName() {
        String result = System.getProperty(PROP_CONFIGNAME);

        if (result == null || "".equals(result)) {
            result = CONFIG_FILE;
        }

        return result;
    } //END getConfigName method

    /**
     * Creates a new spring factory instance based on the given 
     * named configuration
     * @param config the name of the configuration to load 
     * @return a spring factory instance bound to the given config 
     * @throws SpringInitializationException if there was an exception loading
     * or locating the config
     */
    protected static SMSSpringFactory createFromConfig(final String config)  {

        SMSSpringFactory result = null;
        try {
        	BeanFactory beanFactory = new ClassPathXmlApplicationContext(config);
            result = (SMSSpringFactory) beanFactory.getBean(SPRING_FACTORY);
            result.setBeanFactory(beanFactory);
         } catch (Exception e) {
           LOGGER.error(e);
        }
        return result;
    } //END createFromConfig method

    /**
     * Initializes the singleton instance
     * @throws SpringInitializationException if the singleton could not be initialized
     */
    public static void initialize()  {
       
        //synchronize access
        synchronized (SMSSpringFactory.class) {
            if (instance == null) {
                instance = createFromConfig(getConfigName());
            }
        }
       
    } //END initialize method 

    /**
     * Sets the instance's reference to the active bean factory
     * @param value
     */
    private void setBeanFactory(final BeanFactory value) {
        beanFactory = value;
    } //END setBeanFactory method 

    /**
     * Gets the singleton spring factory instance 
     * @return the singleton spring factory instance
     */
    public static SMSSpringFactory getInstance() {
       
        if (instance == null) {
            try {
                initialize();
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
       
        return instance;
    } //END getInstance method

    /**
     * Gets a bean from the spring bean factory
     */
    public Object getBean(final String beanId) {
        return beanFactory.getBean(beanId);
    } //END getBean method

}
