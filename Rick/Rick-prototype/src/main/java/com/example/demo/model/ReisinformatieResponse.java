package com.example.demo.model;

import java.util.List;

public class ReisinformatieResponse {

    private List<Arrival> arrivals;  // Lijst van aankomsten

    // Getter en setter
    public List<Arrival> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Arrival> arrivals) {
        this.arrivals = arrivals;
    }

    public static class Arrival {
        private String origin;
        private String plannedDateTime;
        private String actualDateTime;
        private String plannedTrack;
        private String actualTrack;
        private String trainCategory;
        private boolean cancelled;

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPlannedDateTime() {
            return plannedDateTime;
        }

        public void setPlannedDateTime(String plannedDateTime) {
            this.plannedDateTime = plannedDateTime;
        }

        public String getActualDateTime() {
            return actualDateTime;
        }

        public void setActualDateTime(String actualDateTime) {
            this.actualDateTime = actualDateTime;
        }

        public String getPlannedTrack() {
            return plannedTrack;
        }

        public void setPlannedTrack(String plannedTrack) {
            this.plannedTrack = plannedTrack;
        }

        public String getActualTrack() {
            return actualTrack;
        }

        public void setActualTrack(String actualTrack) {
            this.actualTrack = actualTrack;
        }

        public String getTrainCategory() {
            return trainCategory;
        }

        public void setTrainCategory(String trainCategory) {
            this.trainCategory = trainCategory;
        }

        public boolean isCancelled() {
            return cancelled;
        }

        public void setCancelled(boolean cancelled) {
            this.cancelled = cancelled;
        }
    }
}
