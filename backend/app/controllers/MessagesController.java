package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class MessagesController extends Controller {
    public static Result getAllUserMessages() {
        return ok(index.render("all messages."));
    }
    
    public static Result createNewMessage() {
        return ok(index.render("create message."));
    }

    public static Result getMessage() {
        return ok(index.render("get message"));
    }
    
    public static Result deleteMessage() {
        return ok(index.render("delete message"));
    }   
}