package it.umana;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import it.umana.persistence.BibliotecaDataStore;

public class BibliotecaContextListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContextListener.super.contextInitialized(servletContextEvent);
		BibliotecaDataStore.startDataStore(); 
    }
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		BibliotecaDataStore.stopDataStore();
		ServletContextListener.super.contextDestroyed(sce);
	}
	

}