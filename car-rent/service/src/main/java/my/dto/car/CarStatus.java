package my.dto.car;

public enum CarStatus {
    AVAILABLE(true),
    UNAVAILABLE(false);

    private final boolean isAvailable;

    CarStatus(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
}
