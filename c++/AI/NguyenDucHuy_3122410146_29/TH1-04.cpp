#include <bits/stdc++.h>
using namespace std;
bool checkSoNguyenTo(int num)
{
    if (num == 0 || num == 1)
    {
        return false;
    }
    for (int i = 2; i < num; i++)
    {
        if (num % i == 0)
        {
            return false;
        }
    }
    return true;
}
int main(int argc, char const *argv[])
{
    int n;
    int count = 0;
    FILE *array1;
    array1 = fopen("/mnt/d/huycode/c++/AI/file/array1.txt", "r");
    if (array1 == NULL)
    {
        cout << "không thể đọc file";
        return 1;
    }
    if (fscanf(array1, "%d", &n) != 1)
    {
        cout << "không thể đọc vào dòng đầu tiên";
        fclose(array1);
        return 1;
    }
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        fscanf(array1, "%d", &arr[i]);
    }
    for (int i = 0; i < n; i++)
    {
        if (checkSoNguyenTo(arr[i]) == true)
        {
            cout << arr[i];
            count++;
        }
    }
    fclose(array1);
    FILE *array;
    array = fopen("/mnt/d/huycode/c++/AI/file/array1.out", "w");
    fprintf(array, "%d", count);
    fclose(array);
    return 0;
}
