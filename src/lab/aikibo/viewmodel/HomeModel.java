package lab.aikibo.viewmodel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lab.aikibo.entity.UploaderBpd;
import lab.aikibo.manager.UploaderManager;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Filedownload;

public class HomeModel implements Serializable {

	private static final long serialVersionUID = 8970276236513015529L;
	private String thnPajak;
	private Date tglPerubahan;
	private String kodePencetak;
	private UploaderManager um;
	
	@GlobalCommand
	public void redirectToNewForm() {
		Executions.sendRedirect("/login.zul");
	}
	
	@Init
	public void init() {
		um = new UploaderManager();
		clear();
	}
	
	private void clear() {
		thnPajak = new String();
		tglPerubahan = Calendar.getInstance().getTime();
		kodePencetak = new String();
	}
	
	@Command
	public void unduhFile() throws IOException {
		FileWriter fw = new FileWriter("./update.txt");
		PrintWriter pw = new PrintWriter(fw);
		List<UploaderBpd> data = um.getDaftarByParam(thnPajak, tglPerubahan, kodePencetak);
		for(int i=0; i<data.size(); i++) {
			pw.print(data.get(i).getKode() + "|");
			pw.print(data.get(i).getNop() + "|");
			pw.print(data.get(i).getThnPajak() + "|");
			pw.print(data.get(i).getNamaWp() + "|");
			pw.print(data.get(i).getPbb() + "|");
			pw.print(data.get(i).getDenda() + "\r\n");
		}
		pw.close();
		fw.close();
		
		File f = new File("./update.txt");
		byte[] buffer = new byte[(int) f.length()];
		FileInputStream fs = new FileInputStream(f);
		fs.read(buffer);
		fs.close();
		ByteArrayInputStream is = new ByteArrayInputStream(buffer);
		AMedia amedia = new AMedia("update.txt", "txt", "txt", is);
		Filedownload.save(amedia);
	}
	
	
	// -- setter and getter

	public String getThnPajak() {
		return thnPajak;
	}

	public void setThnPajak(String thnPajak) {
		this.thnPajak = thnPajak;
	}

	public Date getTglPerubahan() {
		return tglPerubahan;
	}

	public void setTglPerubahan(Date tglPerubahan) {
		this.tglPerubahan = tglPerubahan;
	}

	public String getKodePencetak() {
		return kodePencetak;
	}

	public void setKodePencetak(String kodePencetak) {
		this.kodePencetak = kodePencetak;
	}

}