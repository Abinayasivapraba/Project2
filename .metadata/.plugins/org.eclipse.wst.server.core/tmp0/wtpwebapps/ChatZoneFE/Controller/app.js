var app = angular.module("myApp",['ngRoute','ngCookies']);
app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'Header/Home.html'	
	})
	.when('/goRegister', {
		templateUrl : 'User/Register.html',
		controller : 'UserController'
	})
	.when('/login', {
		templateUrl : 'User/Login.html',
		controller : 'UserController'
	})
	.when('/blog', {
		templateUrl : 'Blog/Blog.html',
		controller : 'BlogController'
	})
	.otherwise({
		redirectTo : '/'
	});
});
app.config(function($httpProvider) {
	$httpProvider.defaults.headers.common = {};
	  $httpProvider.defaults.headers.post = {};
	  $httpProvider.defaults.headers.put = {};
	  $httpProvider.defaults.headers.patch = {};
	  //$httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
      $httpProvider.defaults.headers.post['Content-Type'] =  'application/json';
});
app.run( function ($rootScope, $location,$cookieStore, $http , $q) {
	

	 $rootScope.$on('$locationChangeStart', function (event, next, current) {/*
		 console.log("$locationChangeStart")
		 //http://localhost:8080/Collaboration/addjob
	        // redirect to login page if not logged in and trying to access a restricted page
	     
		 var userPages = ['/myProfile','/create_blog','/add_friend','/search_friend','/view_friend', '/viewFriendRequest','/chat']
		 var adminPages = ["/post_job","/manage_users"]
		 
		 var currentPage = $location.path()
		 
		 //will return 0 if current page is there in list
		 //else return -1
		 var isUserPage = $.inArray(currentPage, userPages)
		 var isAdminPage = $.inArray(currentPage, adminPages)
		 
		 var isLoggedIn = $rootScope.currentUser.id;
	        
	     console.log("isLoggedIn:" +isLoggedIn)
	     console.log("isUserPage:" +isUserPage)
	     console.log("isAdminPage:" +isAdminPage)
	        
	        if(!isLoggedIn)
	        	{
	        	
	        	 if (isUserPage===0 || isAdminPage ===0) {
		        	  console.log("Navigating to login page:")
		        	  alert("You need to loggin to do this operation")

						            $location.path('/');
		                }
	        	}
	        
			 else //logged in
	        	{
	        	
				 var role = $rootScope.currentUser.role;
				 
				 if(isAdminPage===0 && role!='admin' )
					 {
					 
					  alert("You can not do this operation as you are logged as : " + role )
					   $location.path('/');
					 
					 }
				     
	        	
	        	}*/
	        
	 }
	       );
	 
	 /*
	 // keep user logged in after page refresh
    $rootScope.currentUser = $cookieStore.get('currentUser') || {};
    if ($rootScope.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser; 
    }*/

});