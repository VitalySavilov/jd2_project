package my.dto.app_order;

public enum OrderStatus {
    COMPLETED(true),
    PROGRESS(false);

    private final boolean isCompleted;

    OrderStatus(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted(){
        return isCompleted;
    }
}
