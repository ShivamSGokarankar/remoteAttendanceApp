package com.attendanceapp.controller;

import com.attendanceapp.model.UserDTO;
import com.attendanceapp.Service.UserService;
import com.attendanceapp.Util.InfoMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.logger.LogFileCreator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.tool.schema.extract.spi.InformationExtractor;

import java.io.IOException;

@WebServlet(urlPatterns = {"/api/*"})
public class ControllerServlet extends HttpServlet {
        LogFileCreator l;
        HttpServletRequest request;
        HttpServletResponse response;

    @Override
    public void init() throws ServletException
    {
        try {
            l=new LogFileCreator("D:\\logs");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        final String request_path=request.getPathInfo();
        String RequestBody = (request.getReader().lines().reduce("", String::concat)).replaceAll("\\s", "");
        l.WriteLog(InfoMessage.Request.toString() + " : " + RequestBody);
        UserDTO userDTO = new GsonBuilder().create().fromJson(RequestBody,UserDTO.class);
        this.request=request;
        this.response=response;
        switch (request_path)
        {
            case "/userlogin":
                validateUser(userDTO);
                break;
            case "/usersignup":
                registerUser(userDTO);
        }
    }

    public void validateUser(UserDTO userDTO)
    {
        UserService service = new UserService();
        try {
            UserDTO fetchedUserDTO=service.getUser(userDTO);
            if(fetchedUserDTO!=null)
            {
//                Gson gson = new GsonBuilder().create();
//                String jsondata=gson.toJson(fetchedUserDTO);
//                l.WriteLog(InfoMessage.User_Logged_In.name());
//                this.response.getWriter().write(jsondata);
//            l.WriteLog(InfoMessage.Response.toString() + " : " + jsondata.replaceAll("\\s", ""));
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(fetchedUserDTO);
                jsonElement.getAsJsonObject().addProperty("LoginFlag","TRUE");
                jsonElement.getAsJsonObject().remove("password");
                l.WriteLog(InfoMessage.Response.name() + " : " + gson.toJson(jsonElement));
                this.response.getWriter().write(gson.toJson(jsonElement));

            }
            else
            {
                //redirect to login page
                l.WriteLog(InfoMessage.User_Not_Found.name());
                l.WriteLog(InfoMessage.Invalid_Username_OR_Password.name());
                Gson gson = new Gson();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("LoginFlag","FALSE");
                this.response.getWriter().write(gson.toJson(jsonObject));
            }
        }
        catch (NullPointerException a)
        {
            l.WriteLog(InfoMessage.Error_Occured_While_fetching_user.name());
        }
        catch ( IOException e)
        {
            l.WriteLog("Error occured while generating response.");
        }
    }

    public void registerUser(UserDTO userDTO) throws IOException {
       UserService service = new UserService();
       UserDTO fetchedUser= service.getUser(userDTO);
       response.setContentType("application/json");
        try {
            JsonObject jsonObject = new JsonObject();
            if (fetchedUser == null) {
                boolean flag = service._insertUser(userDTO);


                if (flag) {
                    jsonObject.addProperty("RegistrationFlag","1");
                    this.response.getWriter().write(new Gson().toJson(jsonObject));
                } else {

                    response.setStatus(400);
                    jsonObject.addProperty("RegistrationFlag", "0");
                    this.response.getWriter().write(new Gson().toJson(jsonObject));
                }
            } else {
                response.setStatus(400);
                jsonObject.addProperty("RegistrationFlag", "-1");
                this.response.getWriter().write(new Gson().toJson(jsonObject));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

