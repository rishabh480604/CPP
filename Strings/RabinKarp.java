class RabinKarp{
    //take any prime no
    private final int PRIME=3;
    private long calculateHash(String str){
        long hash=0;
        for(int i=0;i<str.length();i++){
            hash=hash+(long)(str.charAt(i)*Math.pow(i,PRIME));
        }
        return hash;
    }
    private long calculateHash(String str,int len){
        long hash=0;
        for(int i=0;i<len;i++){
            hash=hash+(long)(str.charAt(i)*Math.pow(i,PRIME));
        }
        return hash;
    }
    private long updateHash(long prevHash,int oldChar,int newChar, String str){
        long newHash=prevHash-(long)(str.charAt(oldChar)*Math.pow(oldChar,PRIME));
        newHash+=(long)(str.charAt(newChar)*Math.pow(newChar,PRIME));
        return newHash;
    }

    public int search(String text,String pattern){
        int patternLength=pattern.length();
        long patternHash=calculateHash(pattern);
        long textHash=calculateHash(text,patternLength);

        for(int i=0;i<=text.length()- pattern.length();i++){
            if(i!=0){
                patternHash=updateHash(patternHash,i-1,i,pattern);
            }
            if(patternHash==textHash){
                int temp=i;
                int j;
                for(j=0;j<patternLength;j++){
                    if(text.charAt(j)==pattern.charAt(temp)){
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
}