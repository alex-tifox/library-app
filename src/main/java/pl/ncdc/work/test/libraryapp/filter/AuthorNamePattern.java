package pl.ncdc.work.test.libraryapp.filter;

import java.util.logging.Logger;

public abstract class AuthorNamePattern {


    private final static Logger logger = Logger.getLogger(AuthorNamePattern.class.getName());

    public static boolean isAuthorNamePattern(String authorName) {

        String[] authorData = authorName.split(" ");

        if (authorData.length < 2 || authorData.length > 2){
            logger.info("Author Name/Surname array is overflow or is not full enough...");
            return false;
        }

        for(int i = 0; i < authorData.length; i++) {
            if (authorData[i].charAt(0) == 'A') {
                if (i == authorData.length-1) {
                    logger.info("Author name successfully passed control...");
                    return true;
                }
            } else {
                logger.info("Author name is not correct");
                return false;
            }
        }
        logger.info("Something went wrong at the end of class.." + AuthorNamePattern.class.getName());
        return false;
    }
}
