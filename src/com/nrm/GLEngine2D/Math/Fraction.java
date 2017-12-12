package com.nrm.GLEngine2D.Math;

public class Fraction {

	public int numerator;
	public int denominator;

	public double dValue() {
		double dValue = (double) numerator / denominator;
		return dValue;
	}

	public long gcm(long a, long b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	public String toString() {
		long gcm = gcm(numerator, denominator);
		return (numerator / gcm) + "/" + (denominator / gcm);
	}
}
