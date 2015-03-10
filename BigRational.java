import java.math.BigInteger;

/**
 * This class implements arbitrary precision rational numbers (i.e., fractions).
 * 
 * @author Lucas Miller
 */
public class BigRational implements Comparable<BigRational>,
		ArithmeticObject<BigRational> {

	/**
	 * The numerator of the rational
	 */
	private BigInteger numerator;

	/**
	 * The denominator of the rational (cannot be 0)
	 */
	private BigInteger denominator;
	/**
	 * Whether or not the rational is negative
	 */
	private boolean neg = false;

	/**
	 * Constructs an arbitrary precision rational number with the given
	 * numerator and denominator.
	 * 
	 * @param numerator
	 * @param denominator
	 * @throws ArithmeticException 
	 */
	public BigRational(String numerator, String denominator) throws ArithmeticException{
		setNumerator(new BigInteger(numerator));
		setDenominator(new BigInteger(denominator));
		checkneg();
		reduce();
	}

	/**
	 * Constructs an arbitrary precision rational number with the given
	 * numerator and denominator.
	 * 
	 * @param numerator
	 * @param denominator
	 * @throws ArithmeticException 
	 */
	public BigRational(BigInteger numerator, BigInteger denominator) throws ArithmeticException{
		setNumerator(numerator);
		setDenominator(denominator);
		checkneg();
		reduce();
	}

	/**
	 * Setter method for numerator
	 * 
	 * @param bi
	 *            The numerator
	 */
	private void setNumerator(BigInteger bi) {
		this.numerator = bi;

	}

	/**
	 * Setter method for denominator
	 * 
	 * @param bi
	 *            The denominator
	 */
	private void setDenominator(BigInteger bi) throws ArithmeticException {
		if (bi.equals(new BigInteger("0"))) {
			throw new ArithmeticException("Divide by zero!");
		}
		this.denominator = bi;
	}

	/**
	 * This method checks whether the BigRational is negative or not, and stores
	 * that value as a boolean in neg.
	 * 
	 */
	private void checkneg() {
		boolean numneg = false;
		boolean denneg = false;
		if (getNumerator().abs().compareTo(getNumerator()) != 0) {
			numneg = true;
		}
		if (getDenominator().abs().compareTo(getDenominator()) != 0) {
			denneg = true;
		}
		if (numneg != denneg) {// != has same truth table as XOR
			this.neg = true;
		}
	}

	/**
	 * 
	 * getter method for numerator
	 * 
	 * @return the numerator
	 */
	private BigInteger getNumerator() {
		return this.numerator;
	}

	/**
	 * 
	 * getter method for denominator
	 * 
	 * @return the denominator
	 */
	private BigInteger getDenominator() {
		return this.denominator;
	}

	/**
	 * 
	 * A getter for neg
	 * 
	 * @return
	 */
	private boolean getNeg() {
		return this.neg;
	}

	/**
	 * 
	 * Reduces the numerator and denominator by finding the gcd then diving them
	 * both by it
	 * 
	 */
	private void reduce() {
		BigInteger gcd = this.numerator.gcd(this.denominator);
		this.numerator = this.numerator.divide(gcd);
		this.denominator = this.denominator.divide(gcd);
	}

	/**
	 * Returns a String that represents this BigRational, as follows: If the
	 * BigRational is a whole number, the String is just that whole number.
	 * Otherwise, the String is "numerator/denominator" with the BigRational's
	 * numerator and denominator, in lowest terms. No spaces. If the BigRational
	 * is negative, the minus sign is displayed with the numerator (not the
	 * denominator).
	 */
	@Override
	public String toString() {
		String out = "";
		if (getNeg()&&getNumerator().compareTo(new BigInteger("0"))!=0) {
			out = out + "-";
		}
		if (getDenominator().equals(new BigInteger("1"))
				|| getDenominator().equals(new BigInteger("-1"))) {
			out = out + getNumerator().abs().toString();
		} else {
			out = out + getNumerator().abs().toString() + "/"
					+ getDenominator().abs().toString();
		}

		return out;
	}

	/**
	 * Returns true if the given object is a BigRational that equals this
	 * BigRational.
	 */
	@Override
	public boolean equals(Object object) {
		// equals is typically written with the following few lines of
		// code at the beginning of it.
		if (object == null || this.getClass() != object.getClass()) {
			return false;
		}
		BigRational other = (BigRational) object;
		if (other.getNumerator().abs().equals(getNumerator().abs())) {
			if (other.getDenominator().abs().equals(getDenominator().abs())) {
				if (other.getNeg() == getNeg()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public BigRational abs() {
		return new BigRational(getNumerator().abs(), getDenominator().abs());
	}

	@Override
	public BigRational negate() {
		if (getNeg()) {
			return new BigRational(getNumerator().abs(), getDenominator().abs());
		}
		return new BigRational(getNumerator().abs().negate(), getDenominator()
				.abs());

	}

	@Override
	public BigRational add(BigRational other) {
		BigInteger newnum = getNumerator().multiply(other.getDenominator());
		BigInteger newden = getDenominator().multiply(other.getDenominator());

		BigInteger newnum2 = getDenominator().multiply(other.getNumerator());
		return new BigRational(newnum.add(newnum2), newden);

	}

	@Override
	public BigRational subtract(BigRational other) {
		BigInteger newnum = getNumerator().multiply(other.getDenominator());
		BigInteger newden = getDenominator().multiply(other.getDenominator());

		BigInteger newnum2 = getDenominator().multiply(other.getNumerator());
		return new BigRational(newnum.subtract(newnum2), newden);
	}

	@Override
	public BigRational divide(BigRational other){
		BigRational br=null;
		try {
		br=new BigRational(this.numerator.multiply(other.denominator),
				this.denominator.multiply(other.numerator));
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage()+" - Unable to divide, divide by zero error");
		}
		return br;
	}

	@Override
	public BigRational multiply(BigRational other) {
		return new BigRational(getNumerator().multiply(other.getNumerator()),
				getDenominator().multiply(other.getDenominator()));
	}

	/**
	 * puts the numerators over a common denominator and then compares these
	 * using BigInteger's compareTo
	 * 
	 * @param o
	 *            the BigRational to compare to.
	 */
	@Override
	public int compareTo(BigRational o) {
		BigInteger num = getNumerator().abs()
				.multiply(o.getDenominator().abs());
		if (this.getNeg())
			num = num.negate();
		BigInteger num2 = o.getNumerator().abs()
				.multiply(getDenominator().abs());
		if (o.getNeg())
			num2 = num2.negate();
		return num.compareTo(num2);

	}

}
