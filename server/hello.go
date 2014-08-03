package server

import (
	"net/http"
	"time"
	"encoding/json"
	
	"github.com/go-martini/martini"
	"github.com/codegangsta/martini-contrib/binding"
	
	"appengine"
	"appengine/datastore"
)

type User struct {
	Date    		time.Time
	Name 			string
	LastName		string
	DisplayName		string

	PushToken 		string
	
	FacebookId		string
	GooglePlusid	string
	TwitterId		string
	
	Mobile			string
	Mail			string	
}

type Message struct {
	Date 			int64
	Message 		string
	Lat 			float64
	Lon				float64	
	
	FromUserId		int64
	FromUserIdDel	bool
	
	ToUserId		int64
	ToUserIdSeen	bool
	ToUserIdDel		bool	
}

func userKey(context appengine.Context) *datastore.Key {
        // The string "default_guestbook" here could be varied to have multiple guestbooks.
        return datastore.NewKey(context, "User", "default_users", 0, nil)
}

func init() {
	m := martini.Classic()
		
	// <-- Get all users
	m.Get("/users", func(writer http.ResponseWriter, request *http.Request) string {
		context := appengine.NewContext(request)
		
		var users []User
		
		if _, err := datastore.NewQuery("User").GetAll(context, &users); err != nil {
            http.Error(writer, err.Error(), http.StatusInternalServerError)
            return ""
        }
				
		jsonResult, err := json.Marshal(users)
		
		if err != nil {
			http.Error(writer, err.Error(), http.StatusInternalServerError)
			return ""
		}
		
		return string(jsonResult)
	})
	// -->
		
	// Create new user
	m.Post("/users", binding.Json(User{}), func(writer http.ResponseWriter, request *http.Request, newUser User) string {
		context := appengine.NewContext(request)
		
		key := datastore.NewIncompleteKey(context, "User", userKey(context))
		_, err := datastore.Put(context, key, &newUser)
		
		if err != nil {
			http.Error(writer, err.Error(), http.StatusInternalServerError)
			return ""
		} 
		
		// return http status code with user id
		return newUser.Name 		
	})
	// -->
	
	http.Handle("/", m)
}
