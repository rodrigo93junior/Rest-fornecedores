package model;

import java.util.Map;
import java.util.HashMap;
import javax.json.JsonObject;

public class Provider {

    private String id;
    private String name;
    private String mail;
    private String comment;
    private String identification;
    
    public static Map<String, JsonObject> providers = new HashMap<String, JsonObject>();

    public Provider() {
    }

    public Provider(String id, String name, String mail, String comment, String identification) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.comment = comment;
        this.identification = identification;

        // providers.add(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIdentification() {
        return this.identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Provider id(String id) {
        this.id = id;
        return this;
    }

    public Provider name(String name) {
        this.name = name;
        return this;
    }

    public Provider mail(String mail) {
        this.mail = mail;
        return this;
    }

    public Provider comment(String comment) {
        this.comment = comment;
        return this;
    }

    public Provider identification(String identification) {
        this.identification = identification;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Provider)) {
            return false;
        }
        Provider provider = (Provider) o;
        return id == provider.id;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", mail='" + getMail() + "'" +
            ", comment='" + getComment() + "'" +
            ", identification='" + getIdentification() + "'" +
            "}";
    }


}