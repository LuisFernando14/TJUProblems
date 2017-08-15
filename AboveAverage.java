package tju;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author LuisFernando ACCEPTED
 */
public class AboveAverage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static StringTokenizer st = new StringTokenizer("");

	public static String next() {
		try {
			while (!st.hasMoreTokens()) {
				String s = br.readLine();
				if (s == null)
					return null;
				st = new StringTokenizer(s);
			}
			return st.nextToken();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		DecimalFormat df = new DecimalFormat("0.000");
		int grade = 0, sum = 0, cont = 0, m = 0, n;
		double prom = 0, resultado = 0;
		n = Integer.parseInt(next());
		while (n-- > 0) {
			m = Integer.parseInt(next());
			while (m-- > 0) {
				grade = Integer.parseInt(next());
				sum += grade;
				grades.add(grade);
			}
			prom = (sum / grades.size());
			for (int i = 0; i < grades.size(); i++)
				if (grades.get(i) > prom)
					cont++;

			resultado = (double) (cont * 100) / grades.size();
			out.println(df.format(resultado) + "%");
			resultado = 0;
			grades.clear();
			cont = sum = 0;
			prom = 0.0;
		}
		out.flush();
		br.close();
	}
}