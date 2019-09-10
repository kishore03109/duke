import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.*;
/*A-Collections*/
public class Duke {

    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        List<Task> list = new ArrayList<>();
        int commandNumber = -1;
        String item;
        Storage storage = null;

        int currentListSize = 0;

        while(true) {
            Scanner userInput = new Scanner(System.in);
            String userText = userInput.nextLine();

            if(userText.length() > 4 && userText.substring(0, 4).equals("done")) {
                String[] Value = userText.split(" ");
                commandNumber = Integer.parseInt(Value[1]);
                if(commandNumber > currentListSize){
                    System.out.println("Error, task not found");
                }

                Task task = list.get(commandNumber-1);
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" +
                        task.toString());

            } else if(userText.length() > 4 && userText.substring(0, 4).equals("todo")) {
                item = userText.substring(5);
                Todo todo = new Todo(item);
                list.add(todo);
                currentListSize += 1;
                storage.main(todo.Storage());
                System.out.print("Got it. I've added this task:\n [T][✗] "
                        + item + "\n Now you have " + currentListSize + " tasks in the list.");

            } else if(userText.length() > 8 && userText.substring(0, 8).equals("deadline")) {
                String[] Value = userText.substring(8).split("/by");
                item = Value[0];
                String by = Value[1];
                Deadline deadline = new Deadline(item, by);
                list.add(deadline);
                storage.main(deadline.Storage());
                currentListSize += 1;
                System.out.print("Got it. I've added this task:\n [D][✗]"
                        + item + "(by: " + by + ")\n Now you have " + currentListSize + " tasks in the list.");


            } else if(userText.length() > 5 && userText.substring(0, 5).equals("event")) {
                String[] Value = userText.substring(6).split("/at");
                item = Value[0];
                String by = Value[1];
                Event event = new Event(item, by);
                list.add(event);
                storage.main(event.Storage());
                currentListSize += 1;
                System.out.print("Got it. I've added this task:\n [E][✗]"
                        + item + "(at:" + by + ")\n Now you have " + currentListSize + " tasks in the list.");


            } else if(userText.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.exit(0);

            } else if(userText.equals("list")) {
                if (currentListSize < 1) {
                    System.out.print("☹ OOPS!!! I'm sorry, but currently there are no " +
                            "items in the list :-(");
                }
                for (int i = 0; i < currentListSize; i++) {
                    Task task = list.get(i);
                    System.out.print((i + 1) + "." + task.toString() + "\n");
                }

            } else if(userText.length() > 6 && userText.substring(0, 6).equals("delete")) {
                String[] Value = userText.split(" ");
                commandNumber = Integer.parseInt(Value[1]);
                if(commandNumber > currentListSize){
                    System.out.println("Error, task not found");
                }
                currentListSize -= 1;
                System.out.println("Noted. I've removed this task: \n" +
                        list.get(commandNumber-1).toString() + "\nNow you have" +
                        currentListSize + "tasks in the list.");
                list.remove(commandNumber-1);


            } else if(userText.length() > 4 && userText.substring(0, 4).equals("find")){
                String[] Value = userText.split(" ");
                String find = Value[1];
                int found = 0;
                System.out.println("Here are the matching tasks in your list:\n");
                List<Task> equal = new ArrayList<>();
                for(int i=0; i<currentListSize; i++){
                    Task task = list.get(i);
                    int firstIndex = task.description.indexOf(find);
                    if(firstIndex >= 0){
                        equal.add(task);
                        found++;
                    }
                }

                if(found > 0){
                    System.out.println("Here are the matching tasks in your list:\n");
                    for(int i=0; i<found; i++){
                        System.out.println(i+1 + ")" + equal.get(i).toString());
                    }
                } else {
                    System.out.println("☹ OOPS!!! I'm sorry, but no results match your query :-(");
                }

            } else {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }
}