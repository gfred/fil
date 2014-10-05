package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class FriendsController extends Controller {
    public static Result getUserFriends() {
        return ok(index.render("get friends."));
    }
    
    public static Result createFriend() {
        return ok(index.render("create friend."));
    }

    public static Result deleteFriend() {
        return ok(index.render("delete friend."));
    }
}