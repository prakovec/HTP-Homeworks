package model;

public class Parcel {
    private String name;
    private double weight;
    private static int nextId = 1;
    private String FROMWHERE;
    private String WHERE;
    private String id;

    public enum Pack {
        PAPER, PACKAGE, BOX
    }

    public Parcel() {
        id = String.valueOf(nextId++);
    }

    public Parcel(String id, String name, String FROMWHERE, String WHERE, double weight) {
        this.FROMWHERE = FROMWHERE;
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.WHERE = WHERE;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getFROMWHERE() {
        return FROMWHERE;
    }

    public String getWHERE() {
        return WHERE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Parcel parcel = (Parcel) o;
        return name.equals(parcel.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Parcel[" +
                "FROMWHERE - " + FROMWHERE +
                ", id = " + id + ", WHERE - " + WHERE +
                ']';
    }
}
