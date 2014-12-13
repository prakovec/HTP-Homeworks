import model.Parcel;
import model.Post;

/**
 * Created by aangurets on 03.12.2014.
 */

public class Main {
    public static void main(String[] args) {
        Parcel parcel1 = new Parcel("Parcel 001", "Andrei", "UK", "BY", 1.755);
        Post.addParcel(parcel1);
        Parcel parcel2 = new Parcel("Parcel 002", "Max", "UK", "BY", 0.2255);
        Post.addParcel(parcel2);
        System.out.println(parcel1);
        System.out.println(parcel2);
    }
}
