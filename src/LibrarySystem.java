

import java.util.*;

public class LibrarySystem {

    private final List<Media> mediaList = new ArrayList<>();  // Medier
    private final List<User> userList = new ArrayList<>();    // Användare
    private final List<Loan> loanList = new ArrayList<>();    // Alla lån

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Bibliotekssystem ===");
            System.out.println("1. Registrera användare");
            System.out.println("2. Lägg till nytt media (bok/DVD)");
            System.out.println("3. Låna media");
            System.out.println("4. Returnera media");
            System.out.println("5. Sök efter media");
            System.out.println("6. Avsluta");
            System.out.print("Välj ett alternativ: ");

            try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: registerUser(scanner);
                    break;
                case 2: addMedia(scanner);
                    break;
                case 3: loanMedia(scanner);
                    break;
                case 4: returnMedia(scanner);
                    break;
                case 5: searchMedia(scanner);
                    break;
                case 6: running = false;
                    System.out.println("Avslutar systemet...");
                    break;
                default:
                    System.out.println("Ogiltigt alternativ, försök igen 1-6.");
            }
        } catch (InputMismatchException e) {
                System.out.println("Ogiltig inmatning. Vänligen ange ett nummer.");
                scanner.nextLine();
            }
        }
    }

    // Lägga till nytt media (bok eller DVD)
    private void addMedia(Scanner scanner) {
        System.out.println("\n--- Lägg till nytt media ---");
        System.out.print("Välj media att lägga till (1. Bok, 2. DVD): ");
        int mediaType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ange titel: ");
        String title = scanner.nextLine();
        Date pubDate = new Date();  // Använd dagens datum som publiceringsdatum

        if (mediaType == 1) {  // Lägg till en bok
            System.out.print("Ange författare: ");
            String author = scanner.nextLine();
            mediaList.add(new Book(title, pubDate, author));
            System.out.println("Bok '" + title + "' har lagts till.");
        } else if (mediaType == 2) { // Lägg till DVD
            System.out.print("Ange regissör: ");
            String director = scanner.nextLine();
            mediaList.add(new DVD(title, pubDate, director));
            System.out.println("DVD '" + title + "' har lagts till.");
        } else {
            System.out.println("Ogiltigt val.");
        }
    }

    // User reg.
    private void registerUser(Scanner scanner) {
        System.out.println("\n--- Registrera ny användare ---");
        System.out.print("Ange namn: ");
        String name = scanner.nextLine();
        System.out.print("Är detta en VIP-medlem? (j/n): ");
        String vipResponse = scanner.nextLine();

        int memberNo = userList.size() + 1;  // Generera medlemsnummer

        if (vipResponse.equalsIgnoreCase("j")) {
            userList.add(new VIPMember(name, memberNo));
            System.out.println("VIP-medlem " + name + " registrerad.");
        } else {
            userList.add(new RegularMember(name, memberNo));
            System.out.println("Vanlig medlem " + name + " registrerad.");
        }
    }

    // Låna media
    private void loanMedia(Scanner scanner) {
        System.out.println("\n--- Låna media ---");
        if (userList.isEmpty()) {
            System.out.println("Inga användare är registrerade.");
            return;
        }
        if (mediaList.isEmpty()) {
            System.out.println("Inga medier är tillgängliga.");
            return;
        }

        System.out.print("Ange medlemsnummer: ");
        int memberNo = scanner.nextInt();
        scanner.nextLine();  // Rensa ingången

        User user = findUserById(memberNo);
        if (user == null) {
            System.out.println("Användare hittades inte.");
            return;
        }

        System.out.print("Ange titeln på mediat du vill låna: ");
        String title = scanner.nextLine();

        Media media = findMediaByTitle(title);
        if (media == null) {
            System.out.println("Media hittades inte.");
            return;
        }

        // Skapa ett nytt lån
        Loan loan = new Loan(user, media, new Date());
        loanList.add(loan);
        System.out.println(user.getName() + " har lånat " + media.getTitle() + " till " + loan.getEndDate());
    }

    private void returnMedia(Scanner scanner) {
        System.out.println("\n--- Returnera media ---");
        if (loanList.isEmpty()) {
            System.out.println("Det finns inga aktiva lån.");
            return;
        }

        System.out.print("Ange medlemsnummer: ");
        int memberNo = scanner.nextInt();
        scanner.nextLine();  // Rensa ingången

        Loan loanToReturn = null;
        for (Loan loan : loanList) {
            if (loan.getUser().getMemberNo() == memberNo) {
                loanToReturn = loan;
                break;
            }
        }

        if (loanToReturn == null) {
            System.out.println("Inga lån hittades för det medlemsnumret.");
        } else {
            loanList.remove(loanToReturn);
            System.out.println("Lån på " + loanToReturn.getMedia().getTitle() + " har returnerats.");
        }
    }

    private void searchMedia(Scanner scanner) {
        System.out.println("\n--- Sök efter media ---");
        System.out.print("Ange titel: ");
        String title = scanner.nextLine();

        Media media = findMediaByTitle(title);
        if (media != null) {
            System.out.println("Media hittades: " + media.getTitle() + ", skriven av: " + media.getCreator());
        } else {
            System.out.println("Inget media hittades med titeln: " + title);
        }
    }

    private User findUserById(int memberNo) {
        for (User user : userList) {
            if (user.getMemberNo() == memberNo) {
                return user;
            }
        }
        return null;
    }

    private Media findMediaByTitle(String title) {
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}
