'use strict';

app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("BlogService...")
	var BASE_URL='http://localhost:8083/ChatZoneRestService/'
		
		return {
		createBlog: function(blog) {
			console.log("Inside createBlog function in BlogService")
			return $http.post(BASE_URL+'blog/', blog)
			.then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating blog');
                        return $q.reject(errResponse);
                    }
            );
		},
		};
	}])