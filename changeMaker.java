public class changeMaker{

	public static void main(String[] args){
		
		double charge;

		do{
			System.out.println("What is the total sales charge?");
			charge = IO.readDouble();
			if(charge<0)
			System.out.println("Must Enter Positive number!");
		}while(charge<0);
		
		double giving;
		do{
			System.out.println("How much is the customer giving?");
			giving = IO.readDouble();
			if(giving<0)
				System.out.println("Must give positive number");
			if(giving<charge)
				System.out.println("Not enough money");
		}while(giving<0||giving<charge);

		if(giving==charge){
			System.out.println("No change needed");
			return;
		}

		System.out.println("Change is:");

		int change = (int) ((giving - charge)*100);

		int twenties = change/2000;
		if(twenties>0){
			change = change%2000;
			System.out.println(twenties + " $20 bill(s)");
		}

		int tens = change/1000;
		if(tens>0){
			change = change%1000;
			System.out.println(tens + " $10 bill(s)");
		}

		int fives = change/500;
		if(fives>0){
			change = change%500;
			System.out.println(fives + " $5 bill(s)");
		}

		int ones = change/100;
		if(ones>0){
			change = change%100;
			System.out.println(ones + " $1 bill(s)");
		}

		int quarters = change/25;
		if(quarters>0){
			change = change%25;
			System.out.println(quarters + " quarter(s)");
		}

		int dimes = change/10;
		if(dimes>0){
			change = change%10;
			System.out.println(dimes + " dime(s)");
		}

		int nickels = change/5;
		if(nickels>0){
			change = change%5;
			System.out.println(nickels + " nickel(s)");
		}

		int pennies = (int) change;
		if(pennies>0){
			System.out.println(pennies + " pennies");
		}

	}
}