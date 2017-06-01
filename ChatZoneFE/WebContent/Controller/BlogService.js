

app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("BlogService...")
	var BASE_URL='http://localhost:8083/ChatZoneRestService/'
		
		return {
		createBlog: function(blog) {
			console.log("Inside createBlog function in BlogService")
			return $http.post(BASE_URL+'createblog/', blog)
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
		
		fetchAllBlogs: function(){
			
        	console.log("fetchAllBlogs Function Being Called")
                return $http.get(BASE_URL+'bloglist')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while fetching all blogs please try again');
                                    return $q.reject(errResponse);
                                }
                        );
        		},
        		getBlogById : function(blogid) {
        			console.log("Getting blog by id")
        			return $http.post(BASE_URL+'getBlogById/'+blogid)
        			.then(
        					function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while getting blog');
                                return $q.reject(errResponse);
                            });
        		},
        		updateBlog: function(blog){
                	console.log("updateBlog Function Being Called")
                        return $http.post(BASE_URL+'blogUpdate/', blog)
                                .then(
                                        function(response){
                                            return response.data;
                                        }, 
                                        function(errResponse){
                                            console.error('Error while updating blog please try again');
                                            return $q.reject(errResponse);
                                        }
                                );
                		},
        		deleteBlog: function(blogid){
                	console.log("deleteBlog Function Being Called")
                        return $http.get(BASE_URL+'removeBlog/'+blogid)
                                .then(
                                        function(response){
                                            return response.data;
                                        }, 
                                        function(errResponse){
                                            console.error('Error while deleting blog please try again');
                                            return $q.reject(errResponse);
                                        }
                                );
                		},
                		
                		fetchBlogById: function(blog){
                        	console.log("fetchBlogById Function Being Called")
                                return $http.post(BASE_URL+'BlogById/',blog)
                                        .then(
                                                function(response){
                                                    return response.data;
                                                }, 
                                                function(errResponse){
                                                    console.error('Error while fetching blogs by id please try again');
                                                    return $q.reject(errResponse);
                                                }
                                        );
                        		},

    
        		}
        	

        	
        		
        		
        		

		
	}])