package Asc;

import java.util.*;

class Chatroom {
    private String name;
    private Set<String> username;
    private List<String> messages;

    {
        name = "";
        username = new HashSet<String>();
        messages = new ArrayList<String>();
    }

    public boolean removeUser(String username) {
        return this.username.remove(username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getUsername() {
        return username;
    }

    public void setUsername(Set<String> username) {
        this.username = username;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}

class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class ChatApplication {

    private Map<String, Chatroom> chatrooms = new HashMap<String, Chatroom>();
    private Map<String, User> users = new HashMap<String, User>();
    private Set<String> loggedInUsers = new HashSet<String>();

    public boolean isChatroomNameValid(String name) {
        return !chatrooms.containsKey(name);
    }

    public boolean isUsernameExists(String username) {
        return users.containsKey(username);
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void createChatroom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter chatroom name:");
        String name = scanner.nextLine();

        if (!isChatroomNameValid(name)) {
            System.out.println("Chatroom already exists.");
            return;
        }

        Chatroom chatroom = new Chatroom();
        chatroom.setName(name);
        chatrooms.put(name, chatroom);

        System.out.println("Chatroom created successfully.");
    }

    public void addNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        if (isUsernameExists(username)) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        User user = new User(username, password, firstName, lastName);
        users.put(username, user);

        System.out.println("User added successfully.");
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        if (!isUsernameExists(username)) {
            System.out.println("Username does not exist.");
            return false;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (!authenticateUser(username, password)) {
            System.out.println("Authentication failed.");
            return false;
        }

        loggedInUsers.add(username);
        System.out.println("User logged in successfully.");
        return true;
    }

    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter chatroom name:");
        String chatroomName = scanner.nextLine();

        Chatroom chatroom = chatrooms.get(chatroomName);

        if (chatroom == null) {
            System.out.println("Chatroom does not exist.");
            return;
        }

        System.out.println("Enter message:");
        String message = scanner.nextLine();

        if (loggedInUsers.isEmpty()) {
            System.out.println("No user logged in.");
            return;
        }

        for (String username : loggedInUsers) {
            chatroom.getUsername().add(username);
        }

        chatroom.getMessages().add(message);

        System.out.println("Message sent successfully.");
    }

    public void printMessages() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter chatroom name:");
        String chatroomName = scanner.nextLine();

        Chatroom chatroom = chatrooms.get(chatroomName);

        if (chatroom == null) {
            System.out.println("Chatroom does not exist.");
            return;
        }

        List<String> messages = chatroom.getMessages();

        if (messages.isEmpty()) {
            System.out.println("No messages found.");
            return;
        }

        System.out.println("Messages:");
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void listUsersFromChatroom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter chatroom name:");
        String chatroomName = scanner.nextLine();

        Chatroom chatroom = chatrooms.get(chatroomName);

        if (chatroom == null) {
            System.out.println("Chatroom does not exist.");
            return;
        }

        Set<String> usernames = chatroom.getUsername();

        if (usernames.isEmpty()) {
            System.out.println("No user found.");
            return;
        }

        System.out.println("Users:");
        for (String username : usernames) {
            System.out.println(username);
        }
    }

    public void logout() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        if (!loggedInUsers.contains(username)) {
            System.out.println("User is not logged in.");
            return;
        }

        loggedInUsers.remove(username);
        System.out.println("User logged out successfully.");
    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        if (!isUsernameExists(username)) {
            System.out.println("Username does not exist.");
            return;
        }

        for (Chatroom chatroom : chatrooms.values()) {
            chatroom.removeUser(username);
        }

        users.remove(username);

        System.out.println("User deleted successfully.");
    }

    public void deleteChatroom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter chatroom name:");
        String chatroomName = scanner.nextLine();

        Chatroom chatroom = chatrooms.get(chatroomName);

        if (chatroom == null) {
            System.out.println("Chatroom does not exist.");
            return;
        }

        chatrooms.remove(chatroomName);

        System.out.println("Chatroom deleted successfully.");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("A) Create a chatroom");
            System.out.println("B) Add a user");
            System.out.println("C) User login");
            System.out.println("D) Send a message");
            System.out.println("E) Display the messages from a specific chatroom");
            System.out.println("F) List down all users belonging to the specified chatroom.");
            System.out.println("G) Logout");
            System.out.println("H) Delete an user");
            System.out.println("I) Delete the chatroom.");
            System.out.println("Please enter your option:");

            String option = scanner.nextLine();

            switch (option) {
                case "A":
                    createChatroom();
                    break;
                case "B":
                    addNewUser();
                    break;
                case "C":
                    login();
                    break;
                case "D":
                    sendMessage();
                    break;
                case "E":
                    printMessages();
                    break;
                case "F":
                    listUsersFromChatroom();
                    break;
                case "G":
                    logout();
                    break;
                case "H":
                    deleteUser();
                    break;
                case "I":
                    deleteChatroom();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

public class Assignment3Q6 {
public static void main(String[] args) {
ChatApplication chatApplication = new ChatApplication();
chatApplication.menu();
}
}
            



