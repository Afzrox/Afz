import java.util.Scanner;

public class Triplets{
    public static void findTriplets(int arr[],int n){
        boolean found=true;
        for(int i=0;i<n-2;i++){
            for(int j=i;j<n-1;j++){
                for(int k=j;k<n;k++){
                    if( (arr[i]+arr[j]+arr[k])==0 ){
                        System.out.print(arr[i]+" "+arr[j]+" "+arr[k]+" ");
                        System.out.println();
                        found = true;
                    }
                }
            }
        }
        if(!found){
            System.out.println("Not found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No.of Data");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter "+n+" data");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        findTriplets(arr,n);
        sc.close();
    }
}