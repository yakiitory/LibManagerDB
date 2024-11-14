package yakiitory.libmanagerdb.manager;

public class TestBookManager {
   public static void main(String[] args) {
    BookManager manager = new BookManager();
    
    // CRUD Operation Tests
    // Test Create: Add a new book with quantity
    boolean createResult = manager.createBook("1984", "George Orwell", 1949, 2); // Adding 2 copies of the book
    System.out.println("Create result: " + createResult);

    // Test Read: Display all books in the database
    System.out.println("\nBooks in the database:");
    manager.readBooks(); // This will list all books, including the one just created

    // Test Update: Modify the quantity of an existing book
    boolean updateResult = manager.updateBookQuantity("1984", "George Orwell", 1949, 10); // Update quantity to 10
    System.out.println("\nUpdate result: " + updateResult);
        
    // Test Remove: Remove a specific quantity of a book (decrease by 1)
    boolean removeResult = manager.removeBookQuantity("1984", "George Orwell", 1949, 1); // Decrease quantity by 1
    System.out.println("\nRemove result: " + removeResult);

    // Test Read: Display all books in the database again after updates
    System.out.println("\nBooks in the database after updates:");
    manager.readBooks();
   }
}
/**/