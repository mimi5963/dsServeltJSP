package room;

import lombok.Data;

@Data
public class RoomVO {

    private String num;
    private String name;
    private String mode;
    private String owner;
    //private Set<Session> users;
}
