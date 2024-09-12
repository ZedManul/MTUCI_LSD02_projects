package Tasks;
public class Tasks1Randomized{
	public static void main(String[] args){
		final int TRIES_PER_TASK = 6;
		System.out.println("EX 1:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			double liters = genRandomInt(0,10);
			double result = convert(liters);
			System.out.println(
					"Liters:"+String.valueOf(liters)+
					"; Result:"+String.valueOf(result));
		}

		System.out.println("EX 2:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int minutes = genRandomInt(1,10);
			int intensity = genRandomInt(1,3);
			int result = fitCalc(minutes,intensity);
			System.out.println(
					"Mins:"+String.valueOf(minutes)+
					"; Intensity:"+String.valueOf(intensity)+
					"; Result:"+String.valueOf(result));
		}
		
		System.out.println("EX 3:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int crates = genRandomInt(1,10);
			int sacks = genRandomInt(1,10);
			int barrels = genRandomInt(1,10);
			int result = containers(crates,sacks,barrels);
			System.out.println(
					"Crates"+String.valueOf(crates)+
					"; Sacks:"+String.valueOf(sacks)+
					"; Barrels:"+String.valueOf(barrels)+
					"; Result:"+String.valueOf(result));
		}
		
		System.out.println("EX 4:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int sideA = genRandomInt(1,10);
			int sideB = genRandomInt(1,10);
			int sideC = genRandomInt(1,10);
			TriangleTypes result = triangleType(sideA,sideB,sideC);
			System.out.println(
					"SideA:"+String.valueOf(sideA)+
					"; SideB:"+String.valueOf(sideB)+
					"; SideC:"+String.valueOf(sideC)+
					"; Result:"+result.name());
		}
		
		System.out.println("EX 5:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int A = genRandomInt(-100,100);
			int B = genRandomInt(-100,100);
			int result = ternaryMax(A,B);
			System.out.println(
					"A:"+String.valueOf(A)+
					"; B:"+String.valueOf(B)+
					"; Result:"+String.valueOf(result));
		}

		System.out.println("EX 6:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			double n = genRandomDouble(1,100);
			double w = Math.min(genRandomDouble(1,10), genRandomDouble(1,10));
			double h = Math.min(genRandomDouble(1,10), genRandomDouble(1,10));
			int result = howManyItems(n,w,h);
			System.out.println(
					"Total Roll Length:"+String.valueOf(n)+
					"m; Width:"+String.valueOf(w)+
					"m; Height:"+String.valueOf(h)+
					"m; Result:"+String.valueOf(result));
		}
		
		System.out.println("EX 7:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int n = genRandomInt(0,10);
			int result = factorial(n);
			System.out.println(
					"n:"+String.valueOf(n)+
					"; Result:"+String.valueOf(result));
		}

		System.out.println("EX 8:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int A = genRandomInt(1,100);
			int B = genRandomInt(1,100);
			int result = gcd(A,B);
			System.out.println(
					"A:"+String.valueOf(A)+
					"; B:"+String.valueOf(B)+
					"; Result:"+String.valueOf(result));
		}
		System.out.println("EX 9:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int sales = genRandomInt(1,100);
			int price = genRandomInt(1,30)*10;
			double fee = genRandomInt(1,5) * 0.1;
			int result = ticketSeller(sales,price,fee);
			System.out.println(
					"Sales:"+String.valueOf(sales)+
					"; Price:"+String.valueOf(price)+
					"; Fee:"+String.valueOf(fee)+
					"; Profit:"+String.valueOf(result));
		}
		System.out.println("EX 10:");
		for (int i = 0; i < TRIES_PER_TASK; i++) {
			int students = genRandomInt(0,100);
			int tables = genRandomInt(0,3);
			int result = tableManager(students,tables);
			System.out.println(
					"Students:"+String.valueOf(students)+
					"; Tables:"+String.valueOf(tables)+
					"; Missing Tables:"+String.valueOf(result));
		}
	}
	
	public static int genRandomInt(int minValue, int maxValue) {
		return minValue + 
				(int) Math.floor(
						Math.random() * 
						(maxValue + 1 - minValue)
						);
	}
	public static double genRandomDouble(double minValue, double maxValue) {
		return minValue + Math.random() * 
						(maxValue - minValue);
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
		return (price * (int) Math.ceil(1.0-fee))*sales;
	}
	public static int tableManager(int students, int tables) {
		int unsat = students-tables*2;
		int req = unsat/2 + unsat % 2;
		return Math.max(req,0);
	}
}