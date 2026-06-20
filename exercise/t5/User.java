package exercise.t5;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public String name;
    // transient关键字修饰的字段/方法不参与序列化
    transient public String password;

    public User(String name) {
        this.name = name;
    }
}
