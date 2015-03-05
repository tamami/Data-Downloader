package lab.aikibo.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lab.aikibo.entity.UploaderBpd;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zkplus.hibernate.HibernateUtil;

public class UploadFilterTest {
	
	public List<UploaderBpd> getData(String thnPajak, Date tglPerubahan, String kodePencetak) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UploaderBpd.class);
		criteria.add(Restrictions.eq("thnPajak", thnPajak));
		criteria.add(Restrictions.eq("tglTerbit", tglPerubahan));
		criteria.add(Restrictions.eq("nipPencetak", kodePencetak));
		List<UploaderBpd> data = (List<UploaderBpd>) criteria.list();
		if(data.isEmpty()) return null;
		session.close();
		return data;
	}
	
	public static void main(String args[]) {
		UploadFilterTest app = new UploadFilterTest();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 2);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.YEAR, 2015);
		List<UploaderBpd> data = app.getData("2015", cal.getTime(), "060000002");
		System.out.println("NOP : " + data.get(0).getNop());
		System.out.println("NOP : " + data.get(1).getNop());
		System.out.print(data.get(0).getKode() + "|");
		System.out.print(data.get(0).getNop() + "|");
		System.out.print(data.get(0).getThnPajak() + "|");
		System.out.print(data.get(0).getNamaWp() + "|");
		System.out.print(data.get(0).getPbb() + "|");
		System.out.println(data.get(0).getDenda());
	}

}
