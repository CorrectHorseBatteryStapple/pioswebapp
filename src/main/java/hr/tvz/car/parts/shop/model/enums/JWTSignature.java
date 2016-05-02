package hr.tvz.car.parts.shop.model.enums;

public enum JWTSignature {

    KEY("X@Yte?%.CfKRdxA7Hc:Abo+;8akaSDA!CWj1wn6lunS=.50qGLCZgWM#q7ww02uG");

    private String key;

    private JWTSignature(String key) {
        this.key = key;
    }

    public String getValue() {
        return key;
    }

}
