package com.restart.algorithm;

class Struct {
	public int r;
	public int c;
	public int time;
	
	public Struct()
	{
		this.r=0;
		this.c=0;
		this.time=0;
	}
	public Struct (int r, int c, int time ) {
		this.r = r;
		this.c = c;
		this.time = time;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}


public class Bfs_Example {
	static Struct myQueue[] = new Struct[10000000];
	static int front, rear;
	static int map[][]=new int[100][100];
	static int startX, startY;

	public static int bfs()
	{
		int dirX[]= {0,1,-1,0,0};
		int dirY[]={0,0,0,1,-1};
		int i,j;
		int flag=0;
		Struct data = new Struct(startX, startY,0);
		Struct nData = new Struct();
		
		while(queueIsNotNull())
		{
			deQueue(data);
			for(i=1;i<5; i++)
			{
				nData.r=data.r+dirX[i];
				nData.c = data.c + dirY[i];
				nData.time = data.time+1;
				
				if(nData.r<0&&nData.r>99) continue;
				if(nData.c<0&&nData.c>99) continue;
				
				if(map[nData.r][nData.c]==1) continue;
				
				if(map[nData.r][nData.c]==5){
					flag=1;
					break;
				}
				map[nData.r][nData.c]=1;
				enQueue(nData);
			}
			if(flag==1){
				return nData.time;
			}
		}
		return -1;
	}
	private static void enQueue(Struct nData) {
		// TODO Auto-generated method stub
		myQueue[rear++]=nData;
	}
	private static void deQueue(Struct data) {
		data.r = myQueue[front].r;
		data.c=myQueue[front].c;
		data.time=myQueue[front].time;
	}
	private static boolean queueIsNotNull() {
		return rear>front;
	}
	public static void main(String[] args) {
		Struct data = new Struct();
		data.c =1;
		data.r = 1;
		data.time= 100;
		myQueue[0] = data;
		
		System.out.println(myQueue[0].getTime());
				

	}

}
