package tasks;
public class Tasks1{
	public static void main(String[] args){
		
		double[] literInputs = {5,3,8};
		System.out.println("EX 1:");
		for (int i = 0; i < literInputs.length; i++) {
			double liters = literInputs[i];
			double result = convert(liters);
			System.out.println(
					"Liters:"+String.valueOf(liters)+
					"; Result:"+String.valueOf(result));
		}
		int[] minuteInputs = {15,24,41};
		int[] intensityInputs = {1,2,3};
		System.out.println("EX 2:");
		for (int i = 0; i < minuteInputs.length; i++) {
			int minutes = minuteInputs[i];
			int intensity = intensityInputs[i];
			int result = fitCalc(minutes,intensity);
			System.out.println(
					"Mins:"+String.valueOf(minutes)+
					"; Intensity:"+String.valueOf(intensity)+
					"; Result:"+String.valueOf(result));
		}
		
		System.out.println("EX 3:");
		int[] crateInputs = {3,5,4};
		int[] sackInputs = {4,0,1};
		int[] barrelInputs = {2,2,4};
		for (int i = 0; i < crateInputs.length; i++) {
			int crates = crateInputs[i];
			int sacks = sackInputs[i];
			int barrels = barrelInputs[i];
			int result = containers(crates,sacks,barrels);
			System.out.println(
					"Crates"+String.valueOf(crates)+
					"; Sacks:"+String.valueOf(sacks)+
					"; Barrels:"+String.valueOf(barrels)+
					"; Result:"+String.valueOf(result));
		}
		
		System.out.println("EX 4:");

		int[] sideAInputs = {5,5,3,5};
		int[] sideBInputs = {5,4,4,1};
		int[] sideCInputs = {5,5,5,1};
		for (int i = 0; i < sideAInputs.length; i++) {
			int sideA = sideAInputs[i];
			int sideB = sideBInputs[i];
			int sideC = sideCInputs[i];
			TriangleTypes result = triangleType(sideA,sideB,sideC);
			System.out.println(
					"SideA:"+String.valueOf(sideA)+
					"; SideB:"+String.valueOf(sideB)+
					"; SideC:"+String.valueOf(sideC)+
					"; Result:"+result.name());
		}
		
		System.out.println("EX 5:");
		int[] aInputs = {8,1,5};
		int[] bInputs = {4,11,9};
		for (int i = 0; i < aInputs.length; i++) {
			int A = aInputs[i];
			int B = bInputs[i];
			int result = ternaryMax(A,B);
			System.out.println(
					"A:"+String.valueOf(A)+
					"; B:"+String.valueOf(B)+
					"; Result:"+String.valueOf(result));
		}

		System.out.println("EX 6:");
		double[] nInput = {22.0,45.0,100.0};
		double[] wInput = {1.4,1.8,2.0};
		double[] hInput = {2.0,1.9,2.0};
		for (int i = 0; i < nInput.length; i++) {
			double n = nInput[i];
			double w = wInput[i];
			double h = hInput[i];
			int result = howManyItems(n,w,h);
			System.out.println(
					"Total Roll Length:"+String.valueOf(n)+
					"m; Width:"+String.valueOf(w)+
					"m; Height:"+String.valueOf(h)+
					"m; Result:"+String.valueOf(result));
		}
		System.out.println("EX 7:");
		
		int[] nInputs = {3,5,7};
		for (int i = 0; i < nInputs.length; i++) {
			int n = nInputs[i];
			int result = factorial(n);
			System.out.println(
					"n:"+String.valueOf(n)+
					"; Result:"+String.valueOf(result));
		}

		System.out.println("EX 8:");
		int[] a2Inputs = {48,52,259};
		int[] b2Inputs = {18,8,28};
		for (int i = 0; i < a2Inputs.length; i++) {
			int A = a2Inputs[i];
			int B = b2Inputs[i];
			int result = gcd(A,B);
			System.out.println(
					"A:"+String.valueOf(A)+
					"; B:"+String.valueOf(B)+
					"; Result:"+String.valueOf(result));
		}
		System.out.println("EX 9:");
		int[] salesInput = {70,24,53};
		int[] priceInput = {1500,950,1250};
		for (int i = 0; i < salesInput.length; i++) {
			int sales = salesInput[i];
			int price = priceInput[i];
			double fee = 0.28;
			int result = ticketSeller(sales,price,fee);
			System.out.println(
					"Sales:"+String.valueOf(sales)+
					"; Price:"+String.valueOf(price)+
					"; Fee:"+String.valueOf(fee)+
					"; Profit:"+String.valueOf(result));
		}
		System.out.println("EX 10:");
		int[] studentsInput = {5,31,123};
		int[] tablesInput = {2,20,58};
		for (int i = 0; i < studentsInput.length; i++) {
			int students = studentsInput[i];
			int tables = tablesInput[i];
			int result = tableManager(students,tables);
			System.out.println(
					"Students:"+String.valueOf(students)+
					"; Tables:"+String.valueOf(tables)+
					"; Missing Tables:"+String.valueOf(result));
		}
	}
	
	public static double convert(double gallons) {
		return gallons * 3.78541;
	}
	
	public static int fitCalc(int minutes, int intensity) {
		return minutes * intensity;
	}
	
	public static int containers(int crates, int sacks, int barrels) {
		return crates * 20 + sacks * 50 + barrels * 100;
	}
	public enum TriangleTypes {
		ISOSCELES,
		EQUILATERAL,
		NON_SPECIFIC,
		COLLAPSED,
		IMPOSTER
	}
	public static TriangleTypes triangleType(int sideA, int sideB, int sideC) {
		double longestSide = Math.max(sideA,Math.max(sideB, sideC));
		double perimeter = sideA+sideB+sideC;
		if(sideA == sideB && sideB == sideC) {
			return TriangleTypes.ISOSCELES;
		}else if (sideA == sideB || sideB == sideC || sideC == sideA) {
			return TriangleTypes.EQUILATERAL;	
		}else if (longestSide == perimeter/2.0) {
			return TriangleTypes.COLLAPSED;
		} else if (longestSide > perimeter/2.0) {
			return TriangleTypes.IMPOSTER;
		}
		return TriangleTypes.NON_SPECIFIC;	
	}
	public static int ternaryMax(int a, int b) {
		return (a>b) ? a : b;
	}
	public static int howManyItems(double n, double w, double h) {		
		return (int) Math.floor((n*2.0)/(w*h));
	}	
	public static int factorial(int n) {
		int r = 1;
		for (int i = 2; i <= n; i++) {
			r*=i;
		}
		return r;
	}
	public static int gcd(int a, int b) {
		int u = (int) Math.max(a, b);
		int v = (int) Math.min(a, b);
		int rem = u % v;
		while (rem>0) {
			u = v;
			v = rem;
			rem = u % v;
		}
		return v;
	}
	public static int ticketSeller(int sales, int price, double fee) {
		return (int) (price * (1.0-fee)*sales);
	}
	public static int tableManager(int students, int tables) {
		int unsat = students-tables*2;
		int req = unsat/2 + unsat % 2;
		return Math.max(req,0);
	}
}