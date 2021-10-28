package org.example.Receipt;

import org.example.entity.Vetau;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level =AccessLevel.PRIVATE)
public class TicketTable {
	  Vetau veTau;
	   int ticketNum;
	public TicketTable(Vetau veTau, int ticketNum) {
		super();
		this.veTau = veTau;
		this.ticketNum = ticketNum;
	}
	   
}
