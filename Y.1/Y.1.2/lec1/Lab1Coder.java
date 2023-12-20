import java.util.ArrayList;

public class Lab1Coder {
    private String name;
    int experience;
    private ArrayList<String> languages;

    public Lab1Coder() {
    }

    public Lab1Coder(String n, int exp) {
        name = n;
        experience = exp;
        languages = new ArrayList<>();
    }

    public Lab1Coder(String n) {
        name = n;
        experience = 0;
        languages = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String lang : languages) {
            result.append(lang).append(" ");
        }
        return name + "(" + experience + ") knows " + result;
    }

    ArrayList<String> findCommonLanguage(Lab1Coder other) {
        ArrayList<String> commonLanguages = new ArrayList<>();
        for (int i = 0; i < this.languages.size(); i++) {
            for (int j = 0; j < other.languages.size(); j++) {
                if (this.languages.get(i).equals(other.languages.get(j))) {
                    commonLanguages.add(this.languages.get(i));
                }
            }

        }
        if (commonLanguages.size() == 0) {
            commonLanguages.add("none");
        }
        return commonLanguages;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setExperience(int exp) {
        this.experience = exp;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(String... langs) {
        for (String string : langs) {
            languages.add(string);
        }
    }

}