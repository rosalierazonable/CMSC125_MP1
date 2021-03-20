public class Request {

    int user;
    int resource;
    int duration;
    String status;
    String name;

    Request(String name, int user, int resource, int duration) {
        this.user = user;
        this.resource = resource;
        this.duration = duration;
        this.status = "waiting";
        this.name = name;
    }

    void in_waiting() {
        System.out.println(this.user + " is waiting for resource " + this.resource);
    }

    void in_action() {
        System.out.println(this.user + "is now using the resource " + this.resource);
    }

    boolean is_completed() {
        return this.status.equals("complete");
    }
}
