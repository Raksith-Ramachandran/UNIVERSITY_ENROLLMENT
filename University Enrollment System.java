importjava.sql.*; 
public class UniversityEnrollmentSystem { 
private static final String URL = "jdbc:mysql://localhost:3306/university"; 
private static final String USERNAME = "your_username"; 
private static final String PASSWORD = "your_password"; 
private static Connection connection; 
private static Statement statement; 
private static ResultSetresultSet; 
public static void main(String[] args) { 
try {           
connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
statement = connection.createStatement();         
        scanner sc= new scanner (system.in); 
createTables();            
int choice; 
do { 
System.out.println("University Enrollment System"); 
System.out.println("1. Add Student"); 
System.out.println("2. Add Course"); 
System.out.println("3. View Students"); 
System.out.println("4. View Courses"); 
System.out.println("0. Exit"); 
System.out.print("Enter your choice: "); 
choice = Integer.parseInt(sc.readLine()); 
switch (choice) { 
case 1: 
addStudent(); 
break; 
case 2: 
addCourse(); 
break; 
case 3: 
viewStudents(); 
break; 
case 4: 
viewCourses(); 
break; 
case 0: 
System.out.println("Exiting..."); 
break; 
default: 
System.out.println("Invalid choice. Please try again."); 
                } 
            } while (choice != 0); 
        } catch (SQLException e) { 
e.printStackTrace(); 
        } finally { 
try {                
if (resultSet != null) resultSet.close(); 
if (statement != null) statement.close(); 
if (connection != null) connection.close(); 
            } catch (SQLException e) { 
e.printStackTrace(); 
            } 
        } 
    } 
private static void createTables() throws SQLException { 
        String createStudentsTable = "CREATE TABLE IF NOT EXISTS students (" + 
                "id INT AUTO_INCREMENT PRIMARY KEY," + 
                "name VARCHAR(255)," + 
                "age INT)"; 
        String createCoursesTable = "CREATE TABLE IF NOT EXISTS courses (" + 
                "id INT AUTO_INCREMENT PRIMARY KEY," + 
                "name VARCHAR(255)," + 
                "faculty VARCHAR(255))"; 
statement.executeUpdate(createStudentsTable); 
statement.executeUpdate(createCoursesTable); 
    } 
private static void addStudent() throws SQLException { 
System.out.print("Enter student name: "); 
  Scanner sc= new Scanner (System.in); 
        String name = sc.readLine(); 
System.out.print("Enter student age: "); 
int age = Integer.parseInt(sc.readLine()); 
        String query = "INSERT INTO students (name, age) VALUES (?, ?)"; 
PreparedStatementpreparedStatement = connection.prepareStatement(query); 
preparedStatement.setString(1, name); 
preparedStatement.setInt(2, age); 
preparedStatement.executeUpdate(); 
System.out.println("Student added successfully."); 
    } 
private static void addCourse() throws SQLException { 
System.out.print("Enter course name: "); 
  Scanner sc= new Scanner (System.in); 
        String name = sc.readLine(); 
System.out.print("Enter faculty: "); 
        String faculty = sc.readLine(); 
        String query = "INSERT INTO courses (name, faculty) VALUES (?, ?)"; 
PreparedStatementpreparedStatement = connection.prepareStatement(query); 
preparedStatement.setString(1, name); 
preparedStatement.setString(2, faculty); 
preparedStatement.executeUpdate(); 
System.out.println("Course added successfully."); 
    } 
private static void viewStudents() throws SQLException { 
        String query = "SELECT * FROM students"; 
resultSet = statement.executeQuery(query); 
while (resultSet.next()) { 
System.out.println("ID: " + resultSet.getInt("id") + 
                    ", Name: " + resultSet.getString("name") + 
                    ", Age: " + resultSet.getInt("age")); 
        } 
    } 
private static void viewCourses() throws SQLException { 
        String query = "SELECT * FROM courses"; 
resultSet = statement.executeQuery(query); 
while (resultSet.next()) { 
System.out.println("ID: " + resultSet.getInt("id") + 
                    ", Name: " + resultSet.getString("name") + 
                    ", Faculty: " + resultSet.getString("faculty")); 
        } 
    }
}