
public class gridrec {

    public static void main (String[] args){
        gridrec t = new gridrec();
        System.out.println(t.gridpath(2,3));     
    }

    int gridpath(int n, int m){
        if (n == 1 || m == 1){
            return 1;
        }else {
            return gridpath(n,m-1) + gridpath(n-1,m);
        }        
    }
}