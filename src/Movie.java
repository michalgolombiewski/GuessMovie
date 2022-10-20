public class Movie {
    private String title;
    String undercore;

    //Methods
    public String makeUnderScore(String film){
        char us = '-';
        String underscore="";
        String[] splitTitle = film.split(" ");
        for (int i=0;i<splitTitle.length;i++){

            for (int j=0;j<splitTitle[i].length();j++){
                underscore+=us;
            }
            underscore+=" ";
        }
        return underscore.trim();
    }
    public void addUnderScore(String undercore){
        this.undercore=undercore;
    }
    public void addTitle(String title){
        this.title=title;
    }
    public String getMovieTitle(){
        return title;
    }
}
