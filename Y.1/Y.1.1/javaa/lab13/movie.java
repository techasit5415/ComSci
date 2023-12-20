public class movie {
    String Titles;
    int ReleasedYear;
    double Rating;


    movie(String t, int y, double r) {
        Titles = t;
        ReleasedYear = y;
        Rating = r;
    }

    public String getTitles() {
        return Titles;
    }

    public int getReleasedYear() {
        return ReleasedYear;
    }

    public double getRating() {
        return Rating;
    }

@Override
public String toString() {
    return  Titles + " (" + ReleasedYear + "," + Rating + ")";
}
}