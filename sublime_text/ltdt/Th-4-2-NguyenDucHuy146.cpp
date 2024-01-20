#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = 1e9; // Giá trị vô cùng (Infinity)

int main() {
    ifstream input("input.txt");
    if (!input.is_open()) {
        cerr << "Không thể mở tệp input.txt" << endl;
        return 1;
    }

    int n;
    input >> n;

    // Đọc ma trận trọng số từ tệp input.txt
    vector<vector<int>> weights(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            input >> weights[i][j];
        }
    }
    input.close();

    vector<int> path; // Lưu trữ hành trình
    int totalCost = 0; // Tổng chi phí

    // Bắt đầu từ thành phố 0
    int currentCity = 0;
    path.push_back(currentCity);

    // Duyệt qua tất cả các thành phố còn lại
    for (int i = 1; i < n; i++) {
        int nextCity = -1;
        int minWeight = INF;

        for (int j = 0; j < n; j++) {
            if (find(path.begin(), path.end(), j) == path.end() && weights[currentCity][j] < minWeight) {
                minWeight = weights[currentCity][j];
                nextCity = j;
            }
        }

        if (nextCity != -1) {
            path.push_back(nextCity);
            totalCost += minWeight;
            currentCity = nextCity;
        }
    }

    // Quay trở lại thành phố xuất phát
    path.push_back(path[0]);
    totalCost += weights[currentCity][path[0]];

    // In ra hành trình và chi phí
    cout << "Hành trình: ";
    for (int city : path) {
        cout << city << " ";
    }
    cout << endl;
    cout << "Chi phí nhỏ nhất: " << totalCost << endl;

    return 0;
}
