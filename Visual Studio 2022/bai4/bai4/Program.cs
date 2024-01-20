using System.Text;

namespace bai4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            int a = 5;
            a += 2;
            Console.WriteLine("a = {0}", a);

            // Nhập vào 1 số hỏi số này là chẵn hay lẻ
            int b;
            Console.WriteLine("Nhập 1 số b: ");
            b = int.Parse(Console.ReadLine());

            if (b % 2 == 0)
            {
                Console.WriteLine("{0} là số chẵn", b);
            }
            else
            {
                Console.WriteLine("{0} là số lẻ", b);
            }

            Console.WriteLine("");

            // Xác định năm nhuận
            int year;
            Console.WriteLine("nhập vào 1 năm:");
            year = int.Parse(Console.ReadLine());

            if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
            {
                Console.WriteLine("{0} là năm nhuận",year);
            }
            else
            {
                Console.WriteLine("{0} là năm không nhuận", year);
            }
        }
    }
}