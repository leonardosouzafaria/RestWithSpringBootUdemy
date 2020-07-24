package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {	
	
	SimpleMath simpleMath = new SimpleMath();
	
	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)  {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
		return sum;		
	}
	
	@RequestMapping(value="subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double subtration = simpleMath.subtration(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
		return subtration;		
	}
	
	@RequestMapping(value="multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double multiplication = simpleMath.multiplication(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
		return multiplication;		
	}
	
	@RequestMapping(value="division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double division = simpleMath.division(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
		return division;		
	}
	
	@RequestMapping(value="average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double average = simpleMath.average(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
		return average;		
	}
	
	@RequestMapping(value="squareRoot/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot (@PathVariable("numberOne") String numberOne) {
		
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double squareRoot = simpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
		
		return squareRoot;		
	}	

}
