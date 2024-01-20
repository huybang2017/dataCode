#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
// hàm kiểm tra chữ số nguyên
bool kiemTraChuSo(int soKiemTra, int soKhac)
{
    char chuoiSoKiemTra[20];
    sprintf(chuoiSoKiemTra, "%d", soKiemTra);

    while (soKhac > 0)
    {
        int chuSoKhac = soKhac % 10;
        soKhac /= 10;

        for (int i = 0; chuoiSoKiemTra[i] != '\0'; i++)
        {
            if (chuSoKhac == (chuoiSoKiemTra[i] - '0'))
            {
                return true;
            }
        }
    }

    return false;
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
        if (!kiemTraChuSo(num, numValue[i]))
        {
            fprintf(outputFile, "có các chữ số giống nhau: %d, vị trí thứ: %d\n", numValue[i], i);
            printf("có các chữ số giống nhau: %d, vị trí thứ: %d\n", numValue[i], i);
        }
    }
    fclose(outputFile);

    return 0;
}
