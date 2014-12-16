package com.prakovec.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Admin on 06.12.2014.
 */
public class Post {

    private final List<Package> packages = new ArrayList<Package>();
    private int numberPackage = 0;


    public Post() {
    }


    public void addPackage(Package aPackage) {
        this.packages.add(aPackage);
        numberPackage++;
    }

    public void addPackage(String senderName, String senderAddress, String recipientName, String recipientAddress, double weight) {
        this.packages.add(new Package(senderName, senderAddress, recipientName, recipientAddress, weight));
        numberPackage++;
    }

    public int getNumberPackage() {
        return numberPackage;
    }

    /**
     * This method checks the package for errors
     *
     * @param packages is current package
     * @param index    is index of package
     * @return check result
     */
    public boolean checkPackage(List<Package> packages, int index) {
        if (packages.getClass() == null || packages.isEmpty()) {
            return false;
        } else if (packages.get(index).getSenderName() == "" || packages.get(index).getSenderAddress() == "" || packages.get(index).getRecipientName() == ""
                || packages.get(index).getRecipientAddress() == "") {
            packages.get(index).setStatus(Status.PROCESSED);
            packages.get(index).setHandlingDate(new Date());
            return false;
        } else {
            packages.get(index).setStatus(Status.PROCESSED);
            packages.get(index).setHandlingDate(new Date());
            return true;
        }


    }


    /**
     * This method sends the package to the recipient.
     *
     * @param packages is current package
     * @param index    is index of package
     */
    public void sentPackage(List<Package> packages, int index) {

        if (packages.get(index).getStatus() == Status.PROCESSED && checkPackage(packages, index)) {
            packages.get(index).setStatus(Status.SENT);
        }
    }

    /**
     * This method returns the package if it is not taken within a month, or it is not verified;
     *
     * @param packages is current package
     * @param index    is index of package
     */
    public void rejectPackage(List<Package> packages, int index) {

        if (packages.get(index).getHandlingDate().getTime() >= packages.get(index).getHandlingDate().getTime() + 2629743000L || !checkPackage(packages, index)) {
            packages.get(index).setStatus(Status.DECLINED);
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
