package by.application.javaWeb.model.dto;

public class AutoDto {

    private Integer id;
    private String name;
    private String transmissionType;     //Коробка передач
    private String carBodyType;          //Тип кузова
    private String engineType;           //Тип двигателя
    private String brandType;            //Марка
    private String country;
    private String info;

    public AutoDto() {
    }

    public AutoDto(Integer id, String name, String transmissionType, String carBodyType,
                   String engineType, String brandType, String country, String info) {
        this.id = id;
        this.name = name;
        this.transmissionType = transmissionType;
        this.carBodyType = carBodyType;
        this.engineType = engineType;
        this.brandType = brandType;
        this.country = country;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(String carBodyType) {
        this.carBodyType = carBodyType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
