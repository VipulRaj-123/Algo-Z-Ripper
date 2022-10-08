#include<stdio.h>
void FloydWarshall(int [][6],int);
int min(int,int);
void main()
{
    int vcount;
    printf("\nEnter the number of vertices: ");
    scanf("%d",&vcount);
    int W[][6] ={{0,0,0,0,0,0},
                {0,0,3,8,999,-4},
                  {0,999,0,999,1,7},
                  {0,999,4,0,999,999},
                  {0,2,999,-5,0,999},
                  {0,999,999,999,6,0}};
    FloydWarshall(W,vcount);
}
int min(int x,int y)
{
    if(x<=y)
        return x;
    else
        return y;
}
void FloydWarshall(int W[][6],int vcount)
{
    int D[vcount+1][vcount+1][vcount+1];
    int PI[vcount+1][vcount+1][vcount+1];
    int i,j,k;
    for(i=1;i<=vcount;i++)
        for(j=1;j<=vcount;j++)
            D[0][i][j]=W[i][j];
    for(i=1;i<=vcount;i++)
        for(j=1;j<=vcount;j++)
        {
            if((i==j) || (W[i][j]==999))
                PI[0][i][j]=-1;
            else PI[0][i][j]=i;
        }
    for(k=1;k<=vcount;k++)
        for(i=1;i<=vcount;i++)
            for(j=1;j<=vcount;j++)
            {
                D[k][i][j]=min(D[k-1][i][j],D[k-1][i][k]+D[k-1][k][j]);
                if(D[k-1][i][j]<=D[k-1][i][k]+D[k-1][k][j])
                    PI[k][i][j]=PI[k-1][i][j];
                else PI[k][i][j]=PI[k-1][k][j];
            }
    for(i=1;i<=vcount;i++)
    {
        for(j=1;j<=vcount;j++)
            printf("%d\t",D[vcount][i][j]);
        printf("\n");
    }
    printf("The parent matrix is: \n");
    for(i=1;i<=vcount;i++)
    {
        for(j=1;j<=vcount;j++)
            printf("%d\t",PI[vcount][i][j]);
        printf("\n");
    }
}
