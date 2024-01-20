#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>
int temp;
double sum;
int a[10];
int aPrime[10];
int isPrime(int n){
	if(n<2)
		return 0;
	for(int i=2;i*i<=n;i++){
		if(n%i==0)
			return 0;
	}
	return 1;
}
void *thread1(void *arg){
	int s = 0, count = 0;
	FILE *fin = fopen((char *)arg,"rt");
	if(fin == NULL){
		printf("Khong the mo file trong thread1 !\n");
		pthread_exit(NULL);
	}
	while(fscanf(fin,"%d", &temp) != EOF){
		s += temp;
		count++;
	}
	sum = s*1.0/count;
	fclose(fin);
	pthread_exit(NULL);
}
void *thread2(void *arg){
	FILE *fin = fopen((char *)arg,"rt");
	if(fin == NULL){
		printf("Khong the mo file trong thread2 !\n");
		pthread_exit(NULL);
	}
	int i = 0;
	while(fscanf(fin,"%d",&temp)!=EOF){
		a[i] = temp;
		i++;
	}
	for(int i=0;i<10;i++){
		for(int j=i+1;j<10;j++){
			if(a[j]<a[i]){
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
		}
	}
	fclose(fin);
	pthread_exit(NULL);
}
void *thread3(void *arg){
	FILE *fin = fopen((char *)arg,"rt");
	if(fin == NULL){
		printf("Khong the mo file trong thread3 !\n");
		pthread_exit(NULL);
	}
	int i =0;
	while(fscanf(fin,"%d",&temp)!=EOF){
		if(isPrime(temp)){
			aPrime[i] = temp;
			i++;
		}
	}
	fclose(fin);
	pthread_exit(NULL);
}
void *thread4(void *arg){
	FILE *fout = fopen((char *)arg,"wt");
	if(fout == NULL){
		printf("Khong the mo file trong thread4 !\n");
		pthread_exit(NULL);
	}
	fprintf(fout,"Trung binh cong la: %0.2lf\n",sum);
	fprintf(fout, "Mang tang dan la: ");
	for (int i = 0; i < 10; ++i)
	{
		fprintf(fout, "%d ",a[i]);
	}
	fprintf(fout, "\n");
	fprintf(fout, "Cac so nguyen to la: ");
	for(int i=0;i<10;i++){
		if(aPrime[i]!=0) // xoa gia tri rac trong mang Prime
		fprintf(fout,"%d ",aPrime[i]);
	}
	fclose(fout);
	pthread_exit(NULL);
}
int main(int argc, char *argv[]){
	if(argc != 3){
		printf("Vui long nhap 1 file input va 1 file output !\n");
		return 1;
	}
	FILE *fin = fopen(argv[1],"wt");
	if(fin==NULL){
		printf("Khong the tao file %s", argv[1]);
	return 2;
	}
	srand(time(NULL));
	for(int i=0; i<10; i++){
		int randNum = rand()%100;
			if(randNum>0){
				fprintf(fin,"%d ", randNum);
			}
	}
	fclose(fin);	
	pthread_t tid1, tid2, tid3, tid4;
	pthread_create(&tid1, NULL, thread1, argv[1]);
	pthread_create(&tid2, NULL, thread2, argv[1]);
	pthread_create(&tid3, NULL, thread3, argv[1]);
	pthread_join(tid1,NULL);
	pthread_join(tid2,NULL);
	pthread_join(tid3,NULL);
	pthread_create(&tid4, NULL, thread4, argv[2]);
	pthread_join(tid4,NULL);
	return 0;
}