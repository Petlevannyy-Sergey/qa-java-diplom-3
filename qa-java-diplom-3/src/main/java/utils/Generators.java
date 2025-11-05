package utils;

import com.github.javafaker.Faker;
import user.User;

public class Generators {
    public static User getUser() {
        return  new User(
                new Faker().internet().emailAddress(),
                new Faker().internet().password(),
                new Faker().name().firstName());
    }
}
