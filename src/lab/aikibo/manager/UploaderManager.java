package lab.aikibo.manager;

import java.util.Date;
import java.util.List;

import lab.aikibo.entity.UploaderBpd;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zkplus.hibernate.HibernateUtil;

public class UploaderManager {
	
	public List<UploaderBpd> getDaftarByParam(String thnPajak, Date tglPerubahan, 
			String kodePencetak) {
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(UploaderBpd.class);
		criteria.add(Restrictions.eq("thnPajak", thnPajak));
		criteria.add(Restrictions.eq("tglTerbit", tglPerubahan));
		criteria.add(Restrictions.eq("nipPencetak", kodePencetak));
		List<UploaderBpd> data = (List<UploaderBpd>) criteria.list();
		if(data.isEmpty()) return null;
		session.flush();
		return data;
	}

}
