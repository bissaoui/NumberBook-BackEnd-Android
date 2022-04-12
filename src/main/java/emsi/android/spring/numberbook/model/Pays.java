package emsi.android.spring.numberbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pays")
public class Pays {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idP;
	private String prefix;
	private String flag;
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Pays(int idP, String prefix, String flag) {
		this.idP = idP;
		this.prefix = prefix;
		this.flag = flag;
	}
	public Pays(String prefix, String flag) {
		this.prefix = prefix;
		this.flag = flag;
	}
	public Pays() {
	}
	
	
	
	
}
