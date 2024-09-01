class RabinKarpAlgo{
    //take any prime no
    private final int PRIME=101;
    private long calculateHash(String str){
        long hash=0;
        for(int i=0;i<str.length();i++){
            hash=hash+(long)(Math.pow(str.charAt(i),PRIME));
        }
        return hash;
    }
    private long calculateHash(String str,int start,int len){
        long hash=0;
        for(int i=start;i<len+start;i++){
            hash=hash+(long)(Math.pow(str.charAt(i),PRIME));
        }
        return hash;
    }
    private long updateHash(long prevHash,int oldChar,int newChar, String str){
        long newHash=prevHash-(long)(Math.pow(str.charAt(oldChar),PRIME));
        newHash+=(long)(Math.pow(str.charAt(newChar),PRIME));
        return newHash;
    }

    private int search(String text,String pattern){
        int patternLength=pattern.length();
        System.out.println("pattern length : "+patternLength);
        long patternHash=calculateHash(pattern);
        long textHash=calculateHash(text,0,patternLength);

        for(int i=0;i<=text.length()- pattern.length();i++){
            if(i!=0){
                textHash=updateHash(textHash,i-1,i+patternLength-1,text);
            }
            System.out.println(i+" textHash: "+textHash+" PatternHash: "+patternHash);
            if(patternHash==textHash){
                int temp=i;
                int j=0;
                // System.out.println(text.charAt(temp)+"  "+pattern.charAt(j));
                for(j=0;j<patternLength;j++){
                    if(pattern.charAt(j)==text.charAt(temp)){
                        temp++;
                    }else{
                        
                        j=Integer.MAX_VALUE;
                        break;

                    }
                }
                if(j!=Integer.MAX_VALUE){
                    return i;
                }

            }
            //match pettern hash with text
            //if match then check string -can possible match or not
            // if match return
        }
        return -1;
    }
    RabinKarpAlgo(String text,String pattern){
        // System.out.println("ans : "+calculateHash(text, 7,5));
        System.out.println(search(text,pattern));
    }
}
public class RabinKarp{
    public static void main(String[] args) {

        String text="raceracarecar";
        String pattern ="care";
        RabinKarpAlgo obj=new RabinKarpAlgo(text, pattern);
        /*
        try{
        }catch(Exception e){
            System.out.println(e);
        } */
    }
}