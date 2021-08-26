package j1.s.p0101.employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Yankee
 */
public class Managermant {

    private ArrayList<Employees> empList;

    public Managermant() {
    }

    public Managermant(ArrayList<Employees> empList) {
        this.empList = empList;
    }

    public ArrayList<Employees> getEmpList() {
        return empList;
    }

    public void addEmp(Employees e) {
        empList.add(e);
    }

    public Employees idExisted(String id) {
        for (Employees employees : empList) {
            if (employees.getId().equalsIgnoreCase(id)) {
                return employees;
            }
        }
        return null;
    }

    public void update(Employees e) {
        for (int i = 0; i < empList.size(); i++) {
            if (e.getId().equalsIgnoreCase(empList.get(i).getId())) {
                empList.set(i, e);
                break;
            }
        }
    }

    public void remove(String id) {
        for (Employees employees : empList) {
            if (employees.getId().equalsIgnoreCase(id)) {
                empList.remove(employees);
                break;
            }
        }
    }

    public ArrayList<Employees> search(String s) {
        ArrayList<Employees> searchList = new ArrayList<>();

        for (Employees e : empList) {
            String fullName = e.getFirstName() + " " + e.getLastName();
            if (fullName.toLowerCase().contains(s.toLowerCase())) {
                searchList.add(e);
            }
        }   

        return searchList;
    }
    
    public void Sort(){
        Collections.sort(empList, new  Comparator<Employees>() {
            @Override
            public int compare(Employees o1, Employees o2) {
                if (o1.getSalary() - o2.getSalary() > 0) {
                    return 1;
                } else if (o1.getSalary() - o2.getSalary() < 0){
                    return -1;
                } else return 0;
            }
        });
    }

}
