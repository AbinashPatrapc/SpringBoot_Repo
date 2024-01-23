package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IpurchaseOrder;
import com.nt.service.purchaseOrderServiceImpl;

@SpringBootApplication
public class BootMvcProj15SpringBootMailApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootMvcProj15SpringBootMailApplication.class, args);
		IpurchaseOrder order = ctx.getBean("purchaseService", purchaseOrderServiceImpl.class);

		try {
			String msg = order.purchase(new String[] { "Mehfil", "Shah GHouse", "Paradise" },
					new double[] { 130, 280, 250 }, new String[] { "abinashpatra118@gmail.com",
							"helenamohapatra1999@gmail.com", "sachinroutray22@gmail.com" });
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
