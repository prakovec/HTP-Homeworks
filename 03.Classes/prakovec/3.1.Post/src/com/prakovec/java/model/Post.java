package com.prakovec.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Admin on 06.12.2014.
 */
public class Post {

    private final List<Package> packages = new ArrayList<Package>();


    public Post() {
    }


    public void addPackage(Package aPackage) {
        this.packages.add(aPackage);
    }

    public void addPackage(String senderName, String senderAddress, String recipientName, String recipientAddress, double weight) {
        this.packages.add(new Package(senderName, senderAddress, recipientName, recipientAddress, weight));
    }

    public int getNumberPackage() {
        return packages.size();
    }

    /**
     * This method checks the package for errors
     *
     * @param aPackage is current package
     * @return check result
     */
    public boolean checkPackage(Package aPackage) {
        if (aPackage == null) {
            return false;
        } else if (aPackage.getSenderName().isEmpty() || aPackage.getSenderAddress().isEmpty() ||
                aPackage.getRecipientName().isEmpty() || aPackage.getRecipientAddress().isEmpty()) {
            aPackage.setStatus(Status.PROCESSED);
            aPackage.setHandlingDate(new Date());
            return false;
        } else {
            aPackage.setStatus(Status.PROCESSED);
            aPackage.setHandlingDate(new Date());
            return true;
        }


    }


    /**
     * This method sends the package to the recipient.
     *
     * @param aPackage is current package
     */
    public void sentPackage(Package aPackage) {

        if (aPackage.getStatus() == Status.PROCESSED && checkPackage(aPackage)) {
            aPackage.setStatus(Status.SENT);
        }
    }

    /**
     * This method returns the package if it is not taken within a month, or it is not verified;
     *
     * @param aPackage is current package
     */
    public void rejectPackage(Package aPackage) {

        if (aPackage.getHandlingDate().getTime() >= aPackage.getHandlingDate().getTime() + 2629743000L || !checkPackage(aPackage)) {
            aPackage.setStatus(Status.DECLINED);
        }
    }

    public List<Package> getPackages() {
        return packages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (!packages.equals(post.packages)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return packages.hashCode();
    }

    @Override
    public String toString() {
        return "Post{" +
                "packages=" + "\n" + packages +
                '}';
    }
}
