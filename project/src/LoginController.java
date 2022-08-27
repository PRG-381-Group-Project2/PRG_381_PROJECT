public class LoginController {
    public static boolean CheckAdmin(LoginCredentials login){
        if(login.getUsername().equals("admin") && login.getPassword().equals("admin")){
            return true;
        }
        return false;
    }
    public static boolean CheckStudent(LoginCredentials login){
        if(login.getUsername().equals("student") && login.getPassword().equals("student")){
            return true;
        }
        return false;
    }
}