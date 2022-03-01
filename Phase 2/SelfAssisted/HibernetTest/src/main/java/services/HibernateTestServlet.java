package services;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.ProductDetails;


/**
 * Servlet implementation class HibernateTestServlet
 */
@WebServlet("/HibernateTestServlet")
public class HibernateTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HibernateTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    void register(ProductDetails pd){
		
		SessionFactory sessionFactory=new Configuration().configure(new File("C:\\Users\\admin\\eclipse-workspace\\HibernateAddProduct\\src\\main\\java\\hibernate.cfg.xml")).buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(pd);
		
		session.getTransaction().commit();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Reading parameters from html
		int pid=Integer.parseInt(request.getParameter("txtPid"));
		String pname=request.getParameter("txtName");
				
		//create Object of UserDetails
		ProductDetails pd=new ProductDetails();
		pd.setProductid(pid);
		pd.setProductname(pname);
		
		//call register method
		register(pd);
	}

}

