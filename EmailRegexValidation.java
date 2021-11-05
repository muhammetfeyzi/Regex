import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Author : Muhammet Feyzi Sağlam
 * @Date : 05.11.2021
 *
 * */
public class EmailRegexValidation {
    public static void main(String[] args) {
        String[] checkListEmail = {  ("user@domain.com"),
                ("client@domain.co.in"),
                ("client.name@domain.com"),
                ("client'name@domain.co.in"),
                //Invalid emails
                (".client@domain.com"),
                ("client@domain.com."),
                ("client@domain..com")};
        List email = Arrays.asList(checkListEmail);
        // the below code shows email regular expression pattern
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        //we will create new pattern object
        Pattern pattern = Pattern.compile(regex);
        email.stream().forEach(e->{
            Matcher matcher = pattern.matcher(e.toString());
            System.out.println(matcher.matches());
        } );
       // email.stream().forEach(System.out::println);

    }
}
