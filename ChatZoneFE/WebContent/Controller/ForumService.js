

app.service('ForumService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	console.log("ForumService...")
	var BASE_URL='http://localhost:8083/ChatZoneRestService/'
		
		return {
		createForum: function(forum) {
			console.log("Inside createForum function in ForumService")
			return $http.post(BASE_URL+'createforum/', forum)
			.then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating forum');
                        return $q.reject(errResponse);
                    }
            );
		},
		updateForum : function(forum){
			console.log("Updating forum")
			return $http.post(BASE_URL+'ForumUpdate/',forum)
			.then(
					function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while getting forum');
                        return $q.reject(errResponse);
                    });
		},
		
fetchAllForums: function(){
			
        	console.log("fetchAllBlogs Function Being Called")
                return $http.get(BASE_URL+'forumlist')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while fetching all forums please try again');
                                    return $q.reject(errResponse);
                                }
                        );
        		},
			
		
		
		deleteForum: function(forumid){
        	console.log("deleteForum Function Being Called")
                return $http.get(BASE_URL+'removeForum/'+forumid)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while deleting forum please try again');
                                    return $q.reject(errResponse);
                                }
                        );
        		},
        		
        		
        		
        		
        		fetchForumById: function(forum){
                	console.log("fetchForumById Function Being Called")
                        return $http.post(BASE_URL+'ForumById/',forum)
                                .then(
                                        function(response){
                                            return response.data;
                                        }, 
                                        function(errResponse){
                                            console.error('Error while fetching forum by id please try again');
                                            return $q.reject(errResponse);
                                        }
                                );
                		},
                		
                		
                		
                		
                		
                		
                		

	};
		
	
	
	
	
	
	
	
	
	
		
		
		
		
		
	}])