class RabinKarp{
    //take any prime no
    private final int PRIME=101;
    private long calculateHash(String str){
        long hash=0;
        for(int i=0;i<str.length();i++){
            hash=hash+(long)(str.charAt(i)*Math.pow(PRIME,i));
        }
        return hash;
    }
    private long updateHash(long prevHash,char oldChar,char newChar, int patternLength){
        // long newHash= roll and find newHash;
        return newHash;
    }

    public void search(String text,String pattern){
        int patternLength=pattern.length();
        long patternHash=calculateHash();
        long textHash=calculateHash();

        for(int i=0;i<=text.length()- pattern.length();i++){
            //match pettern hash with text
            //if match then check string -can possible match or not
            // if match return
        }
    }
}