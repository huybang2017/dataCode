#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

const int N = 100; // Số thành phố
int cost[N][N]; // Ma trận trọng số
vector<int> path; // Lưu trữ hành trình tốt nhất
int minCost = INT_MAX; // Lưu trữ chi phí tối ưu

// Hàm đọc ma trận trọng số từ tệp tin
void readMatrixFromFile(const char* filename) {
    ifstream file(filename);
    if (!file) {
        cerr << "Không thể đọc tệp tin." << endl;
        exit(1);
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            file >> cost[i][j];
        }
    }

    file.close();
}

// Hàm kiểm tra xem một thành phố đã được ghé thăm hay chưa
bool isVisited(int city) {
    return find(path.begin(), path.end(), city) != path.end();
}

// Hàm tìm lời giải tối ưu bằng giải thuật nhánh cận
void branchAndBound(int current, int currentCost) {
    if (path.size() == N) {
        // Đã thăm hết tất cả các thành phố
        if (cost[current][0] < minCost) {
            minCost = currentCost + cost[current][0];
            path.push_back(0);
        }
        return;
    }

    for (int nextCity = 0; nextCity < N; nextCity++) {
        if (!isVisited(nextCity) && cost[current][nextCity] != 0) {
            path.push_back(nextCity);
            branchAndBound(nextCity, currentCost + cost[current][nextCity]);
            path.pop_back();
        }
    }
}

int main() {
    readMatrixFromFile("input.txt");

    path.push_back(0); // Bắt đầu từ thành phố 0
    branchAndBound(0, 0);

    cout << "Hành trình người bán hàng: ";
    for (int city : path) {
        cout << city << " -> ";
    }
    cout << "0" << endl;

    cout << "Chi phí nhỏ nhất: " << minCost << endl;

    return 0;
}
