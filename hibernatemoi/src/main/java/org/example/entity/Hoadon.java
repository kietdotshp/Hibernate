package org.example.entity;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "Hoadon")
public class Hoadon implements Serializable{
	@Column(name = "SOLUONG")
	private int soLuong;
	@Id
	@Column(name = "ID")
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Hoadon_sq")
    @SequenceGenerator(name = "Hoadon_sq", sequenceName = "Hoadon_sq", allocationSize = 1,initialValue = 1)
	private int id;
	
	@ManyToOne//(targetEntity = Nguoimuave.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "NGUOIMUAVEID")
	private Nguoimuave nguoimuave;
	
	@ManyToOne//(targetEntity =Vetau.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "VEID")
	private Vetau vetau;
	
	public Hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hoadon(int soLuong, int id, Nguoimuave nguoimuave, Vetau vetau) {
		super();
		this.soLuong = soLuong;
		this.id = id;
		this.nguoimuave = nguoimuave;
		this.vetau = vetau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Nguoimuave getNguoimuave() {
		return nguoimuave;
	}
	public void setNguoimuave(Nguoimuave nguoimuave) {
		this.nguoimuave = nguoimuave;
	}
	public Vetau getVetau() {
		return vetau;
	}
	public void setVetau(Vetau vetau) {
		this.vetau = vetau;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String outPutHD() {
		return "Hoadon [soLuong=" + soLuong + ", id=" + id + ", nguoimuave=" + nguoimuave + ", vetau=" + vetau + "]";
	}
	@Override
	public String toString() {
		return "Hoadon [soLuong=" + soLuong + ", id=" + id + ", nguoimuave=" + nguoimuave + ", vetau=" + vetau + "]";
	}
}
