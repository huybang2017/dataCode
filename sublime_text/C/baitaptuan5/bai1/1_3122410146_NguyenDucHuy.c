#include <stdio.h>
#include <stdlib.h>
// hàm tính tổng chữ số của 1 số nguyên
int tinhTongChuSo(int n)
{
    int tong = 0;

    while (n > 0)
    {
        int chuSo = n % 10;
        tong += chuSo;
        n /= 10;
    }

    return tong;
}
int main(int argc, char const *argv[])
{
    char listValue[300000];
    if (argc != 4)
    {
        printf("Không đúng định dạng. Hãy nhập đủ 3 tham số.\n");
        return 1;
    }

    int num = atoi(argv[1]);
    // Kiểm tra số đó có trong khoảng từ 0 đến 40
    if (num < 0 || num > 40)
    {
        printf("Nhập số nguyên từ 0 đến 40.\n");
        return 1;
    }

    FILE *dataFile = fopen(argv[2], "r");
    // Kiểm tra xem file có tồn tại
    if (dataFile == NULL)
    {
        printf("File input không tồn tại.\n");
        return 1;
    }

    int numValue[300000]; // Mảng để lưu các số nguyên
    int count = 0;

    while (fgets(listValue, sizeof(listValue), dataFile) != NULL)
    {
        // Kiểm tra xem đã đủ phần tử trong mảng chưa
        if (count >= sizeof(numValue) / sizeof(numValue[0]))
        {
            printf("Mảng không đủ lớn để lưu tất cả số nguyên từ file.\n");
            break;
        }

        numValue[count] = atoi(listValue);
        count++;
    }
    fclose(dataFile);

    // tính tổng chữ số có bằng argv[1] lưu vào file output
    FILE *outputFile;
    outputFile = fopen(argv[3], "w");

    for (int i = 0; i < count; i++)
    {
        if (num == tinhTongChuSo(numValue[i]))
        {
            fprintf(outputFile, "tổng các chữ số bằng với argv: %d, vị trí thứ: %d\n", numValue[i], i);
            printf("tổng các chữ số bằng với argv: %d, vị trí thứ: %d\n", numValue[i], i);
        }
    }
    fclose(outputFile);

    return 0;
}
