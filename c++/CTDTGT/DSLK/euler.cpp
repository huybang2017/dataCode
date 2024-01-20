#include<iostream>

using namespace std;

#define MAX 50
#define TRUE 1
#define FALSE 0

int n; //số đỉnh của đồ thị.
int m; //số cạnh của đồ thị.
int b[MAX]; //mảng b có độ dài m + 1 phần tử.
int u; //đỉnh bậc lẻ trong đồ thị
int OK; //biến kiểm tra đồ thị có đường đi EULER hay không.
int A[MAX][MAX]; //ma trận kề của đồ thị.

void Init() {
    // Nhập số đỉnh và ma trận kề.
    cin >> n;
    cout << "So dinh do thi:" << n;

    int s;
    int d = 0;

    for (int i = 1; i <= n; i++) {
        int s = 0;
        for (int j = 1; j <= n; j++) {
            cin >> A[i][j];
            s += A[i][j];
        }
        if (s % 2) {
            d++;
            u = i;
        }
        m = m + s;
    }

    m = m / 2;

    if (d != 2) OK = FALSE;
    else OK = TRUE;
}

void Result(void) {
    cout << "Co duong di Euler:";
    for (int i = 0; i <= m; i++)
        cout << (char)(b[i] + 'a' - 1) << " ";
    cout << endl;
}

void DDEULER(int i) {
    for (int j = 1; j <= n; j++) {
        if (A[b[i - 1]][j] == 1) {
            A[b[i - 1]][j] = 0;
            A[j][b[i - 1]] = 0;
            b[i] = j;
            if (i == m) {
                Result();
            }
            else {
                DDEULER(i + 1);
            }
            A[b[i - 1]][j] = 1;
            A[j][b[i - 1]] = 1;
        }
    }
}

int main(void) {
    Init();
    b[0] = u;
    int i = 1;
    if (OK) DDEULER(i);
    else cout << "\n Khong co duong di Euler";
    return 0;
}
