package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {
        if (house == null || house.isEmpty()
                || keeper == null || keeper.isEmpty()
                || seeker == null || seeker.isEmpty()
                || chasers == null || chasers.length != 3
                || Team.arrayHasNull(chasers) || Team.arrayHasBlank(chasers))
            throw new IllegalArgumentException("Invalid Parameter(s).");
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team sourceTeam) {
        this.house = sourceTeam.house;
        this.keeper = sourceTeam.keeper;
        this.seeker = sourceTeam.seeker;
        this.chasers = Arrays.copyOf(sourceTeam.chasers, sourceTeam.chasers.length);
    }

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

    public String getHouse() {
        return this.house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getKeeper() {
        return this.keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public String getSeeker() {
        return this.seeker;
    }

    public void setSeeker(String seeker) {
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return this.chasers;
    }

    public void setChasers(String[] chasers) {
        this.chasers = chasers;
    }

    @Override
    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    /**
     * arrayHasNull
     * 
     * @param array
     * @return boolean
     */
    public static boolean arrayHasNull(String[] array) {
        return Arrays.stream(array).anyMatch(e -> e == null);

        // refactored above
        // for (int i = 0; i < array.length; i++) {
        // if (array[i] == null)
        // return true;
        // }
        // return false;
    }

    /**
     * arrayHasBlank
     * 
     * @param array
     * @return boolean
     */
    public static boolean arrayHasBlank(String[] array) {
        return Arrays.stream(array).anyMatch(e -> e.isBlank());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Team))
            return false;
        Team team = (Team) obj;

        return this.house == team.house
                && this.keeper == team.keeper
                && this.seeker == team.seeker
                && Arrays.toString(this.chasers).equals(Arrays.toString(chasers));
    }

    public int hashCode() {
        return Objects.hash(
                this.house,
                this.keeper,
                this.seeker,
                Arrays.toString(this.chasers));
    }

}
