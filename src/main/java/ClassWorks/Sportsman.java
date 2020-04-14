package ClassWorks;

public class Sportsman {
    private String type;
    private String firstName;
    private String lastName;
    private int birthYear;
    private int score;
    private int place;

    Sportsman(){};

    public void setType(String type) {
        if(type.equals("художественная") || type.equals("тяжелая атлетика") || type.equals("водное многоборье")){
            this.type = type;
        }
        else {
            throw  new IllegalArgumentException("Object not initialised");
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        if(birthYear <= 1990 || birthYear >= 2010)
            throw  new IllegalArgumentException("Year is not in a range 1990-2010");

        this.birthYear = birthYear;
    }

    public void setPlace(int place) {
        if(place <= 0 || place > 100){
            throw new IllegalArgumentException("Place is not in a range 0-100");
        }

        this.place = place;
    }

    public void setScore(int score) {
        if(score <= 0 || score > 100){
            throw new IllegalArgumentException("Place is not in a range 0-100");
        }

        this.score = score;
    }

    public String getType() {
        return type;
    }

    public int getScore() {
        return score;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString(){
        return ("["+type + " " + firstName + " " + lastName + " " +  birthYear + " " +  place + " " + score + "]");
    }
}
