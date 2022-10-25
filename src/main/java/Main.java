import java.sql.*;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/librariesbooks";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    public static void main(String[] args){

        GsonParser parser = new GsonParser();
        System.out.println("Введите путь до файла");/*C:\need\try.json*/
        Root root = parser.parse();
        System.out.println("Root"+ root.toString());

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }



            for(Library item: root.getLibrary() ){
                    /*Для очистки таблицы libraries*/
                    /*PreparedStatement statement = connection.prepareStatement("DELETE FROM libraries WHERE id<10000");
                    PreparedStatement statement3 = connection.prepareStatement("ALTER TABLE libraries AUTO_INCREMENT = 1");
                    statement.executeUpdate();
                    statement3.executeUpdate();*/

                    /*Для заполнения таблицы libraries данными из json файла*/
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO libraries(name, address, email, phone) VALUES ((?), (?), (?), (?))");
                    statement.setString(1, item.getName());
                    statement.setString(2, item.getAddress());
                    statement.setString(3, item.getEmail());
                    statement.setString(4, item.getPhone());
                    statement.executeUpdate();


                    for(Book item2: item.getBooks() ){
                        /*Для очистки таблицы books  */
                       /*PreparedStatement statement2 = connection.prepareStatement("DELETE FROM books WHERE id<10000");
                        PreparedStatement statement4 = connection.prepareStatement("ALTER TABLE books AUTO_INCREMENT = 1");
                        statement2.executeUpdate();
                        statement4.executeUpdate();*/

                        /*Для заполнения таблицы books данными из json файла*/
                        PreparedStatement statement2 = connection.prepareStatement("INSERT INTO books(name, cnt) VALUES ((?), (?))");
                        statement2.setString(1, item2.getName());
                        statement2.setLong(2, item2.getCnt());
                        statement2.executeUpdate();
                    }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Информация о книгах и библиотеках успешно сохранена в БД");
    }
}
