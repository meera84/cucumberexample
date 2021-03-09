/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xml.binding;

import com.mycompany.xml.binding.model.Customer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author cmlee
 */
public class Main {

	public static void main(String[] args) throws Exception {

		Customer customer = new Customer();
		customer.setCustomerId(12345);
		customer.setName("fred");
		customer.setEmail("fred@bedrock.com");
		customer.setAge(50);

		JAXBContext ctx = JAXBContext.newInstance(Customer.class);

		// marshall the object to xml. Write to fred.xml
		// the file should be in the project directory
		try (FileOutputStream fos = new FileOutputStream("fred.xml")) {
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.marshal(customer, bos);
			bos.flush();
			bos.close();
		}

		// unmarshall xml to object. Read from barney.xml
		try (FileInputStream fis = new FileInputStream("barney.xml")) {
			BufferedInputStream bis = new BufferedInputStream(fis);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			customer = (Customer)unmarshaller.unmarshal(bis);
		}

		System.out.println("barney: " + customer);
	}
	
}
