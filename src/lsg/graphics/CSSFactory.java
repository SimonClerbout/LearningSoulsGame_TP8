package lsg.graphics;

/**
 * Created by sclerbou on 08/01/18.
 */
public class CSSFactory {

    private static String CSS_DIR = "css/";

    public static String getStyleSheet(String filename){

        return CSSFactory.class.getResource(CSS_DIR +  filename).toExternalForm();

    }

}
