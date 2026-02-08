package com.example.demo.Enums;

public enum TicketStatus {
	NEW("New"),
    IN_PROGRESS("In_Progress"),
    CLOSED("Closed");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
