package data.factory;

import com.github.javafaker.Faker;
import model.Post.Request.PostRequest;
import static model.Post.Request.PostRequest.Builder;

import org.apache.commons.lang3.StringUtils;

public class CreatePostDataFactory {

    private static final Faker faker = new Faker();

    public static PostRequest missingAllinformation(){
        return new Builder().withBody(StringUtils.EMPTY).withId(0).withTitle(StringUtils.EMPTY).withUserId(0).build();
    }

    public static PostRequest news(){
        return new Builder()
                .withBody(faker.book()
                .title()+faker.file().fileName())
                .withId(faker.number().numberBetween(300,4000))
                .withTitle(faker.book().title())
                .withUserId(faker.number().numberBetween(1,400)).build();
    }

}
