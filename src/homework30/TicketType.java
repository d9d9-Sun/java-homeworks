package homework30;

public enum TicketType {
    SPEED("Штраф за скорость"),
    CROSSING_ROAD_IN_WRONG_PLACE("Штраф за переход в неположенном месте"),
    PARKING("Штраф за парковку"),
    CREATING_AN_EMERGENCY("Штраф за создание аварийной ситуации");

    private String ticketType;

    TicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketType() {
        return ticketType;
    }
}
