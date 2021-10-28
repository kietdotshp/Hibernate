package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.example.Receipt.Receipt;
import org.example.Receipt.TicketTable;
import org.example.entity.Hoadon;
import org.example.entity.Nguoimuave;
import org.example.entity.Vetau;
import org.example.service.Hoadonservices;
import org.example.service.Nguoimuaveservice;
import org.example.service.NguoimuaveserviceImpl;
import org.example.service.VetauserviceImpl;
import org.example.service.Vetauservices;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class App 
{
	private static final Object Hoadon = null;
	private static List<Vetau> listVt =  VetauserviceImpl.GetAllVe();
	private static List<Nguoimuave> listUser = NguoimuaveserviceImpl.GetAll();
	private static Hoadonservices hd  = new Hoadonservices();
	private static List<Receipt> receipts = new ArrayList<>();
	private static Nguoimuaveservice nguoimuaveservice=new NguoimuaveserviceImpl();
	private static  Vetauservices veTauservice = new VetauserviceImpl();
	private static Hoadonservices hoadonservice = new Hoadonservices();
	
	
    public static void main( String[] args )
    {
    	
    	 
    	  
    	    
//        try {
//            session.beginTransaction();
//            session.save(nguoimuave);
//            session.getTransaction().commit();
//        }catch (HibernateException e){
//            session.getTransaction().rollback();
//        }finally {
//            session.close();
//        }
        Scanner sc = new Scanner(System.in);
     do {
    	 System.out.println("**********************MENU**********************");
			System.out.println("1.Nhập danh sách người mua vé. In ra danh sách người mua đã có  \r\n"
					+ ".");
			System.out.println("2.Nhập danh sách loại vé.  In ra danh sách các loại vé đã có");
			System.out.println("3.Nhập danh sách hóa đơn mua vé cho mỗi người mua; (giả sử mỗi người mua có thể mua một hoặc nhiều loại vé nhưng không quá 4 loại, mỗi loại có một số lượng xác định nhưng không quá 20) và in danh sách ra màn hình. ");
			System.out.println("4.Sắp xếp danh sách hóa đơn         \r\n"
					+ "a.Theo Họ tên người mua   \r\n"
					+ "\r\n"
					+ ""
					+ "");
			System.out.println("5.Theo Số lượng vé mua (giảm dần)");
			System.out.println("6.Lập bảng kê số tiền phải tra cho mỗi người mua    ");
			System.out.println("7. Thoát");
			System.out.println("8.Sự lựa chọn của bạn");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: {
				System.out.println("Nhập số lượng người mua vé");
				int soLuongNguoiMuaVe = Integer.parseInt(sc.nextLine());
				for(int i=0;i<soLuongNguoiMuaVe ;i++) {
					Nguoimuave nguoiMuaVe=new Nguoimuave();
					nguoiMuaVe=nguoiMuaVe.inputdataDB();
					nguoimuaveservice.create(nguoiMuaVe);
					System.out.println("Thêm mới người mua vé thành công!");
				}
				
				System.out.println("Danh sách người mua vé trên server là:");
				List<Nguoimuave> list = nguoimuaveservice.findAll(new Nguoimuave());
				for (Nguoimuave nguoimuave : list) {
					System.out.println("-> "+nguoimuave.outPut());
				}
				break;
			}
			case 2:{
				System.out.println("nhập số vé tàu :");
				int soLuongVeTau = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soLuongVeTau; i++) {
					Vetau veTau = new Vetau();
					veTau = veTau.intpdataVeTau();
					veTauservice.CreateVetau(veTau);
					System.out.println("Thêm mới thành công!!");
				}
				List<Vetau> listVetau = veTauservice.findAll(new Vetau());
				for (Vetau vetau : listVetau) {
					 System.out.println("->"+vetau.outPutVetau());
				}
				break;
			}
			case 3:{
				createHD();
			
				break;
			}
			case 4:{

				sortName();
				
				break;
			}
			case 5:{
				sortSL();
				break;
			}
			case 6:{
				
				break;
			}
			case 7:{
				System.exit(0);
			}
			
			default:
				System.out.println("Vui lòng chọn từ 1-8");
				break;
			}
	} while (true);
     
    }

	   public static void createHD(){
		  Scanner sc = new Scanner(System.in);
		  List<Hoadon> hoadon1 = new ArrayList<Hoadon>();
		  boolean check  = true ; 
		  
		 
		  System.out.println("nhập số lượng mua vé:");
		  int slHoadon =  Integer.parseInt(sc.nextLine());
		  for (int i = 0; i < slHoadon; i++) {
			 
			  do {
				  try {
					  System.out.println("Nhập mã người mua: ");
					  check  = true ; 
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Nhập bằng số");
					check  = false;
					
				}  
			} while (!check);  
			  int nguoimuaId = Integer.parseInt(sc.nextLine());
			  Nguoimuave nguoimuave = nguoimuaveservice.findbyId(nguoimuaId) ;
			  
			  
			  System.out.println("Nhập vé id tàu:");
			  int veid = 0;
			  veid = Integer.parseInt(sc.nextLine());
			  List<Vetau> listVetaus  = new ArrayList<Vetau>();
			  Vetau vetau  = veTauservice.findbyIdVe(veid);
			 

			  System.out.println("Nhập số lượng vé tàu:");	 
			  int soLuong1 = 0;
			  int gia = 0;
			  do {
				  
				  soLuong1 = Integer.parseInt(sc.nextLine());
				  
					if (soLuong1>20) 
						System.err.println("NHập lại. nhỏ hơn 20");
						check = false;
						
			} while (!check);
			
			 
			  listVetaus.add(vetau);
			 
			  
			  Hoadon hoadon = new Hoadon();
			  hoadon.setNguoimuave(nguoimuave);
			  hoadon.setVetau(vetau);
			  hoadon.setSoLuong(Integer.parseInt(String.valueOf(soLuong1)));
			  hoadon1.add(hoadon);

		}
		  System.out.println(hoadon1.toString());
		  Hoadonservices.addHoadon(hoadon1);
		  
			System.out.println("Danh sách Hóa đơn  trên server là:");
			List<Hoadon> listHdon = hoadonservice.findAllHD(new Hoadon());
			for (Hoadon hoadon : listHdon) {
				System.out.println("-> "+hoadon.outPutHD());
			}

		   
	}
		   
	   public static void sortName() {
		   
		   
		   
		   List<Hoadon> hoadonsort ;
		   hoadonsort = hoadonservice.findAllHD(new Hoadon());
		   Collections.sort(hoadonsort,new Comparator<Hoadon>() {

			@Override
			public int compare(org.example.entity.Hoadon o1, org.example.entity.Hoadon o2) {
				// TODO Auto-generated method stub
				
				return o1.getNguoimuave().getHoTen().compareTo(o2.getNguoimuave().getHoTen());
			}
			   
		});
		   
		   
//		   List<Hoadon> sort = Hoadonservices.sortName();
//		   System.out.println("Sắp xếp :");
//		   for (Hoadon hoadon : sort) {
//			System.out.println(hoadon.outPutHD());
//		}
////		   for (int i=0; i < receipts.size(); i++){
////	            for (int j= i+1; j < receipts.size() ; j++){
////	                if (receipts.get(i).getNguoimuave().getHoTen().compareTo(receipts.get(j).getNguoimuave().getHoTen())>0){
////	                    Receipt receipt = receipts.get(i);
////	                    receipts.set(i, receipts.get(j));
////	                    receipts.set(j, receipt);
////	                }
////	            }
////	        }
////	        for (Receipt receipt : receipts){
////	            System.out.println(receipt);
////	        }
////		   List<Hoadon> listHdon = new ArrayList<>(Arrays.asList(
////				   
////				   ));
////		   
////		   List<Hoadon> sortedList = listHdon.stream()
////		           .sorted(Collections.reverseOrder())
////		           .collect(Collectors.toList());
////
////		   System.out.println(sortedList);
		   for (Hoadon hoadon : hoadonsort) {
				System.out.println("-> "+hoadon.outPutHD());
			}
////		
	    }

	   public static void sortSL() {
		   
		   
		   
		   List<Hoadon> hoadonsort ;
		   hoadonsort = hoadonservice.findAllHD(new Hoadon());
		   Collections.sort(hoadonsort,new Comparator<Hoadon>() {

			@Override
			public int compare(org.example.entity.Hoadon o1, org.example.entity.Hoadon o2) {
				// TODO Auto-generated method stub
				
				return o2.getSoLuong() - o1.getSoLuong();
			}
			   
		});
		   for (Hoadon hoadon : hoadonsort) {
				System.out.println("-> "+hoadon.outPutHD());
			}
	   }
}
