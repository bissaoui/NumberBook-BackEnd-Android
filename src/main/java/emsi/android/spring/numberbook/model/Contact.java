package emsi.android.spring.numberbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idC;
	private String nom;
	

	@Column(nullable = true)
	private String telephone;
	@Column(nullable = true)
	private String imei;
	
	private int pays;
	private String prefix;

	
	
	public int getPays() {
		return pays;
	}
	public void setPays(int pays) {
		this.pays = pays;
	}
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public Contact(int idC, String nom, String telephone, String imei,int pays,String prefix) {
		this.idC = idC;
		this.nom = nom;
		this.telephone = telephone;
		this.imei = imei;
		this.pays=pays;
	}
	public Contact(String nom, String telephone, String imei,int pays,String prefix) {
		this.nom = nom;
		this.telephone = telephone;
		this.imei = imei;
		this.pays=pays;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Contact() {
		
	}
	
	
	
}
