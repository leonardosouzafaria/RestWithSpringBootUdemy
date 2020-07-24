package br.com.erudio.math;

public class SimpleMath {
	
	public Double sum(Double firstNumber, Double secondNuber) {
		return firstNumber + secondNuber;
	}
	
	public Double subtration(Double firstNumber, Double secondNuber) {
		return firstNumber - secondNuber;
	}
		
	public Double multiplication(Double firstNumber, Double secondNuber) {
		return firstNumber * secondNuber;
	}
	
	public Double division(Double firstNumber, Double secondNuber) {
		return firstNumber / secondNuber;
	}
	
	public Double average(Double firstNumber, Double secondNuber) {
		return (firstNumber + secondNuber) / 2;
	}
	
	public Double squareRoot(Double number) {
		return Math.sqrt(number);
	}
	

}
