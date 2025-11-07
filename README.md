# 🎓 Student Management System (Console)

## 🧩 Overview
A **Java console-based student record manager** with a clear separation of concerns:
- **AdminUI**: user interface & input handling (menu, validation, printing)
- **StudentManagement**: business logic & storage (static service-style API)
- **Student**: data model (encapsulated fields + getters/setters)

Admins can **add** students, **update** fields (with “press Enter to keep” semantics), **view** a single student, and **list** all students with a running total.

---

## ⚙️ Features
- **Add new student** (ID / name / age / grade) with validation  
  - ID/Name/Grade must be non-empty  
  - Age must be **3–120**
- **Update existing student** by ID  
  - Any field may be omitted (kept as-is)  
  - Age is range-checked (3–120)
- **View student** details by ID (`Optional`-based lookup)
- **List all students** and show **total count**
- **Robust console UX**: friendly messages, invalid-input handling

---

## 🧠 Concepts Used

| Concept | Where / How |
|---|---|
| **Encapsulation** | `Student` has private fields + getters/setters |
| **Separation of Concerns** | `AdminUI` (UI), `StudentManagement` (logic), `Student` (model) |
| **Static Service Layer** | `StudentManagement.add/update/get/list/getTotal` as static API |
| **Collections (Map/List)** | `HashMap<String, Student>` for storage; `List<Student>` for display |
| **Optional** | `getStudent(id)` returns `Optional<Student>` for safe access |
| **Input Validation** | Blank checks, integer parsing, age bounds (3–120) in `AdminUI` |
| **Control Flow** | Menu loop, `switch` on string choices, early returns for invalid inputs |
| **toString()** | `Student#toString()` produces a consistent printable record |

---

## 🗂 Project Structure
AdminUI.java // console menu, input/validation, printing
StudentManagement.java // static service: add/update/get/list/total using HashMap
Student.java // data model: id, name, age, grade (+ getters/setters/toString)

## 🏫 Educational Context

Built for a CS assignment to practice console I/O, validation, CRUD operations, collections (Map/List), and modular program design.
