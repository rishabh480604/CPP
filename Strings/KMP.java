public class KMP {
    int[] lpsfinder(char[] pattern){
        //this will create lps table
        int[] lps=new int[pattern.length];
        lps[0]=0;
        int i=1;
        int pastlps=0;
        // System.out.println("hi");
        while(i<pattern.length){

            // System.out.println(i +" "+pastlps);
            if(pattern[i]==pattern[pastlps]){
                pastlps++;
                lps[i]=pastlps;
                i++;
            }else{
                if(pastlps!=0){
                    pastlps=lps[pastlps-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        char[] pattern=needle.toCharArray();
        int[] lps=lpsfinder(pattern);
        // System.out.println(Arrays.toString(lps));
        char[] word=haystack.toCharArray();
        int j=0;
        int i=0;
        while(i<word.length){
            
            if(word[i]==pattern[j]){
                
                // System.out.println(word[i]+" "+pattern[j]);
                j++;
                if(j==pattern.length){
                    return i-j+1;
                }
                i++;
            }else{
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                    // i++;
                    // System.out.println(i+" "+j);

                }

            }

        }
        // System.out.println("out of loop");
        return -1;
        
    }
}