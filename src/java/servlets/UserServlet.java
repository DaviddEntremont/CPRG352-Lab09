
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;


public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<User> users = null;
        UserService us = new UserService();
        List<Role> roles = null;
        RoleService rs = new RoleService();
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("view")) {
            
            try {
                char ch = '+';
                String email = request.getParameter("email");
                email = email.replace(' ',ch);
                User editUser = us.get(email);
                request.setAttribute("editUser", editUser);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(action != null && action.equals("delete")){
            
            try {
                char ch = '+';
                String email = request.getParameter("email");
                email = email.replace(' ',ch);
                us.delete(email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try {
            users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            roles = rs.getAll();
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        
        List<User> users = null;
        UserService us = new UserService();
        List<Role> roles = null;
        RoleService rs = new RoleService();
        
        try {
            
            String action = request.getParameter("action");
            
            switch(action){
                case "add":
                    String email = request.getParameter("email");
                    String fname = request.getParameter("fname");
                    String lname = request.getParameter("lname");
                    String password = request.getParameter("password");
                    int role = Integer.parseInt(request.getParameter("role"));
                    if(email.length() > 0 && fname.length() > 0 && lname.length() > 0 && password.length() > 0 && role > 0){
                    us.insert(email, 1, fname, lname, password, role);
                    }
                    break;
                case "save":
                    String editEmail = request.getParameter("editEmail");
                    String editFname = request.getParameter("editFname");
                    String editLname = request.getParameter("editLname");
                    String editPassword = request.getParameter("editPassword");
                    int editRole = Integer.parseInt(request.getParameter("editRole"));
                    if(editEmail.length() > 0 && editFname.length() > 0 && editLname.length() > 0 && editPassword.length() > 0 && editRole > 0){
                    us.update(editEmail, editRole, editFname, editLname, editPassword, editRole);
                    }
                    break;     
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            roles = rs.getAll();
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
