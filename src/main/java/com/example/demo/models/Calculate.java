package com.example.demo.models;

public class Calculate {
	
	int secret1;
	double secret2;
	
	public Calculate (int first, double second) {
		secret1 = first;
		secret2 = second;

	}
	
	public double addthings() {
		double result = secret1 + secret2;
		return result;
	}
	
	public double subtractthings() {
		double result = secret1 - secret2;
		return result; 
	}
	
	public double dividethings() {
		double result = secret1 / secret2;
		return result;
	}
	
	public double multiplythings() {
		double result = secret1 * secret2;
		return result;
	}
	
	public double modulothings() {
		double result = secret1 % secret2;
		return result;
	}
	
	public double expothings() {
		double result = Math.pow(secret1, secret2);
		return result;

	}
}



