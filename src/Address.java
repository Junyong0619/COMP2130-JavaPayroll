public class Address {
    private String streetInfo;
    private String city;
    private String postalCode;
    private String province;
    private String country;

    public Address(String streetInfo, String city, String postalCode, String province, String country) {
        this.streetInfo = streetInfo;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    @Override
    public String toString() {
        return streetInfo + ", " + city + ", " + province + " " + postalCode + ", " + country;
    }
}
