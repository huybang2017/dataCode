import java.util.Scanner;

public class tinh_to_hop {

	public tinh_to_hop() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		int n, k;
		n = Integer.parseInt(nhap.next());
		k = Integer.parseInt(nhap.next());
		if (1 <= k && k <= n && n <= 25) {

			int giai_thua_n = giaithua_n(n);
			int giai_thua_k = giaithua_k(k);
			int giai_thua_hieu = giaithua_hieu(n, k);

			int ket_qua = ket_qua(giai_thua_n, giai_thua_k, giai_thua_hieu);
			System.out.println(ket_qua);
		}

	}

	public static int giaithua_n(int n) {
		int giaithua_n = 1;
		for (int i = 1; i <= n; i++) {
			giaithua_n *= i;
		}
		return giaithua_n;
	}

	public static int giaithua_k(int k) {
		int giaithua_k = 1;
		for (int i = 1; i <= k; i++) {
			giaithua_k *= i;
		}
		return giaithua_k;
	}

	public static int giaithua_hieu(int n, int k) {
		int giaithua_hieu = 1;
		for (int i = 1; i <= (n - k); i++) {
			giaithua_hieu *= i;
		}
		return giaithua_hieu;
	}

	public static int ket_qua(int giai_thua_n, int giai_thua_k, int giai_thua_hieu) {
		int ket_qua = giai_thua_n / (giai_thua_k * giai_thua_hieu);
		return ket_qua;
	}

}
