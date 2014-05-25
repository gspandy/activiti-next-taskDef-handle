package com.myfeike.activiti.proxy;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.SpringBeanFactoryProxyMap;
import org.activiti.spring.SpringExpressionManager;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by izerui.com on 14-5-3.
 */
public class BpmFactoryBean implements FactoryBean<BpmEngine>, DisposableBean, ApplicationContextAware {

    protected ProcessEngineConfigurationImpl processEngineConfiguration;
    protected ApplicationContext applicationContext;
    protected BpmEngineImpl processEngine;

    public void destroy() throws Exception {
        if (processEngine != null) {
            processEngine.close();
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public BpmEngine getObject() throws Exception {
        initializeExpressionManager();
        initializeTransactionExternallyManaged();

        if (processEngineConfiguration.getBeans()==null) {
            processEngineConfiguration.setBeans(new SpringBeanFactoryProxyMap(applicationContext));
        }

        processEngine = (BpmEngineImpl) processEngineConfiguration.buildProcessEngine();

        return processEngine;
    }

    protected void initializeExpressionManager() {
        if (processEngineConfiguration.getExpressionManager() == null && applicationContext != null) {
            processEngineConfiguration.setExpressionManager(
                    new SpringExpressionManager(applicationContext, processEngineConfiguration.getBeans()));
        }
    }

    protected void initializeTransactionExternallyManaged() {
        if (processEngineConfiguration instanceof SpringProcessEngineConfiguration) { // remark: any config can be injected, so we cannot have SpringConfiguration as member
            SpringProcessEngineConfiguration engineConfiguration = (SpringProcessEngineConfiguration) processEngineConfiguration;
            if (engineConfiguration.getTransactionManager() != null) {
                processEngineConfiguration.setTransactionsExternallyManaged(true);
            }
        }
    }

    public Class<BpmEngine> getObjectType() {
        return BpmEngine.class;
    }

    public boolean isSingleton() {
        return true;
    }

    // getters and setters //////////////////////////////////////////////////////

    public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        return processEngineConfiguration;
    }


    public void setBpmEngineConfiguration(ProcessEngineConfigurationImpl processEngineConfiguration) {
        this.processEngineConfiguration = processEngineConfiguration;
    }
}
