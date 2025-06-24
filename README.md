# 🧑‍💼 Employee Management System – Vedantra Technologies

A full-stack, responsive **Employee Management System** web application built using **Java 21**, **Spring Boot**, **MySQL**, and **Vanilla JS**, featuring CRUD operations, custom sorting, search, pagination, and a modern UI. The project is deployed using **Render** (backend) and **GitHub Pages** (frontend).

---

## ✅ Features

- Create, Read, Update, Delete employees
- Custom sorting (by name, then email length, then role descending)
- RESTful API using DTO pattern
- Modal-based Add/Edit forms with validation
- Dynamic search and pagination
- Beautiful UI using HTML/CSS/JS (no Thymeleaf)
- API email notifications supported (e.g., "Ivan received" indicates success)
- Deployed and running live

---

## 🧱 Tech Stack

| Layer         | Technology               |
|---------------|---------------------------|
| Backend       | Java 21, Spring Boot      |
| Database      | MySQL                     |
| Frontend      | HTML, CSS, JavaScript     |
| Styling       | CSS3 with modern UI/UX    |
| Build Tool    | Maven                     |
| Version Ctrl  | Git, GitHub               |
| Deployment    | Render (API), GitHub Pages (Frontend) |

---

## 🧩 Custom Sorting Logic
**Sorting Criteria** (applied in order):

1. Sort by employee name (lexicographically)
2. If names are the same, sort by email length
3. If email lengths are the same, sort by role in descending order

Java Logic in `EmployeeService.java`:
```java
public List<Employee> getSortedEmployees() {
    return employeeRepository.findAll().stream()
        .sorted(Comparator.comparing(Employee::getName)
            .thenComparing(e -> e.getEmail().length())
            .thenComparing(Comparator.comparing(Employee::getRole).reversed()))
        .collect(Collectors.toList());
}

employee-management-system/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com.employee.demo/
│       │       ├── controller/
│       │       ├── dto/
│       │       ├── model/
│       │       ├── repository/
│       │       └── service/
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── employees.html
│           │   └── about.html ...
│           └── application.properties
│
├── pom.xml
└── README.md
Vedha K
🚀 Project deployed | 💼 Ready for Interview | 🧠 Full Stack Java Developer


---

---

Let me know if you'd like me to generate a downloadable version (`.zip` or `.pdf`) or want to directly commit this to your GitHub repo.
