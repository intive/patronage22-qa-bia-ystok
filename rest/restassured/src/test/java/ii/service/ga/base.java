package ii.service.ga;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;


public class base{

    static Faker faker = new Faker(new Locale("pl-PL"));


    public JSONObject patchIssueCommentContent = new JSONObject();



    @SneakyThrows //funkcja pobierająca link z pliku application.properties
    public String getUrl(){

        String path = Thread.currentThread().getContextClassLoader().getResource("application.properties").getPath();

        Properties appProp = new Properties();
        appProp.load(new FileInputStream(path));

        String link = appProp.getProperty("url");

        return link;
    }




    String postBoardBody = "{\n " +
            "\"alias\":\"foo\", \n" +
            "\"name\":\"sidaidhaihida\", \n" +
            "\"description\":\"noooS\"\n" +
            "}";

    String putBoardBody = "{\n " +
            "\"alias\":\"putalias\", \n" +
            "\"name\":\"putname\", \n" +
            "\"description\":\"putdesc\"\n" +
            "}";

    String patchBoardById = "{\n " +
            "\"alias\":\"patchtestalias\", \n" +
            "\"name\":\"patchtestname\", \n" +
            "}";


    String postBoardStatusBody = "{\n " +
            "\"boardId\":\"123\", \n" +
            "\"statusId\":\"1234\", \n" +
            "}";

    String postIssueBody = "{\n " +
            "\"alias\":\"issuePost04\", \n" +
            "\"name\":\"myIssue04\", \n" +
            "\"description\":\"realllyyyyyyyIssueeeeee\",\n" +
            "\"projectId\":\"123\", \n" +
            "\"id\":\"10304\", \n" +
            "\"isActive\":\"true\",\n" +
            "}";


    String postStatusBody = "{\n " +
            "\"is\":\"5\", \n" +
            "\"code\":\"code5\", \n" +
            "}";

    String putStatusBody = "{\n " +
            "\"is\":\"5\", \n" +
            "\"code\":\"code5\", \n" +
            "}";

//    @BeforeClass
//    public void loadBody() throws FileNotFoundException {
////        postBoardBody = new JSONObject ()
////                .put ("alias", "postAlias" + faker.internet ().ipV6Address ())
////                .put ("name", "postName" + faker.internet ().ipV6Address ())
////                .put ("description", "postDesc" + faker.internet ().ipV6Address ());
//
//
//        putBoardBody = new JSONObject ()
//                .put ("alias", "putAlias" + faker.internet ().ipV6Address ())
//                .put ("name", "putName" + faker.internet ().ipV6Address ())
//                .put ("description", "putDesc" + faker.internet ().ipV6Address ());
//
//        patchBoardBody = new JSONObject ()
//                .put ("alias", "patchAlias" + faker.internet ().ipV6Address ())
//                .put ("name", "patchName" + faker.internet ().ipV6Address ())
//                .put ("description", "patchDesc" + faker.internet ().ipV6Address ());
//
//        patchIssueCommentContent = new JSONObject()
//                .put("content", "putContent" + faker.internet().ipV6Address());
//    }



}
