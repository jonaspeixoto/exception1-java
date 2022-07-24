package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Resevation;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());		
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in resevation: CheckOut date must be after checkIn date");	
		}
		else {
			Resevation resevation = new Resevation(number, checkIn, checkOut);
			System.out.println("Resevation: " + resevation);
			System.out.print("Enter in the data to update the reservation ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());		
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
		
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in resevation: Reservation date must for updates must be futere dates");
			}
			else if(!checkOut.after(checkIn)){
				System.out.println("Error in resevation: CheckOut date must be after checkIn date");	
				
			}
			else {
				resevation.updateDates(checkIn, checkOut);
				System.out.println("Resevation: " + resevation);
			}
			
		}
		
		
		sc.close();
	}
}
