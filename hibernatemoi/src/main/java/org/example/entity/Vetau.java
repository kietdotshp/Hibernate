package org.example.entity;

import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Vetau")
public class Vetau {
	@Id
	@Column(name = "VEID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_VE")
	@SequenceGenerator(name = "SEQUENCE_VE", sequenceName = "SEQUENCE_VE", allocationSize = 1, initialValue = 1)
	private int veId;
	@Column(name = "LOAIGHE")
	private String  loaiGhe;
	@Column(name = "DONGIA")
	private double donGia;
	@OneToMany(mappedBy = "vetau",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Hoadon> hoadons;

//	public List<Hoadon> getHoadons() {
//		return hoadons;
//	}
//	public void setHoadons(List<Hoadon> hoadons) {
//		this.hoadons = hoadons;
//	}
	public Vetau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vetau(int veId, String loaiGhe, double donGia) {
		super();
		this.veId = veId;
		this.loaiGhe = loaiGhe;
		this.donGia = donGia;
	}
	public int getVeId() {
		return veId;
	}
	public void setVeId(int veId) {
		this.veId = veId;
	}
	public String getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(String loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public Vetau  intpdataVeTau() {
		Vetau resulVeTau = new Vetau();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập loại ghế :");
		resulVeTau.loaiGhe = sc.nextLine();
		System.out.println("Nhập đơn giá :");
		resulVeTau.donGia = Double.parseDouble(sc.nextLine());
		return resulVeTau;
	}
	public String outPutVetau() {
   		return "Vetau [veId=" + veId + ", loaiGhe=" + loaiGhe + ", donGia=" + donGia + "]";
   	}
	@Override
	public String toString() {
		return "Vetau [veId=" + veId + ", loaiGhe=" + loaiGhe + ", donGia=" + donGia + "]";
	}
}
