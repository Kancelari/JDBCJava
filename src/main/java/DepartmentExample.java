import model.Department;
import repository.DepartmentRepository;

public class DepartmentExample {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
        Department department = departmentRepository.findById(1);
        if(department != null){
            System.out.println(department.toString());
        }
        else{
            System.out.println("Department not found");
        }
    }
}
