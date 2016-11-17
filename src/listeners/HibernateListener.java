package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.AnnuaireDAO;
import util.HibernateUtil;

public class HibernateListener implements ServletContextListener {
	
	private AnnuaireDAO annuaire = new AnnuaireDAO();
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory(); // Initialisation de la fabrique
		annuaire.creationAnnuaireLancementServeur();
	}

	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSessionFactory().close(); // Fermeture
	}
}