public class LargestNumber {

    public String largestNumber(final int[] A) {
        int n=A.length;
        StringBuilder a[]=new StringBuilder[A.length];
        for(int i=0;i<n;i++){
            a[i]=new StringBuilder(A[i]+"");
        }
        Arrays.sort(a,new Comparator<StringBuilder>(){
            @Override
            public int compare(StringBuilder x,StringBuilder y){
                String xy=x.toString()+y.toString();
                String yx=y.toString()+x.toString();
                return yx.compareTo(xy);
            }
        });

        StringBuilder x=new StringBuilder("");
        if(a[0].charAt(0)=='0')
            return "0";
        for(StringBuilder s:a){
            x.append(s);
        }

        return x.toString();
    }
}