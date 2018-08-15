public class Client {
    String id;
    String fullName;

    public Client() {
        id = null;
        fullName = null;
    }

    public Client(String id, String name) {
        this.id = id;
        this.fullName = name;
    }

    String getId(){
        return id;
    }

    String getFullName(){
        return fullName;
    }
}
