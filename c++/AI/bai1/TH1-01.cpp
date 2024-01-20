#include <bits/stdc++.h>
#include <random>
using namespace std;
int main(int argc, char const *argv[])
{
    int m, n;
    int array[m][n];
    cout << "nhập m: ";
    cin >> m;
    cout << "nhập n: ";
    cin >> n;
    srand(time(NULL));

    FILE *array2;
    array2 = fopen("/mnt/d/huycode/c++/AI/file/array2.txt", "w");
    fprintf(array2, "%d %d %s", m, n, "\n");
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            fprintf(array2, "%d %s", rand() % 100 + 1, " ");
        }
        fprintf(array2, "%s", "\n");
    }

    fclose(array2);
    return 0;
}
