/**
 * @param String descripition of the new item to be intantiated
 */

public class Todo extends Task {


    public Todo(String description) {
        super(description);
    }

    @Override
    public String Storage(){
        return "T | " + getStatusIcon() + " " + description;
    }

    @Override
    public String toString() {
        return "[T]" + "[" + getStatusIcon()+ "]" + description;
    }
}