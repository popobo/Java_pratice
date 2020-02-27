package cn.bo.array2;


/**
  *  ��װ�����õ��㷨
 * @author 33136
 *
 */

public class Matrix {
	/**
	  * ��ӡָ���ľ���
	 * 
	 */
	public static void print(int[][] c) {
		// ��ӡ����
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	  * ����ӷ� 
	 */
	public static int[][] add(int [][] a, int [][] b) {
		int[][] c = new int[a.length][a[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		int[][]  a = {
				{1,3,3},
				{2,4,7},
				{6,4,9}
		};
		int[][]  b = {
				{3,3,3},
				{2,4,7},
				{1,4,9}
		};
		int[][] c = Matrix.add(a, b);
		print(c);
	}
}
