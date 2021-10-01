#include<stdio.h>
int a[10][10];
int b[10][10];
int Knapsack(int i,int j,int w[],int v[])
{
    int wi=w[i];
    if(i==0 || j==  0)
    {
        a[i][j]=0;
    }
    else if(wi>j)
    {
        a[i][j]=Knapsack(i-1,j,w,v);
        b[i][j]=0;
    }
    else if(wi<=j)
    {
        int l=Knapsack(i-1,j,w,v);
        int r=Knapsack(i-1,j-wi,w,v)+v[i];
        if(l>r)
        {
            a[i][j]=l;
            b[i][j]=0;
        }
        else if(l<=r)
        {
            a[i][j]=r;
            b[i][j]=1;
        }
    }
}
void main()
{
    int i,j,n,W;
    printf("\nEnter the number of items: ");
    scanf("%d",&n);
    int v[n+1];
    int w[n+1];
    printf("\nEnter the values of all the items: ");
    for(i=1;i<n+1;i++)
        scanf("%d",&v[i]);
    printf("\nEnter the weight of all the items: ");
    for(i=1;i<n+1;i++)
        scanf("%d",&w[i]);
    printf("\nEnter the Knapsack Capacity: ");
    scanf("%d",&W);
    Knapsack(n,W,w,v);
    for(i=0;i<=n;i++)
    {
        printf("\n");
        for(j=0;j<=W;j++)
            printf("%d\t",a[i][j]);
    }
    printf("\n");
    for(i=1;i<=n;i++)
    {
        printf("\n");
        for(j=1;j<=W;j++)
            printf("%d\t",b[i][j]);
    }
}
