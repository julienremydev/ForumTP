package dao;

import java.util.ArrayList;
import java.util.List;

import forum.Message;
import util.HibernateUtil;

public class MessageDAO {

	@SuppressWarnings("unchecked")
	public List getAllMessages() {
	List<Message> message = new ArrayList<Message>();
	HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	
	message = HibernateUtil.sessionFactory.getCurrentSession().createQuery("from Message").list();
	
	HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	if (message.size() > 0) {
		return message;
	} else {
		return null;
	}
}
}