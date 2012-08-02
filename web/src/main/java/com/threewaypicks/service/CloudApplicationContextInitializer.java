package com.threewaypicks.service;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/2/12
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloudApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        CloudEnvironment env = new CloudEnvironment();
        if (env.getInstanceInfo() != null) {
            // We're running in the cloud, set the profile accordingly
            applicationContext.getEnvironment().setActiveProfiles("cloud");
        } else {
            applicationContext.getEnvironment().setActiveProfiles("default");
        }
    }

}