package VariousCalc;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EcoLab1 {
	public static class ChemData {
		double dailyLimit = -1.0;
		double maxSingleTimeLimit = -1.0;
		double OBUV = -1.0;
		int dangerRating = 3;
		
		public ChemData(double maxSTLimit, double dLimit, int dRating) {
			dailyLimit = dLimit;
			maxSingleTimeLimit = maxSTLimit;
			dangerRating = dRating;
		}
		public double calcIndex(double meanC) {
			double[] dangerC = {-1, 1.7, 1.3, 1, 0.9};
			double limCoeff = maxSingleTimeLimit;
			if (dailyLimit > 0.0) limCoeff = dailyLimit;
			else if (maxSingleTimeLimit < 0.0) limCoeff = OBUV;
			double res = meanC/limCoeff;
			res = Math.pow(res, dangerC[dangerRating]);
			return res;
		}
		
	}
	
	static HashMap<String,ChemData> chemDataTable = new HashMap<String,ChemData>();
	
	private static void initChemData() {
		chemDataTable.put("HNO3", new ChemData(0.4, 0.15, 2));
		chemDataTable.put("NO2", new ChemData(-1.0, 0.04, 2));
		chemDataTable.put("NH3", new ChemData(0.2, 0.04, 4));
		chemDataTable.put("Benzene", new ChemData(5.0, 1.5, 4));
		chemDataTable.put("Benzopyrene", new ChemData(-1.0, 1.0, 1));
		chemDataTable.put("C6H12O2", new ChemData(0.1, -1.0, 4));
		chemDataTable.put("V2O5", new ChemData(-1.0, 0.002, 1));
		chemDataTable.put("H2S", new ChemData(0.008, -1.0, 2));
		chemDataTable.put("C8H10", new ChemData(0.2, -1.0, 3));
		chemDataTable.put("Fe2O3", new ChemData(-1.0, 0.04, 3));
		chemDataTable.put("FeO", new ChemData(-1.0, 0.04, 3));
		chemDataTable.put("Slate Ash", new ChemData(0.3, 0.1, 3));
		chemDataTable.put("Fuel Oil Ash", new ChemData(-1.0, 0.002, 2));
		chemDataTable.put("Marganese", new ChemData(0.01, 0.001, 2));
		chemDataTable.put("CuO", new ChemData(-1.0, 0.002, 2));
		chemDataTable.put("CH4S", new ChemData(0.0001, -1.0, 4));
		chemDataTable.put("C7H8", new ChemData(0.6, -1.0, 3));
		chemDataTable.put("Polyethylene", new ChemData(-1.0, 0.01, 2));
		chemDataTable.put("C3H6O", new ChemData(0.35, -1.0, 4));
		chemDataTable.put("C3H6", new ChemData(3.0, -1.0, 3));
		chemDataTable.put("Seed Dust", new ChemData(0.5, 0.15, 3));
		chemDataTable.put("Wood Dust", new ChemData(-1.0, -1.0, 3));
		chemDataTable.get("Wood Dust").OBUV = 0.1;
		chemDataTable.put("Fur Dust", new ChemData(-1.0, -1.0, 3));
		chemDataTable.get("Fur Dust").OBUV = 0.03;
		chemDataTable.put("Paper Dust", new ChemData(6.0, -1.0, 3));
		chemDataTable.put("Abrasive Dust", new ChemData(-1.0, 0.05, 3));
		chemDataTable.put("Hg", new ChemData(-1.0, 0.0003, 1));
		chemDataTable.put("Lead", new ChemData(0.001, 0.0003, 1));
		chemDataTable.put("H2O4S", new ChemData(0.3, 0.1, 2));
		chemDataTable.put("SO2", new ChemData(-1.0, 0.05, 3));
		chemDataTable.put("Turpentine", new ChemData(2.0, 1.0, 4));
		chemDataTable.put("C8H20Pb", new ChemData(0.0001, 0.00004, 1));
		chemDataTable.put("Airborne Particulates", new ChemData(-1.0, 0.15, 3));
		chemDataTable.put("C", new ChemData(0.15, 0.05, 3));
		chemDataTable.put("CO", new ChemData(5.0, 3.0, 4));
		chemDataTable.put("Phenols Shale", new ChemData(0.007, -1.0, 3));
		chemDataTable.put("Formaldehyde", new ChemData(-1.0, 0.003, 2));
		chemDataTable.put("C5H4O2", new ChemData(0.08, 0.04, 3));
		chemDataTable.put("Chrome", new ChemData(-1.0, 0.0015, 1));
		chemDataTable.put("C2H4O2", new ChemData(0.2, 0.06, 3));
		chemDataTable.put("C8H8", new ChemData(0.04, 0.002, 2));
	}
	
	public static void main(String[] args) {
		initChemData();
		HashMap<String,Double> cityAPollutants = new HashMap<String, Double>();
		cityAPollutants.put("NO2", 0.1);
		cityAPollutants.put("SO2", 0.02);
		cityAPollutants.put("Airborne Particulates", 0.1);
		cityAPollutants.put("V2O5", 0.004);
		cityAPollutants.put("Marganese", 0.001);
		cityAPollutants.put("C3H6", 2.0);
		cityAPollutants.put("FeO", 0.02);
		HashMap<String,Double> cityBPollutants = new HashMap<String, Double>();
		cityBPollutants.put("NO2", 0.03);
		cityBPollutants.put("SO2", 0.05);
		cityBPollutants.put("Airborne Particulates", 0.3);
		cityBPollutants.put("FeO", 0.1);
		cityBPollutants.put("Seed Dust", 0.5);
		cityBPollutants.put("C8H8", 0.005);

		double cityAIdx = calcQuality(cityAPollutants, 5);
		System.out.print("City A Pollution Index: ");
		System.out.format("%.3f %n",cityAIdx);
		double cityBIdx = calcQuality(cityBPollutants, 5);
		System.out.print("City B Pollution Index: ");
		System.out.format("%.3f %n",cityBIdx);
		if (cityAIdx == cityBIdx) System.out.println("The cities are equally polluted");
		else if (cityAIdx < cityBIdx) {
			System.out.print("City B is ");
			System.out.format("%.3f",cityBIdx/cityAIdx);
			System.out.println(" times more polluted than city A");
		} else {
			System.out.print("City A is ");
			System.out.format("%.3f",cityAIdx/cityBIdx);
			System.out.println(" times more polluted than city B");
		}
		
	}
	
	private static double calcQuality(HashMap<String,Double> chemVolumes, int pollutantNum) {
		ArrayList<Double> idxArray = new ArrayList<Double>();
		for (String i: chemVolumes.keySet()) {
			double thisIdx = chemDataTable.get(i).calcIndex(chemVolumes.get(i));
			idxArray.add(thisIdx);
		}
		Collections.sort(idxArray, Collections.reverseOrder());
		int k = idxArray.size();
		if ( k > pollutantNum )
			idxArray.subList(pollutantNum, k).clear();
		double res = 0.0;
		for (int i = 0; i<idxArray.size();i++) {
			System.out.print(i);
			System.out.print(":");
			System.out.println(idxArray.get(i));
			
			res += idxArray.get(i);
		}
		return res;
	}
}