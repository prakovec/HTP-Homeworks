package com.prakovec.java;

import com.prakovec.java.model.Package;
import com.prakovec.java.model.Post;


public class Main {

    public static void main(String[] args) {

        Post post = new Post();
        Package package1 = new Package("Pavel Rakovec", "Minsk, Lozhinskaya str. h. 10 ap. 166",
                "Vasja Pupkin", "Moskow, Lenina str. h. 15. ap. 25", 1.20);
        post.addPackage(package1);

        Package package2 = new Package("Pavel Rakovec", "Minsk, Lozhinskaya str. h. 10 ap. 166",
                "", "Moskow, Lenina str. h. 15. ap. 25", 0.90);
        post.addPackage(package2);

        Package package3 = new Package("Pavel Rakovec", "Minsk, Lozhinskaya str. h. 10 ap. 166",
                "sdfsdf", "Moskow, Lenina str. h. 15. ap. 25", 0.90);
        post.addPackage(package3);
        for (int i = 0; i < post.getNumberPackage(); i++) {
            post.checkPackage(post.getPackages().get(i));
            post.rejectPackage(post.getPackages().get(i));
            post.sentPackage(post.getPackages().get(i));
        }

        System.out.println(post.toString());
    }
}
