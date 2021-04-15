package pl.pjatk.adrwoj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class MyPojosec {
    @Bean
    public MyPojo myPojo(){
        return new MyPojo("hghg", "7", 2015, true);
    }


    @Bean
    @ConditionalOnExpression("${my.custom.property:true}")
    public List defaultData() {
        System.out.println(getMyValue());
        return List.of("1", "2", "3", "5", "2");
    }



    private String goodProfile(){
        return ("Wybraleś dobry profil");
    }

    private String badProfile(){
        return ("Wybraleś zły profil");

    }


    @Value("${my.custom.property}") String showReult;
    private String getMyValue() {
        if(showReult.equals("true")){
            return goodProfile();
        } else
            return badProfile();
    }
}
