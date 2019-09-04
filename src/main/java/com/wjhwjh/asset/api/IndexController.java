package com.wjhwjh.asset.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wjhwjh
 * @description a
 * Created in 15:32 2019/9/2
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping("/login")
    public String login_1(HttpServletResponse response) throws IOException {
        return "login-1";
    }

    @RequestMapping("/login-2")
    public String login_2(HttpServletResponse response) throws IOException {
        return "login-2";
    }

    @RequestMapping("/index")
    public String index(HttpServletResponse response) throws IOException {
        return "index";
    }

    @RequestMapping("/welcome-1")
    public String welcome_1(HttpServletResponse response) throws IOException {
        return "welcome-1";
    }

    @RequestMapping("/welcome-2")
    public String welcome_2(HttpServletResponse response) throws IOException {
        return "welcome-2";
    }

    @RequestMapping("/404")
    public String notFound(HttpServletResponse response) throws IOException {
        return "404";
    }

    @RequestMapping("/button")
    public String button(HttpServletResponse response) throws IOException {
        return "button";
    }

    @RequestMapping("/editor")
    public String editor(HttpServletResponse response) throws IOException {
        return "editor";
    }

    @RequestMapping("/form")
    public String form(HttpServletResponse response) throws IOException {
        return "form";
    }

    @RequestMapping("/form-step")
    public String form_step(HttpServletResponse response) throws IOException {
        return "form-step";
    }

    @RequestMapping("/icon")
    public String icon(HttpServletResponse response) throws IOException {
        return "icon";
    }

    @RequestMapping("/icon-picker")
    public String icon_picker(HttpServletResponse response) throws IOException {
        return "icon-picker";
    }

    @RequestMapping("/layer")
    public String layer(HttpServletResponse response) throws IOException {
        return "layer";
    }

    @RequestMapping("/menu")
    public String menu(HttpServletResponse response) throws IOException {
        return "menu";
    }

    @RequestMapping("/setting")
    public String setting(HttpServletResponse response) throws IOException {
        return "setting";
    }

    @RequestMapping("/table")
    public String table(HttpServletResponse response) throws IOException {
        return "table";
    }

    @RequestMapping("/table-select")
    public String table_select(HttpServletResponse response) throws IOException {
        return "table-select";
    }

    @RequestMapping("/color-select")
    public String color_select(HttpServletResponse response) throws IOException {
        return "color-select";
    }

    @RequestMapping("/upload")
    public String upload(HttpServletResponse response) throws IOException {
        return "upload";
    }

    @RequestMapping("/user-password")
    public String user_password(HttpServletResponse response) throws IOException {
        return "user-password";
    }

    @RequestMapping("/user-setting")
    public String user_setting(HttpServletResponse response) throws IOException {
        return "user-setting";
    }

}
