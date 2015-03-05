package lab.aikibo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;

public class UploaderBpd implements Serializable {

	private static final long serialVersionUID = -6749378601067657512L;
	
	private String kode;
	private String nop;
	private String thnPajak;
	private String namaWp;
	private BigDecimal pbb;
	private BigDecimal denda;
	private Date tglTerbit;
	private String nipPencetak;
	
	public String getKode() {
		return kode;
	}
	
	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
	}

	public String getThnPajak() {
		return thnPajak;
	}

	public void setThnPajak(String thnPajak) {
		this.thnPajak = thnPajak;
	}

	public String getNamaWp() {
		return namaWp;
	}

	public void setNamaWp(String namaWp) {
		this.namaWp = namaWp;
	}

	public BigDecimal getPbb() {
		return pbb;
	}

	public void setPbb(BigDecimal pbb) {
		this.pbb = pbb;
	}

	public BigDecimal getDenda() {
		return denda;
	}

	public void setDenda(BigDecimal denda) {
		this.denda = denda;
	}

	public Date getTglTerbit() {
		return tglTerbit;
	}

	public void setTglTerbit(Date tglTerbit) {
		this.tglTerbit = tglTerbit;
	}

	public String getNipPencetak() {
		return nipPencetak;
	}

	public void setNipPencetak(String nipPencetak) {
		this.nipPencetak = nipPencetak;
	}

}
