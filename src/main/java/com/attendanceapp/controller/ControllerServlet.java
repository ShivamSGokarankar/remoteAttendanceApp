package com.attendanceapp.controller;

import com.attendanceapp.model.UserDTO;
import com.attendanceapp.Service.UserService;
import com.attendanceapp.Util.InfoMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        }
    }

    public void validateUser(UserDTO userDTO)
    {
        UserService service = new UserService();
        try {
            if(service.getUser(userDTO)!=null)
            {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsondata=gson.toJson(userDTO);
                l.WriteLog(InfoMessage.User_Logged_In.name());
                this.response.getWriter().write(jsondata);
            l.WriteLog(InfoMessage.Response.toString() + " : " + jsondata.replaceAll("\\s", ""));}
            else
            {
                //redirect to login page
                l.WriteLog(InfoMessage.User_Not_Found.name());
                l.WriteLog(InfoMessage.Invalid_Username_OR_Password.name());
                this.response.getWriter().write(InfoMessage.User_Not_Found.name());
            }
        }
        catch (NullPointerException a)
        {
            l.WriteLog(InfoMessage.Error_Occured_While_fetching_user.name());
        }
        catch (NoClassDefFoundError e)
        {

        }
        catch ( IOException e)
        {
            l.WriteLog("Error occured while generating response.");
        }
    }
}

