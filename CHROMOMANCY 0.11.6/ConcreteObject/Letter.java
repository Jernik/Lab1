package ConcreteObject;

/*
* This class stores the 26 font values for capital letters.
* Each method returns a 2 dimensional boolean array, where the trues
* correspond to darkened pixels in a character.
*/
public class Letter {

	private static boolean t = true;
	private static boolean f = false;

	public static boolean [] [] a() {
		boolean l [] [] = {
		{f,t,t,t,f},
		{t,f,f,f,t},
		{t,f,f,f,t},
		{t,f,f,f,t},
		{t,t,t,t,t},
		{t,f,f,f,t},
		{t,f,f,f,t},
		{t,f,f,f,t},
		{t,f,f,f,t},
		{t,f,f,f,t}}; 
		return l;
	}
	
	public static boolean [] [] b() {
		boolean l [] [] = {
		{t,t,t,f,f},
		{t,f,f,t,f},
		{t,f,f,t,f},
		{t,f,f,t,f},
		{t,t,t,f,f},
		{t,f,f,t,f},
		{t,f,f,f,t},
		{t,f,f,f,t},
		{t,f,f,t,f},
		{t,t,t,f,f}}; 
		return l;
	}
	
public static boolean [] [] c() {
	boolean l [] [] = {
			{f,f,t,t,f},
			{f,t,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{f,t,f,f,t},
			{f,f,t,t,f}}; 
	return l;
}
public static boolean [] [] d() {
	boolean l [] [] = {
			{t,t,t,t,f},
			{t,f,f,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,t,f},
			{t,t,t,f,f}}; 
	return l;
}
public static boolean [] [] e() {
	boolean l [] [] = {
			{t,t,t,t,t},
			{t,f,f,f,t},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,t,t,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,t,t,t,t}}; 
	return l;
}
public static boolean [] [] f() {
	boolean l [] [] = {
			{t,t,t,t,t},
			{t,f,f,f,t},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,t,t,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f}}; 
	return l;
}
public static boolean [] [] g() {
	boolean l [] [] = {
			{f,t,t,t,f},
			{t,f,f,t,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,t,t,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,t,t,f}}; 
	return l;
}
public static boolean [] [] h() { 
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,t,t,t,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t}}; 
	return l;
}
public static boolean [] [] i() {
	boolean l [] [] = {
			{t,t,t,t,t},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{t,t,t,t,t}}; 
	return l;
}
public static boolean [] [] j() { 
	boolean l [] [] = {
			{t,t,t,t,t},
			{f,f,f,f,t},
			{f,f,f,f,t},
			{f,f,f,f,t},
			{f,f,f,f,t},
			{f,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,t,t,f}}; 
	return l;
}
public static boolean [] [] k() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,t,f},
			{t,f,t,f,f},
			{t,t,f,f,f},
			{t,t,f,f,f},
			{t,t,f,f,f},
			{t,t,f,f,f},
			{t,f,t,f,f},
			{t,f,f,t,f},
			{t,f,f,f,t}}; 
	return l;
}
public static boolean [] [] l() {
	boolean l [] [] = {
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,t,t,t,t}}; 
	return l;
}
public static boolean [] [] m() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,t,f,t,t},
			{t,t,f,t,t},
			{t,f,t,f,t},
			{t,f,t,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t}}; 
	return l;
}
public static boolean [] [] n() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,t,f,f,t},
			{t,t,f,f,t},
			{t,f,t,f,t},
			{t,f,t,f,t},
			{t,f,f,t,t},
			{t,f,f,t,t},
			{t,f,f,f,t},
			{t,f,f,f,t}}; 
	return l;
}
public static boolean [] [] o() { 
	boolean l [] [] = {
			{f,t,t,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,t,t,f}}; 
	return l;
}
public static boolean [] [] p() {
	boolean l [] [] = {
			{t,t,t,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,t,t,t,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f},
			{t,f,f,f,f}}; 
	return l;
}
public static boolean [] [] q() {
	boolean l [] [] = {
			{f,t,t,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,t,f,t},
			{t,f,f,t,f},
			{f,t,t,f,t}}; 
	return l;
}
public static boolean [] [] r() {
	boolean l [] [] = {
			{t,t,t,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,t,t,t,f},
			{t,f,t,f,f},
			{t,f,f,t,f},
			{t,f,f,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t}}; 
	return l;
}
public static boolean [] [] s() {
	boolean l [] [] = {
			{f,t,t,f,f},
			{t,f,f,t,f},
			{t,f,f,f,t},
			{f,t,f,f,f},
			{f,f,t,f,f},
			{f,f,f,t,f},
			{f,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,t,t,f}}; 
	return l;
}
public static boolean [] [] t() {
	boolean l [] [] = {
			{t,t,t,t,t},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f}}; 
	return l;
}
public static boolean [] [] u() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,t,t,f}}; 
	return l;
}
public static boolean [] [] v() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,f,t,f},
			{f,t,f,t,f},
			{f,t,t,t,f},
			{f,t,t,t,f},
			{f,f,t,f,f},
			{f,f,t,f,f}}; 
	return l;
}
public static boolean [] [] w() { 
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,f,f,t},
			{t,f,t,f,t},
			{t,f,t,f,t},
			{t,f,t,f,t},
			{f,t,f,t,f}}; 
	return l;
}
public static boolean [] [] x() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,f,t,f},
			{f,t,f,t,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,t,f,t,f},
			{f,t,f,t,f},
			{t,f,f,f,t},
			{t,f,f,f,t}}; 
	return l;
}
public static boolean [] [] y() {
	boolean l [] [] = {
			{t,f,f,f,t},
			{t,f,f,f,t},
			{f,t,f,t,f},
			{f,t,f,t,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f},
			{f,f,t,f,f}}; 
	return l;
}
public static boolean [] [] z() {
	boolean l [] [] = {
		{t,t,t,t,t},
		{f,f,f,f,t},
		{f,f,f,t,f},
		{f,f,f,t,f},
		{f,f,t,f,f},
		{f,f,t,f,f},
		{f,t,f,f,f},
		{f,t,f,f,f},
		{t,f,f,f,f},
		{t,t,t,t,t}}; 
	return l; }
public static boolean [] [] comma() {
	boolean l [] [] = {
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,f,f,t,f},
		{f,f,t,f,f}}; 
	return l; }
public static boolean [] [] exclamation() {
	boolean l [] [] = {
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,f,f,f,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f}}; 
	return l; }
public static boolean [] [] period() {
	boolean l [] [] = {
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f}}; 
	return l; }
public static boolean [] [] apostraphe() {
	boolean l [] [] = {
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,f,f,t,f},
		{f,f,t,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f}}; 
	return l; }
public static boolean [] [] colon() {
	boolean l [] [] = {
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,f,f,f,f},
		{f,t,t,t,f},
		{f,t,t,t,f},
		{f,t,t,t,f}}; 
	return l; }
public static boolean [] [] question() {
	boolean l [] [] = {
		{f,f,t,f,f},
		{f,t,f,t,f},
		{t,f,f,f,t},
		{f,f,f,t,f},
		{f,f,t,f,f},
		{f,f,t,f,f},
		{f,f,t,f,f},
		{f,f,f,f,f},
		{f,f,t,f,f},
		{f,f,t,f,f}}; 
	return l; }

}