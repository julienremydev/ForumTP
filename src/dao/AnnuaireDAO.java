package dao;

import java.util.ArrayList;
import java.util.List;

import forum.Abonne;
import forum.Annuaire;
import forum.Particulier;
import util.HibernateUtil;

public class AnnuaireDAO {

	public static final String ANNUAIRE_ABOS = "Annuaire de tous les abonnés";

	public void creationAnnuaireLancementServeur() {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Annuaire annuaire = new Annuaire(ANNUAIRE_ABOS);
		HibernateUtil.getSessionFactory().getCurrentSession().save(annuaire);
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Annuaire rechercheParNomAnnuaire(String nom) {

		List<Annuaire> annuaire = new ArrayList<Annuaire>();
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		annuaire = HibernateUtil.sessionFactory.getCurrentSession().createQuery("from Annuaire where nom=?")
				.setParameter(0, nom).list();

		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		if (annuaire.size() > 0) {
			return annuaire.get(0);
		} else {
			return null;
		}

	}
	public void addAbo(Annuaire annuaire, Abonne abo) {

		HibernateUtil.getSessionFactory()
        .getCurrentSession().beginTransaction();
		annuaire.getTopic().add(abo);
		HibernateUtil.getSessionFactory()
        .getCurrentSession().update(annuaire);

		HibernateUtil.getSessionFactory()
        .getCurrentSession().getTransaction().commit();

	}
}
