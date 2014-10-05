package controllers;

import play.*;
import play.mvc.*;
import play.libs.Json;
import play.mvc.BodyParser;

import models.User;

import java.util.*;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;

public class UserController extends Controller {
    public static Result getAllUser() {
        final List<User> users = User.find.all();
        return ok(Json.toJson(users));
    }
    
    public static Result createUser() {
        if(request().body() == null) {
            return badRequest();
        }
        
        // throw if content-type != application/json
        if(request().body().asJson() == null) {
            return badRequest();
        }
        
        final User newUser = Json.fromJson(request().body().asJson(), User.class);
        
        if(newUser == null) {
            return badRequest();
        } 
        
        newUser.save();
        response().setHeader("Location", "users/" + newUser.id);
        return created(Json.toJson(newUser));
    }

    public static Result getUser(final Long id) {
        if(id == null || id <= 0L) {
            return badRequest();
        }
        
        final User user = User.find.byId(id);
        
        if(user == null) {
            return notFound();
        }
        
        return ok(Json.toJson(user));
    }
    
    public static Result updateUser(final Long id) {
        // final User user = Json.fromJson(request().body().asJson(), User.class);
        // final User updated = Database.updateUser(id, user);
        // return ok(Json.toJson(updated));
        return ok(index.render("update user: " + id));
    }
    
    public static Result deleteUser(final Long id) {
        User.find.ref(id).delete();
        return noContent();
    }
}