package sidoti.gary.mainpackage;


/**
 * This is my interpretation of the MersenneTwister Algorithm.
 * @author gsidoti
 *
 */
public class MersenneTwister implements RandomGenerator {
	/*
	 * Constants
	 */
	private static final int N = 624;
	private static final int M = 397;
	private static final int[] MAG01 = { 0x0, 0x9908b0df };
	private int[] mt;
	private int mti;

	public MersenneTwister(int n) {
		setSeed(n);
	}
	
	public MersenneTwister() {
		setSeed((int)System.currentTimeMillis());
	}


	private void setSeed(int seed) {
		mt = new int[N];
		mt[0] = (int)(seed & 0xffffffff);
		for (mti = 1; mti < N; mti++) {
            mt[mti] = (1812433253 * (mt[mti-1] ^ (mt[mti-1] >>> 30)) + mti);
		}
	}

	@Override
	public int getRandomNum() {
		int y;
		if (mti >= N) {
			int mtNext = mt[0];
			for (int k = 0; k < N - M; k++) {
				int mtCurr = mtNext;
				mtNext = mt[k + 1];
				y = (mtCurr & 0x80000000) | (mtNext & 0x7fffffff);
				mt[k] = mt[k + M] ^ (y >>> 1) ^ MAG01[y & 0x1];
			}
			for (int k = N - M; k < N - 1; k++) {
				int mtCurr = mtNext;
				mtNext = mt[k + 1];
				y = (mtCurr & 0x80000000) | (mtNext & 0x7fffffff);
				mt[k] = mt[k + (M - N)] ^ (y >>> 1) ^ MAG01[y & 0x1];
			}
			y = (mtNext & 0x80000000) | (mt[0] & 0x7fffffff);
			mt[N - 1] = mt[M - 1] ^ (y >>> 1) ^ MAG01[y & 0x1];

			mti = 0;
		}
		y = mt[mti++];

		y ^= y >>> 11;
		y ^= (y << 7) & 0x9d2c5680;
		y ^= (y << 15) & 0xefc60000;
		y ^= y >>> 18;

		return y;
	}
	
	public String toString(){
		return "Mersenne Twister";
	}

}
