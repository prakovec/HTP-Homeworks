package com.prakovec.java.model;

import java.util.Date;

/**
 * Created by Admin on 06.12.2014.
 */
public class Package {

    //Поля класса
    public final static String WHERE = "BY";
    public final static String FROM_WHERE = "RU";
    private final String id;
    private static int nextId = 1;
    private String senderName;
    private String senderAddress;
    private String recipientName;
    private String recipientAddress;
    private double weight;
    private Date handlingDate;
    private final Date receiptDate;
    private Status status;

    //Конструктор

    public Package(String senderName, String senderAddress, String recipientName, String recipientAddress, double weight) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        receiptDate = new Date();
        status = Status.RECIVED;
        this.id = String.format("%s%04d%s", FROM_WHERE, nextId++, WHERE);
    }

    // Методы


    public String getSenderName() {
        return senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public double getWeight() {
        return weight;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public Date getHandlingDate() {
        return handlingDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setHandlingDate(Date handlingDate) {
        this.handlingDate = handlingDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Package)) return false;

        Package aPackage = (Package) o;

        if (!id.equals(aPackage.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Package{" +
                "id='" + id + '\'' + "\n" +
                "senderName='" + senderName + '\'' + "\n" +
                "senderAddress='" + senderAddress + '\'' + "\n" +
                "recipientName='" + recipientName + '\'' + "\n" +
                "recipientAddress='" + recipientAddress + '\'' + "\n" +
                "weight=" + weight +
                ", handlingDate=" + handlingDate +
                ", receiptDate=" + receiptDate +
                ", status=" + status +
                '}' + "\n \n";
    }
}
