import java.io.Serializable;

public enum Genre implements Serializable {
    DRAMA(1), ROMANCE(2), CRIME(3), HORROR(4);

    private final int value;

    Genre(int value){
        this.value = value;
    }

    //getGenre(int value)
}



