'use strict';
app.controller('BlogController',['$scope','BlogService','$location','$rootScope','$cookieStore','$http',
	function($scope, BlogService, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside blogController")
	this.blog={
		id : '',
		blogid : '',
		title : '',
		description : '',
		datetime : '',
		reason : '',
		status : ''
	}
	this.createBlog = function(blog) {
		console.log("Inside createblog function of blogController");
		BlogService.createBlog(blog)
		.then(
				function(d) {
					$location.path("/blog")
				},
				function(errResponse) {
					console.error('Error while creating blog');
				});
	};
	this.create = function() {
		{
		console.log("Submit blog",this.blog);
		this.createBlog(this.blog);
		}
		
	
	};

	
	

	
	


	
	

}])
	