package j1.s.p0101.employees;

import java.util.Date;
/**
 *
 * @author Yankee
 */
public class View {

    Managermant mn;

    public View() {
    }

    public View(Managermant mn) {
        this.mn = mn;
    }

    public void displayMenu() {
        System.out.println("__Main menu:__");
        System.out.println("\t1. Add employees.");
        System.out.println("\t2. Update employees (by Id).");
        System.out.println("\t3. Remove employees(by Id).");
        System.out.println("\t4. Search employees (by Name (First Name or Last Name) or a part of name).");
        System.out.println("\t5. Sort employees by salary.");
        System.out.println("\t6. Exit.");
        System.out.println();
    }

    public void createEmp() {
        String id = new String();
        String firstName = new String();
        String lastName = new String();
        String phoneNumber;
        String email = new String();
        String address = new String();
        Date DOB;
        String sex = new String();
        double salary;
        String Egency = new String();

        while (true) {
            while (true) {
                id = Validation.inputString("Enter ID: ");
                if (!Validation.isAlphanumeric(id)) {
                    System.out.println("ID must be alphanumeric! Re-enter.");
                } else {
                    break;
                }
            }

            if (mn.idExisted(id) != null) {
                System.err.println("=> This ID already exists! Please add staff under a different ID.");
                continue;
            }
            firstName = Validation.inputName("Enter first name: ");
            lastName = Validation.inputName("Enter last name: ");
            while (true) {
                phoneNumber = Validation.inputString("Enter phone number: ");
                if (Validation.isDigit(phoneNumber)) {
                    break;
                } else {
                    System.err.println("Phone number not valid! Re-enter.");
                }

            }
            email = Validation.inputEmail("Enter email: ");
            address = Validation.inputString("Enter address: ");
            DOB = Validation.inputDate("Enter D.O.B: ", "dd/MM/yyyy");
            if (Validation.ageValid(DOB) < 18) {
                System.err.println("Employee not enough 18+! Enter another employee.");
                continue;
            }

            sex = Validation.SexValue("Enter sex: ");

            while (true) {
                salary = Validation.inputDouble("Enter salary: ");
                if (salary > 0) {
                    break;
                } else {
                    System.out.println("Salary must be bigger than 0! Re-enter.");
                }
            }

            Egency = Validation.inputString("Enter egency: ");

            Employees emp = new Employees(id, firstName, lastName, phoneNumber, email, address, DOB, sex, salary, Egency);
            mn.addEmp(emp);

            if (Validation.checkYesNo("\nDo you want to add more employees (Y/N)?"
                    + " Choose Yes(Y) to continue add, choose No(N) to return main screen.\n=> Your choice: ")) {
                System.out.println("");
                continue;
            } else {
                break;
            }
        }

        System.err.println(
                "___ADDING SUCCESFULL___");
        System.out.println(
                "\n**List Emp:**");
        Header();

        displayEmpList();

    }

    public void updateEmp() {
        if (mn.getEmpList().isEmpty()) {
            System.err.println("Employees list is empty, you must add employee information first.\n");
            return;
        }
        while (true) {
            String id = Validation.inputString("Enter ID of employee you want to update: ");

            if (mn.idExisted(id) == null) {
                System.err.println("=> Not found employee with ID: " + id);
            } else {
                Employees e = new Employees(mn.idExisted(id).getId(), mn.idExisted(id).getFirstName(), mn.idExisted(id).getLastName(),
                        mn.idExisted(id).getPhoneNumber(), mn.idExisted(id).getEmail(), mn.idExisted(id).getAddress(),
                        mn.idExisted(id).getDOB(), mn.idExisted(id).getSex(), mn.idExisted(id).getSalary(), mn.idExisted(id).getEgency()
                );

                System.err.println("Before Update:");
                displayByID(id);

                // update first name
                if (Validation.checkYesNo("Do you want to update first name? Choose Yes(Y) to update,"
                        + " No(N) to continue. => Your choice: ")) {
                    String firstName = Validation.inputName("Enter new first name: ");
                    e.setFirstName(firstName);
                }
                System.out.println("");

                if (Validation.checkYesNo("Do you want to update last name? Choose Yes(Y) to update,"
                        + " No(N) to continue. => Your choice: ")) {
                    String lastName = Validation.inputName("Enter new last name: ");
                    e.setLastName(lastName);
                }
                System.out.println("");

                // update phone number                   
                if (Validation.checkYesNo("Do you want to update phone number?"
                        + " Choose Yes(Y) to update, No(N) to continue. => Your choice: ")) {
                    while (true) {
                        String phoneNumber = Validation.inputString("Enter new phone number: ");
                        if (Validation.isDigit(phoneNumber)) {
                            e.setPhoneNumber(phoneNumber);
                            break;
                        } else {
                            System.err.println("Phone number not valid! Re-enter.");
                        }
                    }

                    System.out.println("");

                    if (Validation.checkYesNo("Do you want to update email?"
                            + " Choose Yes(Y) to update, No(N) to continue. => Your choice: ")) {
                        String email = Validation.inputEmail("Enter new email: ");
                        e.setEmail(email);
                    }
                    System.out.println("");

                    if (Validation.checkYesNo("Do you want to update address?"
                            + " Choose Yes(Y) to update, No(N) to continue. => Your choice: ")) {
                        String address = Validation.inputString("Enter new address: ");
                        e.setAddress(address);
                    }
                    System.out.println("");

                    if (Validation.checkYesNo("Do you want to update salary?"
                            + " Choose Yes(Y) to update, No(N) to continue. => Your choice: ")) {
                        while (true) {
                            double salary = Validation.inputDouble("Enter salary: ");
                            if (salary > 0) {
                                e.setSalary(salary);
                                break;
                            } else {
                                System.out.println("Salary must be bigger than 0! Re-enter.");
                            }
                        }
                    }
                    System.out.println("");
                    if (Validation.checkYesNo("Do you want to update egency?"
                            + " Choose Yes(Y) to update, No(N) to continue. => Your choice: ")) {
                        String Egency = Validation.inputString("Enter new egency: ");
                        e.setEgency(Egency);
                    }
                }

                mn.update(e);
                System.err.println("After update: ");
                Header();
                displayByID(e.getId());
            }
            if (!Validation.checkYesNo("Do you want to update another employees (Y/N)?"
                    + " Choose Yes(Y) to continue update, choose No(N) to return main screen.\n=> Your choice: ")) {
                break;
            }

            System.out.println("");

        }
    }

    public void removeEmp() {
        if (mn.getEmpList().isEmpty()) {
            System.err.println("Employees list is empty, you must add employee information first.\n");
            return;
        }

        while (true) {
            String id = Validation.inputString("Enter ID of employee you want to remove: ");
            if (mn.idExisted(id) != null) {
                mn.remove(id);
                System.err.println("After remove: ");
                Header();
                displayEmpList();
            } else {
                System.err.println("=> Not found employee with ID: " + id);
            }

            if (!Validation.checkYesNo("Do you want to remove another employees (Y/N)?"
                    + " Choose Yes(Y) to continue remove, choose No(N) to return main screen.\n=> Your choice: ")) {
                break;
            }
        }
    }

    public void searchEmp() {
        if (mn.getEmpList().isEmpty()) {
            System.err.println("Employees list is empty, you must add employee information first.\n");
            return;
        }

        while (true) {
            String key = Validation.inputString("Enter keyword you want to search: ");
            if (!mn.search(key).isEmpty()) {
                Header();
                for (Employees e : mn.search(key)) {
                    e.display();
                }
            } else {
                System.err.println("=> Not found employee with keyword: " + key);
            }

            if (!Validation.checkYesNo("Do you want to search another employees (Y/N)?"
                    + " Choose Yes(Y) to continue search, choose No(N) to return main screen.\n=> Your choice: ")) {
                break;
            }
        }
    }

    public void sortBySalary() {
        if (mn.getEmpList().isEmpty()) {
            System.err.println("Employees list is empty, you must add employee information first.\n");
            return;
        }
        System.err.println("Before sorting: ");
        Header();
        displayEmpList();
        System.out.println("");

        System.err.println("After sorting: ");
        mn.Sort();
        Header();
        displayEmpList();
    }

    public void displayEmpList() {
        for (Employees e : mn.getEmpList()) {
            e.display();
        }
    }

    public void displayByID(String id) {
        for (Employees e : mn.getEmpList()) {
            if (e.getId().equalsIgnoreCase(id)) {
                e.display();
                break;
            }
        }
    }

    public void Header() {
        System.out.printf("%-10s | %-11s | %-11s | %-13s | %-30s | %-18s | %-15s | %-8s | %-10s | %-15s\n",
                "ID", "First Name", "Last Name", "Phone Number", "Email", "Address", "D.O.B", "Sex", "Salary", "Egency");
    }
}
