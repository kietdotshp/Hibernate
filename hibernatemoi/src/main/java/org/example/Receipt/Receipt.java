package org.example.Receipt;

import java.util.ArrayList;
import java.util.List;

import org.example.entity.Nguoimuave;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Receipt {
	Nguoimuave nguoimuave ;
	List<TicketTable> ticketTables = new ArrayList<>();
	int sum;
	float priceTotal;
	
	 public Receipt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Receipt(Nguoimuave nguoiMuaVe, List<TicketTable> ticketTables) {
	        this.nguoimuave = nguoiMuaVe;
	        this.ticketTables = ticketTables;
	    }
	public Nguoimuave getNguoimuave() {
		return nguoimuave;
	}
	public void setNguoimuave(Nguoimuave nguoimuave) {
		this.nguoimuave = nguoimuave;
	}
	public List<TicketTable> getTicketTables() {
		return ticketTables;
	}
	public void setTicketTables(List<TicketTable> ticketTables) {
		this.ticketTables = ticketTables;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public float getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}
	@Override
	public String toString() {
		return "Receipt [nguoimuave=" + nguoimuave + ", ticketTables=" + ticketTables + ", sum=" + sum + ", priceTotal="
				+ priceTotal + "]";
	}
}
