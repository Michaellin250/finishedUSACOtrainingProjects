
public class Dubstep {

    public static void main(String[] args) {
       System.out.println(SongDecoder("RWUBWUBWUBLWUB"));
    }

    public static String SongDecoder(String song) {
        
        String toReturn = "";
        int count = 0;
        for(int i =0; i<song.length()-2; i++){
            
		//DELETED THIS PROGRAM SORRY
            if(song.substring(i,i+3).equals("WUB")){
                count++;
            }
            

        }
        
       
        
        return toReturn;
    }

}
