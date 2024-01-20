#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{
    int n;
    cout << "nhập n: ";
    cin >> n;
    int count = 0;
    srand(time(NULL));
    FILE *array1;
    array1 = fopen("/mnt/d/huycode/c++/AI/file/array1.txt", "w");
    fprintf(array1, "%d %s", n, "\n");
    for (int i = 1; i <= n; i++)
    {
        fprintf(array1, "%d %s", rand() % 100 + 1, " ");
        count++;
        if (count % 10 == 0 && count != 0)
        {
            fprintf(array1, "%s", "\n");
        }
    }
    fclose(array1);
    return 0;
}
