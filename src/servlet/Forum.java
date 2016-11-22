package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AbonneDAO;
import dao.MessageDAO;
import forum.Abonne;
import forum.Entreprise;
import forum.Message;
import util.HibernateUtil;

public class Forum extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5282794792369375536L;
	public static final String SESSION_ABONNE = "sessionAbonne";
	public static final String ACCES_RESTREINT = "/zoneAbonne/forum.jsp";
	public static final String DECO = "/deco";
	private static final String CHAMP_MSG = "send_message";
	private static final String CHAMP_OBJET_MSG = "objet_message";
	private MessageDAO messageDAO = new MessageDAO();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameterMap().containsKey("deco")) {
			response.sendRedirect(request.getContextPath() + DECO);
		} else {
			
				List<Message> listeMessages = messageDAO.getAllMessages();
				request.setAttribute("listeMessages", listeMessages);
			
			/* Transmission de la paire d'objets request/response à notre JSP */
			this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(x);
		if (request.getParameterMap().containsKey(CHAMP_MSG) && request.getParameter(CHAMP_MSG).length() != 0) {
			creerMessage(request);
		}
		
		
		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);

	}
	private void creerMessage(HttpServletRequest request){
		 /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        
		HibernateUtil.getSessionFactory()
        .getCurrentSession().beginTransaction();
		String message = request.getParameter(CHAMP_MSG);
		String objet_message = request.getParameter(CHAMP_OBJET_MSG);
		
		Message msg = new Message(objet_message,message);
		Abonne a = (Abonne) session.getAttribute( SESSION_ABONNE );
		msg.setAbonne(a);
		a.getListeMessages().add(msg);
		HibernateUtil.getSessionFactory()
        .getCurrentSession().update(a);
		HibernateUtil.getSessionFactory()
        .getCurrentSession().save(msg);
		
		HibernateUtil.getSessionFactory()
        .getCurrentSession().getTransaction().commit();
	}
}