package otherProblems;

import java.util.ArrayList;
import java.util.List;

public class KthGrammer {
    public int kthGrammar(int N, int K) {
        List<String> lines = new ArrayList();
        lines.add("0");

        for(int i=1;i<N;i++){
            int count = lines.size();
            for(int j=0;j<count;j++){
                String val = lines.get(j);
                String n = "";

                if(val.length()>1){
                    for(int x=0;x<val.length();x++){
                        char a = val.charAt(x);
                        n+=replaceVal(String.valueOf(a));
                    }
                }else{
                    n+=replaceVal(val);
                }
                lines.add(j,n);
            }
        }

        String finalString = "";

        for(String s : lines){
            finalString+=s;
        }

        int kG = Integer.valueOf(String.valueOf(finalString.charAt(K-1)));

        return kG;
    }

    public String replaceVal(String a){
        String n= "";
        if(a.equals("0"))
        {
            n+="01";
        }else{
            n+="10";
        }

        return n;
    }

    public static void main(String [] args){
        KthGrammer kthGrammer = new KthGrammer();
        int cal = kthGrammer.kthGrammar(30
                ,434991989 );
        System.out.print(cal);
    }
}
