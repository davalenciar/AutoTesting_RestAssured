package model.User.Request.Builder;

import model.User.Request.UserRequest;

public class BuildNewUserMale extends UserRequestBuilder{

    public BuildNewUserMale(){
        super.user=new UserRequest();
    }

    public void Buildemail() {
        user.setEmail("beto@gmail.com");
    }

    public void Buildgender() {
        user.setGender("male");
    }

    public void Buildstatus() {
        user.setStatus("Active");
    }

    public void Buildname() {
        user.setName("Beto Cuevas");
    }
}
