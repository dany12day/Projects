package Model.Builder;

import Model.Client;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class ClientBuilder {
    private Client client;

    public ClientBuilder(){
        client = new Client();
    }

    public ClientBuilder setId(Long id){
        client.setId(id);
        return this;
    }

    public ClientBuilder setName(String clientName){
        client.setName(clientName);
        return this;
    }

    public ClientBuilder setIdentityCardNumber(String identityCardNumber){
        client.setIdentityCardNumber(identityCardNumber);
        return this;
    }

    public ClientBuilder setPersonalNumericCode(String personalNumericCode){
        client.setPersonalNumericCode(personalNumericCode);
        return this;
    }

    public ClientBuilder setAddres(String addres){
        client.setAddress(addres);
        return this;
    }

    public ClientBuilder setAccountIdentificationNumber(String accountIdentificationNumber){
        client.setAccountIdentificationNumber(accountIdentificationNumber);
        return this;
    }

    public Client build(){
        return client;
    }
}
