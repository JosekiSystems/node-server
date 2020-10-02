package net.corda.explorer.model.response;

public class Profile {
    private String name;
    private String city;
    private String country;
    private String rpcConnectionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRpcConnectionId() { return rpcConnectionId; }

    public void setRpcConnectionId(String rpcConnectionId) { this.rpcConnectionId = rpcConnectionId; }
}
