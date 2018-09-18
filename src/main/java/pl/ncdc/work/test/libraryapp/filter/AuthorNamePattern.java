package pl.ncdc.work.test.libraryapp.filter;

public abstract class AuthorNamePattern {
    public static boolean isAuthorNamePattern(String authorName) {
        String[] authorData = authorName.split(" ");
        if(authorData.length < 2 || authorData.length > 2){
            return false;
        }

        for(int i = 0; i < authorData.length; i++) {
            if(authorData[i].charAt(0) == 'A'){
                if (i == authorData.length-1)
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
