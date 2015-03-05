package lab.aikibo.test;

import java.util.List;

import lab.aikibo.entity.UploaderBpd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UploadEntTest {
	
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		List<UploaderBpd> data = (List<UploaderBpd>)session.createQuery("from UploaderBpd").list();
		System.out.println("Found " + data.size() + " Propinsi.");
		for(UploaderBpd dataRinci : (List<UploaderBpd>) data) {
		  System.out.println("NOP : " + dataRinci.getNop());
		  System.out.println("NAMA WP : " + dataRinci.getNamaWp());
		}
		
		
		session.close();
	}

}
