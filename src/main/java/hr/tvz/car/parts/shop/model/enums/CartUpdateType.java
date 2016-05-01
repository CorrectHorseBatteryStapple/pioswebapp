package hr.tvz.car.parts.shop.model.enums;

public enum CartUpdateType {

    ADD, DELETE;

    public static CartUpdateType from(String updateType) {
        if (ADD.name().equals(updateType)) {
            return ADD;
        } else if (DELETE.name().equals(updateType.toUpperCase())) {
            return DELETE;
        } else {
            throw new IllegalArgumentException("Unknown update type: " + updateType);
        }
    }
}
