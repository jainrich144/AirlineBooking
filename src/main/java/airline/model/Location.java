package airline.model;

/**
 * Created by Keyuri on 30-08-2017.
 * upgraded by RichaJain on 01/09/17.
 */
public class Location {
    private String id;
    private String name;

    public Location(String inputId, String inputName) {
        id = inputId;
        name = inputName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
