'use strict';

app.service('UserService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("UserService...")
	var BASE_URL='http://localhost:8083/ChatZoneRestService/'
		
		return {
		createUser: function(user) {
			console.log("Inside createUser function in UserService")
			return $http.post(BASE_URL+'addUser/', user)
			.then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
            );
		},
		validateUser: function(user) {
			console.log("Inside UserValidation")
			return $http.post(BASE_URL+'/ValidateUserLogin', user)
			.then(
                    function(response){
                    	console.log("function response")
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while validating user');
                        return $q.reject(errResponse);
                    }
            );
		},
		
		
		UserLogout: function(user) {
			console.log("Inside UserValidation")
			return $http.get(BASE_URL+'/ValidateUserLogout', user)
			.then(
                    function(response){
                    	console.log("Logout Function")
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error in user logout');
                        return $q.reject(errResponse);
                    }
            );
		},
	
	
	};
	
}])