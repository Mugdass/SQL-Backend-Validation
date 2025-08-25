# 🔹 SQL-Backend-Validation

Java + JDBC + TestNG | Backend validation framework for database testing.

---

## 🚀 Purpose

Validate backend data from a MySQL database using SQL queries in automated TestNG test cases.

---

## 🧪 Technologies

- Java 11+
- JDBC (MySQL)
- TestNG
- Maven

---

## 📄 Sample Test

```java
@Test
public void testUserCount() throws SQLException {
    Connection conn = DBConnection.getConnection();
    ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM users");
    rs.next();
    int count = rs.getInt(1);
    Assert.assertTrue(count > 0);
}




🔁 CI/CD Integration

GitHub Actions runs the DB tests on each push and pull request.

Make sure DB config is accessible via CI or mocked for demo purposes.

Workflow: .github/workflows/ci.yml



on: [push, pull_request]
jobs:
  db-tests:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '11'
      - run: mvn clean test



⚙️ Setup
Update DB config in DBConnection.java
Add your own queries to DBValidationTests.java
Run via:

mvn test




---

## 📄 `.gitignore`

```gitignore
target/
*.log
.DS_Store
.idea/
.vscode/
*.iml
