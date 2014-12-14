package model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private static final List<Parcel> parcels = new ArrayList<Parcel>();
    private boolean delivery = false;

    public static void addParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    public void addParcel(String id, String name, String FROMWHERE, String WHERE, double weight) {
        this.parcels.add(new Parcel(id, name, FROMWHERE, WHERE, weight));
    }

    public static void addParcel(String id, String name, double weight, String FROMWHERE, String WHERE) {
        parcels.add(new Parcel(id, name, FROMWHERE, WHERE, weight));
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setDelivery(boolean delivery) {

        this.delivery = delivery;
    }

    public boolean isDelivery() {
        return delivery;
    }

}
