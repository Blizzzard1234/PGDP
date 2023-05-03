package pgdp.warmup;

import java.util.ArrayList;

public class PenguWarmup {

	protected PenguWarmup() {
		throw new UnsupportedOperationException();
	}

	public static void penguInfoOut(int penguin) {
		if(penguin<0){
			System.out.println("Penguin " + penguin + " is not a known penguin!");
		}else{
			System.out.println("Penguin: " + penguin);
			if(penguin%2==0){
				System.out.println("This penguin is a male.");
			}else{
				System.out.println("This penguin is a female.");
			}
		}

	}

	public static int penguEvolution(int penguin, int years) {
		for(int i = 1; (i<=years);i++){
			if(penguin%2==0){
				penguin/=2;
				for(int j =1; j<=penguin; j*=2){
					if(penguin==(j)){
						penguin=1;
						break;
					}
				}
			}else{
				boolean t = true;
				for(int j =0; j<=penguin; j++){

					if(penguin==(j*7)){
						for(int h = 0; h<6; h++){
							//System.err.println("loop Year " + i + " Num. " + penguin);
							if(i<=years){i++;}}
						t=false;
						break;
					}
				}
				if(i<=years){
				penguin = penguin*3 + 1;}
			}
			//System.err.println("Year " + i + " Num. " + penguin);
		}
		return penguin;
	}

	public static int penguSum(int penguin) {
		int sum = 0;
		while(penguin > 0){
			sum += penguin%10;
			penguin/=10;
		}
		return sum;
	}

	public static long penguPermutation(long n, long k) {
		long sum=1;
		for(long i = (k+1);i<=n;i++){
			sum = sum*i;
		}
		return sum;
	}


	public static long penguPowers(int x2, int i2) {
		boolean isneg = false;
		long x = (long)x2;
		long i = (long)i2;
		if(i2==0)
			return(1);
		if(x<0){
			isneg = true;
			x = ~(x-1);
		}
		long sum = x;
		long adder = x;
		for(long h = 1;h<i;h++){
			for(long j = 1;j<x;j++){
				sum+=adder;
			}
			adder = sum;
		}
		if(isneg&&i%2==1){
			return(~(sum-1));
		}else{
		return sum;}
	}

	/*	Die Inhalte der main()-Methode beeinflussen nicht die Bewertung dieser Aufgabe
	 *	(es sei denn natürlich, sie verursachen Compiler-Fehler).
	 */
	public static void main(String[] args) {

		// Here is a place for you to play around :)
		int x = 23, y=13;
		ArrayList<Long> arr = new ArrayList<Long>();
		long min = 0;
		long max = 0;
		long min1 = 0;
		long max1 = 0;
		long min2 = 0;
		long max2 = 0;
		System.out.println(penguPowers(2,0));
		for(int i = 0; i<65;i++){
			for(int j =0;j<65;j++){

				long h = (long)(Math.pow((double)i, (double)j));
				long b = penguPowers(i,j);

				if((b + "").length()>19) {
					break;
				}

				if(b!=h){
					if(min==0&&b>1)
						min = b;
						min1 = i;
						min2 = j;
					if(b<min&&b>1){
						min = b;
					}
				}else{
					if(b>max){
						max = b;
						max1 = i;
						max2 = j;
					}
				}
			}
		}
		System.err.println("max: " + max + "   "+ max1+ "   "+ max2);
		System.err.println("min: " + min+ "   "+ min1+ "   "+ min2);



	}

}
