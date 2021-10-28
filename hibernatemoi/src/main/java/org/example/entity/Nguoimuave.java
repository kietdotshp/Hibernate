package org.example.entity;

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

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "Nguoimuave")
public class Nguoimuave implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Nguoimuaveauto")
    @SequenceGenerator(name = "Nguoimuaveauto", sequenceName = "Nguoimuaveauto", allocationSize = 1,initialValue = 1)
    @Column(name = "NGUOIMUAVEID")
    private int id ; 
    @Column(name = "HOTEN") 
    private String hoTen;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "LOAINGUOIMUA")
    private String loaiNguoi;
    @OneToMany(mappedBy = "nguoimuave",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   private List<Hoadon> hoadons ;
//    
//    public List<Hoadon> getHoadons() {
//		return hoadons;
//	}
//	public void setHoadons(List<Hoadon> hoadons) {
//		this.hoadons = hoadons;
//	}
	final static String muaLe = "Mua lẻ";
    final static String muaTapthe = "Mua tập thể";
    final static String muaOnline = "Mua online";
   
    public Nguoimuave() {
		super();
	}
	public void inputdata(){
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Nhập họ tên người mua :");
        this.hoTen = sc.nextLine();
        System.out.println("Nhập địa chỉ :");
        this.diaChi = sc.nextLine();
        System.out.println("Nhập số điện thoại :");
        this.sdt = sc.nextLine();
        do {
            System.out.println("Nhập nhóm loại người :\n 1. mua lẻ,\n 2.  mua tập thể ,\n3. mua qua mạng");
            String chon = sc.nextLine();
            boolean check = false;
            switch (chon.charAt(0)) {
                case '1':
                    loaiNguoi = "mua lẻ";
                    check  = true ;
                    break;

                case '2' :

                    loaiNguoi = "mua tập thể";
                    check  = true ;
                    break;


                case '3' :
                    loaiNguoi = "mua qua mạng";
                    check  = true ;
                    break;

            }
            if (check ) {

                break;
            }

        } while (true);

    }
	
	public Nguoimuave inputdataDB(){
		Nguoimuave result=new Nguoimuave();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ tên người mua :");
        result.setHoTen(sc.nextLine());
        System.out.println("Nhập địa chỉ :");
        result.setDiaChi(sc.nextLine());
        System.out.println("Nhập số điện thoại :");
        result.setSdt(sc.nextLine());
        System.out.println("Nhập loại người mua : \n 1.Mua lẻ \n 2.Mua tập thể \n 3. Mua online");
        boolean check = true;
        int chon = Integer.parseInt(sc.nextLine());
        do {
        	try {
				check = true;
			} catch (Exception e) {
				System.err.println("Không nhập ký tự !!");
				check = false;
			}
        	if(chon <1 || chon >3) {
        		System.err.println("Nhập lại từ 1 -> 3");
        		check = false;
        	}
        	switch (chon) {
			case 1:
				result.setLoaiNguoi(Nguoimuave.muaLe);
				System.out.println("Mua lẻ");
				check = true;
				break;
			case 2:
				result.setLoaiNguoi(Nguoimuave.muaTapthe);
				System.out.println("Mua tập thể");
				check = true;
				break;
			case 3:
				result.setLoaiNguoi(Nguoimuave.muaOnline);
				System.out.println("Mua online");
				check = true;
				break;
				
			default:
				break;
				
			}
        	   return result;
        } while (!check);
     
    }
	
    @Override
    public String toString() {
        return "entity.Nguoimuave{" +
                "nguoimuaId=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", loaiNguoi='" + loaiNguoi + '\'' +
                '}';
    }
    
   	public String outPut() {
   		return "Nguoimuave [id=" + id + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", loaiNguoi="
   				+ loaiNguoi + "]";
   	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getLoaiNguoi() {
		return loaiNguoi;
	}
	public void setLoaiNguoi(String loaiNguoi) {
		this.loaiNguoi = loaiNguoi;
	}
    
}
